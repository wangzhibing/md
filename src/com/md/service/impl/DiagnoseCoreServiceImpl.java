package com.md.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.md.common.Constant;
import com.md.common.DateUtil;
import com.md.common.MedicinalValue;
import com.md.common.SIVComparable;
import com.md.entity.BasePrescriptionValue;
import com.md.entity.Customer;
import com.md.entity.Diagnose;
import com.md.entity.DiagnoseDetail;
import com.md.entity.DiagnoseResult;
import com.md.entity.SymptomItemValue;
import com.md.entity.SymptomPrescriptionValue;
import com.md.mapper.DiagnoseMapper;
import com.md.service.BasePrescriptionService;
import com.md.service.BwService;
import com.md.service.ByService;
import com.md.service.DiagnoseCoreService;
import com.md.service.MedicinalService;
import com.md.service.SymptomItemValueService;
import com.md.service.SymptomPrescriptionService;

/**
 * 症状条目数值表服务层
 * @author owen
 */
@Service
@Transactional  
public class DiagnoseCoreServiceImpl implements DiagnoseCoreService {

	Logger logger = Logger.getLogger(DiagnoseCoreServiceImpl.class);
	
	@Resource
	private DiagnoseMapper diagnoseMapper;
	
	@Resource
	private ByService byService;
	
	@Resource
	private BwService bwService;
	
	@Resource
	private BasePrescriptionService basePrescriptionService;
	
	@Resource
	private SymptomPrescriptionService symptomPrescriptionService;
	
	@Resource
	private SymptomItemValueService symptomItemValueService;
	
	@Resource
	private MedicinalService medicinalService;
	
	private static final String wby[] = {"W1","W2","W3","W4","W5","W6","W7","W8","W9"};
	
	
	/**
	 * app端访问数据(主要传入症状信息、主症状)
	 * @param symptomItems
	 * @param mainSymptom
	 * @return
	 * @throws Exception
	 */
	public DiagnoseResult doDiagnoseByApp(String[] symptomItems,String mainSymptom)  throws Exception{
		logger.info("处理诊断业务信息开始。。。");
		try {
			//1、获取诊断结果信息
			DiagnoseResult diagnoseResult = this.doDiagnoseResult(symptomItems, mainSymptom);
			
			//2、对比业务处理
			
			
			logger.info("处理诊断业务信息结束。。。");
			return diagnoseResult;
		} catch (Exception e) {
			logger.info("处理诊断业务信息异常。。。"+e);
			throw new Exception("msg.operation.fail");
		}
	}
	
	
	
	/**
	 *  获取诊断结果
	 * @param symptomItems
	 * @param mainSymptom
	 * @return
	 * @throws Exception
	 */
	private DiagnoseResult doDiagnoseResult(String[] symptomItems,String mainSymptom)  throws Exception{

		logger.info("App处理诊断业务信息开始。。。");
		try {
			
			//1、根据传入的诊断信息，根据核心处理方法，得出诊断结果。
			List<SymptomItemValue> selectListSiv = symptomItemValueService.querySymptomItemValueInfoByArray(symptomItems);
			
			//2、如果勾选的病症，含有相同条目值，目前不做处理，只考虑其会出现一种条目值 获取所有的条目信息value(叠加)
			Map<String, Float> sivMap = new HashMap<String, Float>();
			this.getSivValue(selectListSiv, sivMap);
			
			//3、取第一、第二大病位，病症
			DiagnoseResult diagnoseResult = this.doAchieveBwBy(sivMap);
			
			//4、获取处方药材信息
			diagnoseResult = this.doAchievePrescription(diagnoseResult,mainSymptom);
			
			/**5、拿临时药方 与 中成药库曲比对数据
			 * 5.1、
			 * 
			 * 
			 * 
			 * 
			 */
			 
			
			
			
			
			
			logger.info("处理诊断业务信息结束。。。");
			return diagnoseResult;
		} catch (Exception e) {
			logger.info("处理诊断业务信息异常。。。"+e);
			throw new Exception("msg.operation.fail");
		}
	}
	
	
	
	/**
	 * 页面方法进入
	 * 核心诊断
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DiagnoseResult doDiagnose(String[] symptomItems,String mainSymptom,Customer loginCustomer,String sex) throws Exception{
		logger.info("Web处理诊断业务信息开始。。。");
		String currenyDate = DateUtil.date2String(new Date(), Constant.PATTERN_4);
		String currenyDate_date = currenyDate.substring(0, 8);
		String currenyDate_time = currenyDate.substring(8, currenyDate.length());
		try {
			//1、插入诊断信息
			logger.info("插入诊断信息");
			Diagnose diagnose = null;
			Long customerId = null;
			//默认初诊
			Integer is_first_diagnose = Constant.IS_FIRST_DIAGNOSE_1;
			if(null == loginCustomer){
				diagnose = new Diagnose(Constant.ANONYMITY_CUSTOMER_ID,currenyDate_date,currenyDate_time);
				customerId = Constant.ANONYMITY_CUSTOMER_ID;
			}
			else{
				diagnose = new Diagnose(loginCustomer.getId(),currenyDate_date,currenyDate_time);
				customerId = loginCustomer.getId();
				//sex = String.valueOf(loginCustomer.getSex());
				//得去后台查找，他以前是否诊断过，若有诊断则是复诊，若没有则是初诊
				Map<String,Object> mapParams = new HashMap<String, Object>();
				Diagnose queryDiagnose = new Diagnose();
				queryDiagnose.setCustomer_id(customerId);
				mapParams.put("domain", queryDiagnose);
				int diagnoseCount = diagnoseMapper.selectDiagnoseCount(mapParams);
				if(diagnoseCount > 0){
					is_first_diagnose = Constant.IS_FIRST_DIAGNOSE_2;
				}
			}
			
			diagnose.setChannel_type(Constant.CHANNEL_TYPE_1);
			diagnoseMapper.insertDiagnose(diagnose);
			
			//2、插入诊断明细信息
			List<DiagnoseDetail> diagnoseDetailList = new ArrayList<DiagnoseDetail>();
			DiagnoseDetail diagnoseDetail = null;
			for(String symptomItem : symptomItems){
				diagnoseDetail = new DiagnoseDetail(diagnose.getId(),Long.parseLong(symptomItem),
													symptomItemValueService.querySingleSIVName(symptomItem));
				if(!StringUtils.isBlank(mainSymptom) && symptomItem.equals(mainSymptom)){
					//设置症状等级
					diagnoseDetail.setLevel(Constant.DIAGNOSE_DETAIL_LEVEL_1);
				}
				diagnoseDetailList.add(diagnoseDetail);
			}
			diagnoseMapper.insertDiagnoseDetail(diagnoseDetailList);
			
			//3、根据传入的诊断信息，根据核心处理方法，得出诊断结果。
			List<SymptomItemValue> selectListSiv = symptomItemValueService.querySymptomItemValueInfoByArray(symptomItems);
			
			//4、如果勾选的病症，含有相同条目值，目前不做处理，只考虑其会出现一种条目值 获取所有的条目信息value(叠加)
			Map<String, Float> sivMap = new HashMap<String, Float>();
			this.getSivValue(selectListSiv, sivMap);
			
			//5、取第一、第二大病位，病症
			DiagnoseResult diagnoseResult = this.doAchieveBwBy(sivMap);
			diagnoseResult.setSex(Integer.parseInt(sex));
			diagnoseResult.setIs_first_diagnose(is_first_diagnose);
			
			//6、获取处方药材信息
			diagnoseResult = this.doAchievePrescription(diagnoseResult,mainSymptom);
			
			//7、插入诊断结果信息
			diagnoseResult.setDiagnose_id(diagnose.getId());
			diagnoseResult.setCustomer_id(customerId);
			diagnoseResult.setDiagnose_result_date(currenyDate_date);
			diagnoseResult.setDiagnose_result_time(currenyDate_time);
			diagnoseMapper.insertDiagnoseResult(diagnoseResult);
			logger.info("处理诊断业务信息结束。。。");
			return diagnoseResult;
		} catch (Exception e) {
			logger.info("处理诊断业务信息异常。。。"+e);
			throw new Exception("msg.operation.fail");
		}
	}
	
	/**
	 * 获取所有的sivValue值（客户勾选的症状）
	 * @param selectListSiv
	 * @param sivMap
	 */
	private void getSivValue(List<SymptomItemValue> selectListSiv ,Map<String, Float> sivMap ){
		for(SymptomItemValue siv : selectListSiv){
			getDistinceSivValue(siv.getValue1(), sivMap);
			getDistinceSivValue(siv.getValue2(), sivMap);
			getDistinceSivValue(siv.getValue3(), sivMap);
			getDistinceSivValue(siv.getValue4(), sivMap);
			getDistinceSivValue(siv.getValue5(), sivMap);
			getDistinceSivValue(siv.getValue6(), sivMap);
			getDistinceSivValue(siv.getValue7(), sivMap);
			getDistinceSivValue(siv.getValue8(), sivMap);
			getDistinceSivValue(siv.getValue9(), sivMap);
			getDistinceSivValue(siv.getValue10(), sivMap);
		}
	}
	
	/**
	 * 对每条记录中的每个单元格进行统计  Q1X=0.5
	 * 获取sivValue值，把相同的值叠加
	 * @param sivValue
	 * @param sivMap
	 */
	private void getDistinceSivValue(String sivValue,Map<String, Float> sivMap){
		if(!StringUtils.isBlank(sivValue)){
			String[] xyValue = sivValue.split("=");
			String xyItemValue = xyValue[0];
			Float value = Float.parseFloat(xyValue[1]);
			
			//对y轴的值进行判断赋值
			if(null == sivMap.get(xyItemValue)){
				sivMap.put(xyItemValue, value);
			}
			else{
				//相同值进行叠加
				sivMap.put(xyItemValue, sivMap.get(xyItemValue)+value);
			}
		}
	}
	
	/**
	 * 获取第一、第二病因、病位
	 * 这块逻辑有点复杂，到时在写详细描述
	 * 注释已经写得相当详细，懂代码的人可以看懂业务
	 * @param sivMap
	 * @return
	 */
	private DiagnoseResult doAchieveBwBy(Map<String, Float> sivMap){
		DiagnoseResult diagnoseResult = new DiagnoseResult();
		
		Map<String, List<Float>> xWBYMap = new HashMap<String, List<Float>>();  //外病因数据集合   每个外病因对应的数值集合
		Map<String, List<Float>> xNBYMap = new HashMap<String, List<Float>>();  //内病因数据集合   每个内病因对应的数值集合
		Map<String, List<Float>> yWBWMap = new HashMap<String, List<Float>>();  //外病位数据集合   每个外病位对应的数值集合
		Map<String, List<Float>> yNBWMap = new HashMap<String, List<Float>>();  //内病位数据集合   每个内病位对应的数值集合
		
		List<SIVComparable> xWBYListSum = new ArrayList<SIVComparable>();       //外病因数据集合小计之后排序
		List<SIVComparable> xNBYListSum = new ArrayList<SIVComparable>();		//内病因数据集合小计之后排序
		List<SIVComparable> yWBWListSum = new ArrayList<SIVComparable>();		//外病位数据集合小计之后排序
		List<SIVComparable> yNBWListSum = new ArrayList<SIVComparable>();		//内病位数据集合小计之后排序
		
		//算法，统计其第一最大值,第二最大值
		List<Float> xWBYValueList = null;   //外病因对应的数值数组
		List<Float> xNBYValueList = null;   //内病因对应的数值数组
		List<Float> yWBWValueList = null;   //外病位对应的数值数组
		List<Float> yNBWValueList = null;   //内病位对应的数值数组
		for(Map.Entry<String, Float> sivEntry : sivMap.entrySet()){
			//循环单元格数值信息 A2X
			String xyItemValue = sivEntry.getKey();                        //单元格名称(A2X)
			Float value = sivEntry.getValue();   						   //单元格数值
			String yValue = xyItemValue.substring(0,2); 				   //单元格Y轴名称(A2)  --病位
			String xValue = xyItemValue.substring(2,xyItemValue.length()); //单元格X轴名称(X)  --病因
			
			xWBYValueList = xWBYMap.get(xValue);
			xNBYValueList = xNBYMap.get(xValue);
			yWBWValueList = yWBWMap.get(yValue);
			yNBWValueList = yNBWMap.get(yValue);
			
			//把外、内病因统计到一个map集合中(String,List<Folat>)
			List<String> wbyList = Arrays.asList(wby);
			if(wbyList.contains(xValue)){
				//外病因
				//对y轴的值进行判断赋值 --外病位
				if(yWBWValueList == null || yWBWValueList.size() == 0){
					yWBWValueList = new ArrayList<Float>();
				}
				
				yWBWValueList.add(value);
				yWBWMap.put(yValue, yWBWValueList);
				
				//对x轴的值进行判断赋值  -- 外病因
				if(xWBYValueList == null || xWBYValueList.size() == 0){
					xWBYValueList = new ArrayList<Float>();
				}
				
				xWBYValueList.add(value);
				xWBYMap.put(xValue, xWBYValueList);
			}
			else{
				//内病因
				//对y轴的值进行判断赋值  --内病位
				if(yNBWValueList == null || yNBWValueList.size() == 0){
					yNBWValueList = new ArrayList<Float>();
				}
				
				yNBWValueList.add(value);
				yNBWMap.put(yValue, yNBWValueList);
				
				//对x轴的值进行判断赋值  -- 内病因
				if(xNBYValueList == null || xNBYValueList.size() == 0){
					xNBYValueList = new ArrayList<Float>();
				}
				
				xNBYValueList.add(value);
				xNBYMap.put(xValue, xNBYValueList);
			}
		}
		
		//把外、内病因统计到一个map集合中(String ,Float),汇总后的
		SIVComparable sivComparable = null;
		//对外病因数值进行小计，并对小计后数据进行封装比较 
		for(Map.Entry<String, List<Float>> mapEntry : xWBYMap.entrySet()){
			String itemValue = mapEntry.getKey();
			List<Float> listFloat = mapEntry.getValue();
			Float sumValue = 0.0f;
			for(Float v : listFloat){
				sumValue += v;
			}
			sivComparable = new SIVComparable();
			sivComparable.setSivName(itemValue);
			sivComparable.setValue(sumValue);
			xWBYListSum.add(sivComparable);
		}
		
		//对内病因数值进行小计，并对小计后数据进行封装比较 
		for(Map.Entry<String, List<Float>> mapEntry : xNBYMap.entrySet()){
			String itemValue = mapEntry.getKey();
			List<Float> listFloat = mapEntry.getValue();
			Float sumValue = 0.0f;
			for(Float v : listFloat){
				sumValue += v;
			}
			sivComparable = new SIVComparable();
			sivComparable.setSivName(itemValue);
			sivComparable.setValue(sumValue);
			xNBYListSum.add(sivComparable);
		}
		
		//对外病位数值进行小计，并对小计后数据进行封装比较 
		for(Map.Entry<String, List<Float>> mapEntry : yWBWMap.entrySet()){
			String itemValue = mapEntry.getKey();
			List<Float> listFloat = mapEntry.getValue();
			Float sumValue = 0.0f;
			for(Float v : listFloat){
				sumValue += v;
			}
			sivComparable = new SIVComparable();
			sivComparable.setSivName(itemValue);
			sivComparable.setValue(sumValue);
			yWBWListSum.add(sivComparable);
		}
		
		//对内病位数值进行小计，并对小计后数据进行封装比较 
		for(Map.Entry<String, List<Float>> mapEntry : yNBWMap.entrySet()){
			String itemValue = mapEntry.getKey();
			List<Float> listFloat = mapEntry.getValue();
			Float sumValue = 0.0f;
			for(Float v : listFloat){
				sumValue += v;
			}
			sivComparable = new SIVComparable();
			sivComparable.setSivName(itemValue);
			sivComparable.setValue(sumValue);
			yNBWListSum.add(sivComparable);
		}
		
		//对小计数据进行倒序排序
		Collections.sort(xWBYListSum, Collections.reverseOrder());
		Collections.sort(xNBYListSum, Collections.reverseOrder());
		Collections.sort(yWBWListSum, Collections.reverseOrder());
		Collections.sort(yNBWListSum, Collections.reverseOrder());
		
		//4.1 插入诊断结果信息
		//外病因
		String out_by_code = "";
		String out_by_name = "";
		Float out_by_value = null;
		
		if(xWBYListSum.size() >=1 ){
			out_by_code = xWBYListSum.get(0).getSivName();
		    out_by_value = xWBYListSum.get(0).getValue();
		    out_by_name = byService.querySingleByName(out_by_code);
		}
		
		//外病位
		String out_bw_code = "";
		String out_bw_name = "";
		Float out_bw_value = null;
		if(yWBWListSum.size() >=1 ){
			out_bw_code = yWBWListSum.get(0).getSivName();
			out_bw_value = yWBWListSum.get(0).getValue();
			out_bw_name = bwService.querySingleBwName(out_bw_code);
		}
		
		//内病因
		String in_by_first_code = "";
		String in_by_first_name = "";
		Float in_by_first_value = null;
		String in_by_second_code = "";
		String in_by_second_name = "";
		Float in_by_second_value = null;
		if(xNBYListSum.size() >=1 ){
			in_by_first_code = xNBYListSum.get(0).getSivName();
			in_by_first_value = xNBYListSum.get(0).getValue();
			in_by_first_name = byService.querySingleByName(in_by_first_code);
		    if(xNBYListSum.size() >= 2){
		    	in_by_second_code = xNBYListSum.get(1).getSivName();
		    	in_by_second_value = xNBYListSum.get(1).getValue();
		    	in_by_second_name = byService.querySingleByName(in_by_second_code);
		    }
		}
		
		//内病位
		String in_bw_first_code = "";
		String in_bw_first_name = "";
		Float in_bw_first_value = null;
		String in_bw_second_code = "";
		String in_bw_second_name = "";
		Float in_bw_second_value = null;
		if(yNBWListSum.size() >=1 ){
			in_bw_first_code = yNBWListSum.get(0).getSivName();
			in_bw_first_value = yNBWListSum.get(0).getValue();
			in_bw_first_name = bwService.querySingleBwName(in_bw_first_code);
		    if(yNBWListSum.size() >= 2){
		    	in_bw_second_code = yNBWListSum.get(1).getSivName();
		    	in_bw_second_value = yNBWListSum.get(1).getValue();
		    	in_bw_second_name = bwService.querySingleBwName(in_bw_second_code);
		    }
		}
		
		//第一病位（内）
		diagnoseResult.setIn_bw_first_code(in_bw_first_code);
		diagnoseResult.setIn_bw_first_name(in_bw_first_name);
		diagnoseResult.setIn_bw_first_value(in_bw_first_value);
		//第二病位（内）
		diagnoseResult.setIn_bw_second_code(in_bw_second_code);
		diagnoseResult.setIn_bw_second_name(in_bw_second_name);
		diagnoseResult.setIn_bw_second_value(in_bw_second_value);
		
		//第一病因（内）
		diagnoseResult.setIn_by_first_code(in_by_first_code);
		diagnoseResult.setIn_by_first_name(in_by_first_name);
		diagnoseResult.setIn_by_first_value(in_by_first_value);
		//第二病因（内）
		diagnoseResult.setIn_by_second_code(in_by_second_code);
		diagnoseResult.setIn_by_second_name(in_by_second_name);
		diagnoseResult.setIn_by_second_value(in_by_second_value);
		
		//病位（外）
		diagnoseResult.setOut_bw_code(out_bw_code);
		diagnoseResult.setOut_bw_name(out_bw_name);
		diagnoseResult.setOut_bw_value(out_bw_value);
		//病因（外）
		diagnoseResult.setOut_by_code(out_by_code);
		diagnoseResult.setOut_by_name(out_by_name);
		diagnoseResult.setOut_by_value(out_by_value);
		
		return diagnoseResult;
	}

	/**
	 * 获取处方药材信息
	 * @param diagnoseResult
	 * @return
	 * 诊断结果 :  (内) 1病位 A   2病位 B    (外) 病位 E
                    1病因 C   2病因 D         病因 F
                       主要症状： G
                  临时药方(处方)：AC,AD
                      诊断处方1：AC,EF,G  
                      诊断处方2：AC,AD,EF,G
                      诊断处方3：AC,BC,EF,G     
                      诊断处方4：AC,BD,EF,G         
                      诊断处方5：AC,BC,AD,EF,G 
	 */
	private DiagnoseResult doAchievePrescription(DiagnoseResult diagnoseResult,String mainSymptom){
		SymptomPrescriptionValue g_spv  = null;
		String mainSymptom_code = "", mainSymptom_name="",
			   valueAC_code = "", valueAC_name = "",
			   valueAD_code = "", valueAD_name = "",
			   valueBC_code = "", valueBC_name = "",
			   valueBD_code = "", valueBD_name = "",
			   valueEF_code = "", valueEF_name = "";
		if(!StringUtils.isBlank(mainSymptom)){
			g_spv = symptomPrescriptionService.querySingleSPV(mainSymptom);
			if(null != g_spv){
				mainSymptom_code = Constant.MAIN_PRESCRIPTION_CODE;//目前统一用G代替，获取用mainSymptom
				mainSymptom_name = g_spv.getName();
				diagnoseResult.setSymptom_prescription_id(Long.parseLong(mainSymptom));
				diagnoseResult.setSymptom_prescription_name(mainSymptom_name);
			}
		}
		
		//第一病位（内） A
		String in_bw_first_code = diagnoseResult.getIn_bw_first_code();
		//第二病位（内）B
		String in_bw_second_code = diagnoseResult.getIn_bw_second_code();
		//第一病因（内） C
		String in_by_first_code = diagnoseResult.getIn_by_first_code();
		//第二病因（内） D
		String in_by_second_code = diagnoseResult.getIn_by_second_code();
		//病位（外）E
		String out_bw_code = diagnoseResult.getOut_bw_code();
		//病因（外）F
		String out_by_code = diagnoseResult.getOut_by_code();
		
		//AC
		valueAC_code = in_bw_first_code+in_by_first_code;
		valueAC_name = diagnoseResult.getIn_bw_first_name()+diagnoseResult.getIn_by_first_name();
		
		//AD
		if(!StringUtils.isBlank(in_by_second_code)){
			valueAD_code = in_bw_first_code + in_by_second_code;
			valueAD_name = diagnoseResult.getIn_bw_first_name() + diagnoseResult.getIn_by_second_name();
		}
		
		//BC
		if(!StringUtils.isBlank(in_bw_second_code)){
			valueBC_code = in_bw_second_code + in_by_first_code;
			valueBC_name = diagnoseResult.getIn_bw_second_name() + diagnoseResult.getIn_by_first_name();
		}
		
		//BD
		if(!StringUtils.isBlank(in_bw_second_code) && !StringUtils.isBlank(in_by_second_code)){
			valueBD_code = in_bw_second_code + in_by_second_code;
			valueBD_name = diagnoseResult.getIn_bw_second_name()+diagnoseResult.getIn_by_second_name();
		}
		
		//EF
		if(!StringUtils.isBlank(out_bw_code) && !StringUtils.isBlank(out_by_code)){
			valueEF_code = out_bw_code + out_by_code;
			valueEF_name = diagnoseResult.getOut_bw_name()+diagnoseResult.getOut_by_name();
		}
		
		//诊断处方1：AC,EF,G 
		String prescription1_code = valueAC_code;
		String prescription1_name = valueAC_name;
		if(!StringUtils.isBlank(valueEF_code)){
			prescription1_code += ","+ valueEF_code;
			prescription1_name += ","+  valueEF_name;
		}
		
		if(!StringUtils.isBlank(mainSymptom_code)){
			prescription1_code += "||"+ mainSymptom_code;
			prescription1_name += "||"+ mainSymptom_name;
		}
		
		//诊断处方2：AC,AD,EF,G
		String prescription2_code = valueAC_code;
		String prescription2_name = valueAC_name;
		if(!StringUtils.isBlank(valueAD_code)){
			prescription2_code += ","+ valueAD_code;
			prescription2_name += ","+  valueAD_name;
		}
		
		if(!StringUtils.isBlank(valueEF_code)){
			prescription2_code += ","+ valueEF_code;
			prescription2_name += ","+  valueEF_name;
		}
		
		if(!StringUtils.isBlank(mainSymptom_code)){
			prescription2_code += "||"+ mainSymptom_code;
			prescription2_name += "||"+ mainSymptom_name;
		}
		
		//诊断处方3：AC,BC,EF,G 
		String prescription3_code = valueAC_code;
		String prescription3_name = valueAC_name;
		if(!StringUtils.isBlank(valueBC_code)){
			prescription3_code += ","+ valueBC_code;
			prescription3_name += ","+  valueBC_name;
		}
		
		if(!StringUtils.isBlank(valueEF_code)){
			prescription3_code += ","+ valueEF_code;
			prescription3_name += ","+  valueEF_name;
		}
		
		if(!StringUtils.isBlank(mainSymptom_code)){
			prescription3_code += "||"+ mainSymptom_code;
			prescription3_name += "||"+ mainSymptom_name;
		}
		
		//诊断处方4：AC,BD,EF,G 
		String prescription4_code = valueAC_code;
		String prescription4_name = valueAC_name;
		if(!StringUtils.isBlank(valueBD_code)){
			prescription4_code += ","+ valueBD_code;
			prescription4_name += ","+  valueBD_name;
		}
		
		if(!StringUtils.isBlank(valueEF_code)){
			prescription4_code += ","+ valueEF_code;
			prescription4_name += ","+  valueEF_name;
		}
		
		if(!StringUtils.isBlank(mainSymptom_code)){
			prescription4_code += "||"+ mainSymptom_code;
			prescription4_name += "||"+ mainSymptom_name;
		}
		
		//诊断处方5：AC,BC,AD,EF,G 
		String prescription5_code = valueAC_code;
		String prescription5_name = valueAC_name;
		if(!StringUtils.isBlank(valueBC_code)){
			prescription5_code += ","+ valueBC_code;
			prescription5_name += ","+  valueBC_name;
		}
		
		if(!StringUtils.isBlank(valueAD_code)){
			prescription5_code += ","+ valueAD_code;
			prescription5_name += ","+  valueAD_name;
		}
		
		if(!StringUtils.isBlank(valueEF_code)){
			prescription5_code += ","+ valueEF_code;
			prescription5_name += ","+  valueEF_name;
		}
		
		if(!StringUtils.isBlank(mainSymptom_code)){
			prescription5_code += "||"+ mainSymptom_code;
			prescription5_name += "||"+ mainSymptom_name;
		}
		
		//诊断处方(临时处方)：AC AD
		String prescription_interim_code = valueAC_code;
		String prescription_interim_name = valueAC_name;
		if(!StringUtils.isBlank(valueAD_code)){
			prescription_interim_code += ","+ valueAD_code;
			prescription_interim_name += ","+  valueAD_name;
		}
	
		
		diagnoseResult.setPrescription1_code(prescription1_code);
		diagnoseResult.setPrescription1_name(prescription1_name);
		diagnoseResult.setPrescription1_medicinal(this.doGetMedicinal(valueAC_code, null, valueEF_code, g_spv)[0]);
		
		diagnoseResult.setPrescription2_code(prescription2_code);
		diagnoseResult.setPrescription2_name(prescription2_name);
		diagnoseResult.setPrescription2_medicinal(this.doGetMedicinal(valueAC_code, valueAD_code, valueEF_code, g_spv)[0]);
		
		diagnoseResult.setPrescription3_code(prescription3_code);
		diagnoseResult.setPrescription3_name(prescription3_name);
		diagnoseResult.setPrescription3_medicinal(this.doGetMedicinal(valueAC_code, valueBC_code, valueEF_code, g_spv)[0]);
		
		diagnoseResult.setPrescription4_code(prescription4_code);
		diagnoseResult.setPrescription4_name(prescription4_name);
		diagnoseResult.setPrescription4_medicinal(this.doGetMedicinal(valueAC_code, valueBD_code, valueEF_code, g_spv)[0]);
		
		diagnoseResult.setPrescription5_code(prescription5_code);
		diagnoseResult.setPrescription5_name(prescription5_name);
		diagnoseResult.setPrescription5_medicinal(this.doGetMedicinal5(valueAC_code, valueBC_code, valueAD_code, valueEF_code, g_spv));
		
		/**增加临时药方*/
		diagnoseResult.setPrescription_interim_code(prescription_interim_code);
		diagnoseResult.setPrescription_interim_name(prescription_interim_name);
		String[] prescriptionInterimMedicinalArr = this.doGetMedicinal(valueAC_code, valueAD_code, null, null);
		diagnoseResult.setPrescription_interim_medicinal(prescriptionInterimMedicinalArr[0]);
		diagnoseResult.setPrescription_interim_medicinal_origin(prescriptionInterimMedicinalArr[1]);
		
		//AC
		BasePrescriptionValue acBPV = basePrescriptionService.querySingleBPV(valueAC_code);
		if(null != acBPV){
			diagnoseResult.setAc_medicinal(acBPV.toString());
		}
		//AD
		BasePrescriptionValue adBPV = basePrescriptionService.querySingleBPV(valueAD_code);
		if(null != adBPV){
			diagnoseResult.setAd_medicinal(adBPV.toString());
		}
		//BC
		BasePrescriptionValue bcBPV = basePrescriptionService.querySingleBPV(valueBC_code);
		if(null != bcBPV){
			diagnoseResult.setBc_medicinal(bcBPV.toString());
		}
		//BD
		BasePrescriptionValue bdBPV = basePrescriptionService.querySingleBPV(valueBD_code);
		if(null != bdBPV){
			diagnoseResult.setBd_medicinal(bdBPV.toString());
		}
		//EF
		BasePrescriptionValue efBPV = basePrescriptionService.querySingleBPV(valueEF_code);
		if(null != efBPV){
			diagnoseResult.setEf_medicinal(efBPV.toString());
		}
		
		//G
		if(null != g_spv){
			diagnoseResult.setG_medicinal(g_spv.toString());
		}
		
		return diagnoseResult;
	}
	
	
	/**
	 * 获取药材属性
	 * @param ac_code  必输，不为空
	 * @param middleCode  可能是AD_CODE、BC_CODE、BD_CODE
	 * @param ef_code
	 * @param g_spv 
	 * @return 返回数组：参数1:正常返回  参数2:把那些单位等，去掉。
	 */
	private String[] doGetMedicinal(String ac_code,String middleCode, String ef_code,SymptomPrescriptionValue g_spv){
		
		//1、获取内病因药材对象
		List<BasePrescriptionValue> listBPV = new ArrayList<BasePrescriptionValue>();
		BasePrescriptionValue groupBPV = null;
		BasePrescriptionValue acBPV = null;
		BasePrescriptionValue middleBPV = null;
		
		if(!StringUtils.isBlank(middleCode)){
			//先查找组合药材  如:AC + AD
		    String groupCode = ac_code + middleCode;
			groupBPV = basePrescriptionService.querySingleBPV(groupCode);
			if(groupBPV != null){
				//其存在组合药材
				listBPV.add(groupBPV);
			}
			else{
				//不存在组合药材，则分开查找
			    acBPV = basePrescriptionService.querySingleBPV(ac_code);
				middleBPV = basePrescriptionService.querySingleBPV(middleCode);
				
				if(acBPV != null){
					listBPV.add(acBPV);
				}
				
				if(middleBPV != null){
					listBPV.add(middleBPV);
				}
			}
		}
		else{
			//传进来只有ac_code
			acBPV = basePrescriptionService.querySingleBPV(ac_code);
			if(acBPV != null){
				listBPV.add(acBPV);
			}
		}
		
		//2、获取外病因药材对象
		if(!StringUtils.isBlank(ef_code)){
			BasePrescriptionValue efBPV = basePrescriptionService.querySingleBPV(ef_code);
			if(efBPV != null){
				listBPV.add(efBPV);
			}
		}
		
		//3、把主要症状药材信息，追加到基本症状数据里面
		this.doAddGMedicinal(listBPV, g_spv);
		
		//4、listBPV、g_spv计算得出药材结果
		//listBPV肯定有值
		List<MedicinalValue> listMedi = new ArrayList<MedicinalValue>();  //对value值进行处理，存储value对象,取最大值
		Map<String, String> mapMedi = new HashMap<String, String>();   //对特殊备注 值进行处理，存储value对象,取最大值
		for(BasePrescriptionValue bpv : listBPV){
			//4.1对value1,value2....value10处理
			this.queryMediValue(listMedi, bpv.getValue1(),null);
			this.queryMediValue(listMedi, bpv.getValue2(),null);
			this.queryMediValue(listMedi, bpv.getValue3(),null);
			this.queryMediValue(listMedi, bpv.getValue4(),null);
			this.queryMediValue(listMedi, bpv.getValue5(),null);
			this.queryMediValue(listMedi, bpv.getValue6(),null);
			this.queryMediValue(listMedi, bpv.getValue7(),null);
			this.queryMediValue(listMedi, bpv.getValue8(),null);
			this.queryMediValue(listMedi, bpv.getValue9(),null);
			this.queryMediValue(listMedi, bpv.getValue10(),null);
			
			//特殊药材1，且bpv.getSpec_value_1()不为空，那种可以参与前面value1,value2,,value10计算
			if(!StringUtils.isBlank(bpv.getSpec_value_1())){
				this.queryMediValue(listMedi, bpv.getSpec_value_1(),Integer.parseInt(bpv.getSpec_value_1_action()));
			}
			else{
				if(!StringUtils.isBlank(bpv.getSpec_value_1_action()) && !StringUtils.isBlank(bpv.getSpec_value_1_remark())){
					mapMedi.put(bpv.getSpec_value_1_action(), bpv.getSpec_value_1_remark());
				}
			}
			
			if(!StringUtils.isBlank(bpv.getSpec_value_2())){
				this.queryMediValue(listMedi, bpv.getSpec_value_2(),Integer.parseInt(bpv.getSpec_value_2_action()));
			}
			else{
				if(!StringUtils.isBlank(bpv.getSpec_value_2_action()) && !StringUtils.isBlank(bpv.getSpec_value_2_remark())){
					mapMedi.put(bpv.getSpec_value_2_action(), bpv.getSpec_value_2_remark());
				}
			}
			
			if(!StringUtils.isBlank(bpv.getSpec_value_3())){
				this.queryMediValue(listMedi, bpv.getSpec_value_3(),Integer.parseInt(bpv.getSpec_value_3_action()));
			}
			else{
				if(!StringUtils.isBlank(bpv.getSpec_value_3_action()) && !StringUtils.isBlank(bpv.getSpec_value_3_remark())){
					mapMedi.put(bpv.getSpec_value_3_action(), bpv.getSpec_value_3_remark());
				}
			}
		}
		
		//5、对listMedi、mapMedi进行获取药材
		String pescription = "";
		String pescriptionIngoreUnit = "";
		for(MedicinalValue mv : listMedi)
		{
			String medicinalName = medicinalService.querySingleMedicinalName(mv.getMedicinal_code());
			if(mv.getMedicinal_action().compareTo(Constant.DEDICINAL_VALUE) == 0){
				if(!StringUtils.isBlank(pescription)){
					pescription += ",";
					pescriptionIngoreUnit += ",";
				}
				pescription += medicinalName + (int)mv.getMedicinal_value() +"g";
				pescriptionIngoreUnit += pescriptionIngoreUnit ;
			}
			else{
				if(!StringUtils.isBlank(pescription)){
					pescription += ",";
					pescriptionIngoreUnit += ",";
				}
				pescription += medicinalName + "（"+medicinalService.queryMedicinalActionName(String.valueOf(mv.getMedicinal_action()))+"）" + (int)mv.getMedicinal_value()+"g";
				pescriptionIngoreUnit += pescriptionIngoreUnit + "（"+medicinalService.queryMedicinalActionName(String.valueOf(mv.getMedicinal_action()))+"）";
			}
		}
		
		//针对特使备注处理
		if(null != mapMedi && mapMedi.size() > 0){
			Set<Entry<String, String>> entrySet = mapMedi.entrySet();
			for(Entry<String, String> entry: entrySet){
				if(!StringUtils.isBlank(pescription)){
					pescription += ",";
					pescriptionIngoreUnit += ",";
				}
				pescription += entry.getValue();
				pescriptionIngoreUnit += entry.getValue();
			}
		}
		
		String[] pescriptionArr = {pescription,pescriptionIngoreUnit};
		//return pescription;
		return  pescriptionArr;
	}
	
	
	
	/**
	 * 获取药材属性
	 * @param ac_code  必输，不为空
	 * @param middleCode  可能是AD_CODE、BC_CODE、BD_CODE
	 * @param ef_code
	 * @param g_spv 
	 * @return
	 */
	private String doGetMedicinal5(String ac_code,String bc_code,String ad_code, String ef_code,SymptomPrescriptionValue g_spv){
		
		//1、获取内病因药材对象
		List<BasePrescriptionValue> listBPV = new ArrayList<BasePrescriptionValue>();
		BasePrescriptionValue groupBPV = null;
		BasePrescriptionValue acBPV = null;
		BasePrescriptionValue bcBPV = null;
		BasePrescriptionValue adBPV = null;
		
		//1、bc、ad都不为空
		if(!StringUtils.isBlank(bc_code) && !StringUtils.isBlank(ad_code)){
			//先查找组合药材  按以下组合来处理，且按顺序来
			//AC + AD
			//AC + BC
			//BC + AD
			String groupCode = ac_code + ad_code;
			groupBPV = basePrescriptionService.querySingleBPV(groupCode);
			if(groupBPV != null){
				//AC + AD
				listBPV.add(groupBPV);
				bcBPV = basePrescriptionService.querySingleBPV(bc_code);
				if(bcBPV != null){
					listBPV.add(bcBPV);
				}
			}
			else{
				groupCode = ac_code + bc_code;
				groupBPV = basePrescriptionService.querySingleBPV(groupCode);
				if(groupBPV != null){
					//AC + BC
					listBPV.add(groupBPV);
					adBPV = basePrescriptionService.querySingleBPV(ad_code);
					if(adBPV != null){
						listBPV.add(adBPV);
					}
				}
				else{
					groupCode = ad_code + bc_code;
					groupBPV = basePrescriptionService.querySingleBPV(groupCode);
					if(groupBPV != null){
						//BC + AD
						listBPV.add(groupBPV);
						acBPV = basePrescriptionService.querySingleBPV(ac_code);
						if(acBPV != null){
							listBPV.add(acBPV);
						}
					}
					else{
						//不存在组合药材，则分开查找
					    acBPV = basePrescriptionService.querySingleBPV(ac_code);
					    bcBPV = basePrescriptionService.querySingleBPV(bc_code);
					    adBPV = basePrescriptionService.querySingleBPV(ad_code);
						
						if(acBPV != null){
							listBPV.add(acBPV);
						}
						
						if(bcBPV != null){
							listBPV.add(bcBPV);
						}
						
						if(adBPV != null){
							listBPV.add(adBPV);
						}
					}
				}
			}
		}
		
		//2、bc不为空，ad为空
		if(!StringUtils.isBlank(bc_code) && StringUtils.isBlank(ad_code)){
			//先查找组合药材  如:AC + bc
		    String groupCode = ac_code + bc_code;
			groupBPV = basePrescriptionService.querySingleBPV(groupCode);
			if(groupBPV != null){
				//其存在组合药材
				listBPV.add(groupBPV);
			}
			else{
				//不存在组合药材，则分开查找
			    acBPV = basePrescriptionService.querySingleBPV(ac_code);
			    bcBPV = basePrescriptionService.querySingleBPV(bc_code);
				
				if(acBPV != null){
					listBPV.add(acBPV);
				}
				
				if(bcBPV != null){
					listBPV.add(bcBPV);
				}
			}
		}
		
		//3、bc为空，ad不为空
		if(StringUtils.isBlank(bc_code) && !StringUtils.isBlank(ad_code)){

			//先查找组合药材  如:AC + ad
		    String groupCode = ac_code + ad_code;
			groupBPV = basePrescriptionService.querySingleBPV(groupCode);
			if(groupBPV != null){
				//其存在组合药材
				listBPV.add(groupBPV);
			}
			else{
				//不存在组合药材，则分开查找
			    acBPV = basePrescriptionService.querySingleBPV(ac_code);
			    adBPV = basePrescriptionService.querySingleBPV(ad_code);
				
				if(acBPV != null){
					listBPV.add(acBPV);
				}
				
				if(adBPV != null){
					listBPV.add(adBPV);
				}
			}
		}
		
		//4、bc为空，ad为空
		if(StringUtils.isBlank(bc_code) && StringUtils.isBlank(ad_code)){
			//传进来只有ac_code
			acBPV = basePrescriptionService.querySingleBPV(ac_code);
			if(acBPV != null){
				listBPV.add(acBPV);
			}
		}
			
		//2、获取外病因药材对象
		if(!StringUtils.isBlank(ef_code)){
			BasePrescriptionValue efBPV = basePrescriptionService.querySingleBPV(ef_code);
			if(efBPV != null){
				listBPV.add(efBPV);
			}
		}
		
		//3、把主要症状药材信息，追加到基本症状数据里面
		this.doAddGMedicinal(listBPV, g_spv);
		
		//4、listBPV、g_spv计算得出药材结果
		//listBPV肯定有值
		List<MedicinalValue> listMedi = new ArrayList<MedicinalValue>();  //对value值进行处理，存储value对象,取最大值
		Map<String, String> mapMedi = new HashMap<String, String>();   //对特殊备注 值进行处理，存储value对象,取最大值
		for(BasePrescriptionValue bpv : listBPV){
			//4.1对value1,value2....value10处理
			this.queryMediValue(listMedi, bpv.getValue1(),null);
			this.queryMediValue(listMedi, bpv.getValue2(),null);
			this.queryMediValue(listMedi, bpv.getValue3(),null);
			this.queryMediValue(listMedi, bpv.getValue4(),null);
			this.queryMediValue(listMedi, bpv.getValue5(),null);
			this.queryMediValue(listMedi, bpv.getValue6(),null);
			this.queryMediValue(listMedi, bpv.getValue7(),null);
			this.queryMediValue(listMedi, bpv.getValue8(),null);
			this.queryMediValue(listMedi, bpv.getValue9(),null);
			this.queryMediValue(listMedi, bpv.getValue10(),null);
			
			//特殊药材1，且bpv.getSpec_value_1()不为空，那种可以参与前面value1,value2,,value10计算
			if(!StringUtils.isBlank(bpv.getSpec_value_1())){
				this.queryMediValue(listMedi, bpv.getSpec_value_1(),Integer.parseInt(bpv.getSpec_value_1_action()));
			}
			else{
				if(!StringUtils.isBlank(bpv.getSpec_value_1_action()) && !StringUtils.isBlank(bpv.getSpec_value_1_remark())){
					mapMedi.put(bpv.getSpec_value_1_action(), bpv.getSpec_value_1_remark());
				}
			}
			
			if(!StringUtils.isBlank(bpv.getSpec_value_2())){
				this.queryMediValue(listMedi, bpv.getSpec_value_2(),Integer.parseInt(bpv.getSpec_value_2_action()));
			}
			else{
				if(!StringUtils.isBlank(bpv.getSpec_value_2_action()) && !StringUtils.isBlank(bpv.getSpec_value_2_remark())){
					mapMedi.put(bpv.getSpec_value_2_action(), bpv.getSpec_value_2_remark());
				}
			}
			
			if(!StringUtils.isBlank(bpv.getSpec_value_3())){
				this.queryMediValue(listMedi, bpv.getSpec_value_3(),Integer.parseInt(bpv.getSpec_value_3_action()));
			}
			else{
				if(!StringUtils.isBlank(bpv.getSpec_value_3_action()) && !StringUtils.isBlank(bpv.getSpec_value_3_remark())){
					mapMedi.put(bpv.getSpec_value_3_action(), bpv.getSpec_value_3_remark());
				}
			}
		}
		
		//5、对listMedi、mapMedi进行获取药材
		String pescription = "";
		for(MedicinalValue mv : listMedi)
		{
			String medicinalName = medicinalService.querySingleMedicinalName(mv.getMedicinal_code());
			if(mv.getMedicinal_action().compareTo(Constant.DEDICINAL_VALUE) == 0){
				if(!StringUtils.isBlank(pescription)){
					pescription += ",";
				}
				pescription += medicinalName + (int)mv.getMedicinal_value() +"g";
			}
			else{
				if(!StringUtils.isBlank(pescription)){
					pescription += ",";
				}
				pescription += medicinalName + "（"+medicinalService.queryMedicinalActionName(String.valueOf(mv.getMedicinal_action()))+"）" + (int)mv.getMedicinal_value()+"g";
			}
		}
		
		//针对特使备注处理
		if(null != mapMedi && mapMedi.size() > 0){
			Set<Entry<String, String>> entrySet = mapMedi.entrySet();
			for(Entry<String, String> entry: entrySet){
				if(!StringUtils.isBlank(pescription)){
					pescription += ",";
				}
				pescription += entry.getValue();
			}
		}
		return pescription;
	}
	
	/**
	 * 把“G”的药材数据先追加起来，然后一起参与运算
	 * @param listMedi
	 * @param g_spv
	 */
	private void doAddGMedicinal(List<BasePrescriptionValue> listBPV,SymptomPrescriptionValue g_spv){
		if(null != g_spv){
			BasePrescriptionValue mv = new BasePrescriptionValue();
			mv.setValue1(g_spv.getValue1());
			mv.setValue2(g_spv.getValue2());
			mv.setValue3(g_spv.getValue3());
			mv.setValue4(g_spv.getValue4());
			mv.setValue5(g_spv.getValue5());
			mv.setValue6(g_spv.getValue6());
			mv.setValue7(g_spv.getValue7());
			mv.setValue8(g_spv.getValue8());
			mv.setValue9(g_spv.getValue9());
			mv.setValue10(g_spv.getValue10());
			mv.setSpec_value_1(g_spv.getSpec_value_1());
			mv.setSpec_value_1_action(g_spv.getSpec_value_1_action());
			mv.setSpec_value_1_remark(g_spv.getSpec_value_1_remark());
			mv.setSpec_value_2(g_spv.getSpec_value_2());
			mv.setSpec_value_2_action(g_spv.getSpec_value_2_action());
			mv.setSpec_value_2_remark(g_spv.getSpec_value_2_remark());
			mv.setSpec_value_3(g_spv.getSpec_value_3());
			mv.setSpec_value_3_action(g_spv.getSpec_value_3_action());
			mv.setSpec_value_3_remark(g_spv.getSpec_value_3_remark());
			listBPV.add(mv);
		}
	}

	/**
	 * 解析其药材值
	 * EXAMPLE:FZ=10
	 * @param mapMedi
	 * @param symptomValue
	 */
	private void queryMediValue(List<MedicinalValue> listMedi,String symptomValue,Integer action){
		if(!StringUtils.isBlank(symptomValue)){
			String[] bpvArr = symptomValue.split("=");
			String medicinal = bpvArr[0];
			float weight = Float.parseFloat(bpvArr[1]);
			
			MedicinalValue mv = new MedicinalValue(medicinal,weight,action);
			if(!listMedi.contains(mv)){
				listMedi.add(mv);
			}
			else{
				//找到其相同的值，然后比较重量大小。
				for(int i = 0; i< listMedi.size(); i++){
					MedicinalValue tmpMv = listMedi.get(i);
					if(tmpMv.getMedicinal_code().equals(medicinal)){
						if(tmpMv.getMedicinal_value() < weight){
							tmpMv.setMedicinal_value(weight); 
						}
						
						if(null != action &&  action != 0 && action.intValue() < tmpMv.getMedicinal_action().intValue()){
							tmpMv.setMedicinal_value(action);
						}
						break;
					}
				}
			}
		}
	}
	

}
