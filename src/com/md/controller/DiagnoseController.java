package com.md.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.md.common.BaseConditionVO;
import com.md.common.Constant;
import com.md.common.DateUtil;
import com.md.entity.Customer;
import com.md.entity.Diagnose;
import com.md.service.DiagnoseService;

@Controller
@RequestMapping("/md/diagnose")
public class DiagnoseController extends BaseController{
	
	@Resource
	private DiagnoseService diagnoseService;
	
	/**
	 * 历史诊断查询
	 * 用户登录后，进行结果查询,用户匿名登录不进行结果查询，提示，跳出另一页面进行提示。
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryDiagnoseData")
	public String queryDiagnoseData(HttpServletRequest request,BaseConditionVO vo,Model model,Diagnose diagnose){
		
		String diagnose_date_start = diagnose.getDiagnose_date_start();
		String diagnose_date_end = diagnose.getDiagnose_date_end();
		if(!StringUtils.isBlank(diagnose_date_start) &&
				diagnose_date_start.length() == 10	){
			diagnose.setDiagnose_date_start(DateUtil.dateFormatToStr2(diagnose_date_start));
		}
		
		if(!StringUtils.isBlank(diagnose_date_end) &&
				diagnose_date_end.length() == 10	){
			diagnose.setDiagnose_date_end(DateUtil.dateFormatToStr2(diagnose_date_end));
		}
		
		/*if(!StringUtils.isBlank(diagnose.getDiagnose_date_start()) &&
		   diagnose.getDiagnose_date_start().length() == 10	){
			diagnose.setDiagnose_date_start(DateUtil.dateFormatToStr2(diagnose.getDiagnose_date_start()));
		}
		
		if(!StringUtils.isBlank(diagnose.getDiagnose_date_end()) &&
		   diagnose.getDiagnose_date_end().length() == 10	){
			diagnose.setDiagnose_date_end(DateUtil.dateFormatToStr2(diagnose.getDiagnose_date_end()));
		}*/
		
		HttpSession session =  request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
		diagnose.setCustomer_id(loginCustomer.getId());
		
		Map<String, Object> mapParams = new HashMap<String,Object>();
		mapParams.put("start", vo.getStartIndex());
		mapParams.put("limit", vo.getPageSize());
		mapParams.put("domain",diagnose);
		
		List<Diagnose> diagnoseList = diagnoseService.queryDiagnoseData(mapParams);
		Integer totalCount = diagnoseService.queryDiagnoseCount(mapParams);
		
		vo.setTotalCount(totalCount);
		
		diagnose.setDiagnose_date_start(diagnose_date_start);
		diagnose.setDiagnose_date_end(diagnose_date_end);
		model.addAttribute("diagnose", diagnose);
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("diagnoseList", diagnoseList);
		return "diagnose/diagnoseList";
	}
	
	
	
	/***
	 * 管理员查看所有的诊断信息
	 * @param request
	 * @param vo
	 * @param model
	 * @param diagnose
	 * @return
	 */
	@RequestMapping(value = "/queryDiagnoseManagerData")
	public String queryDiagnoseManagerData(HttpServletRequest request,BaseConditionVO vo,Model model,Diagnose diagnose){
		
		String diagnose_date_start = diagnose.getDiagnose_date_start();
		String diagnose_date_end = diagnose.getDiagnose_date_end();
		if(!StringUtils.isBlank(diagnose_date_start) &&
				diagnose_date_start.length() == 10	){
			diagnose.setDiagnose_date_start(DateUtil.dateFormatToStr2(diagnose_date_start));
		}
		
		if(!StringUtils.isBlank(diagnose_date_end) &&
				diagnose_date_end.length() == 10	){
			diagnose.setDiagnose_date_end(DateUtil.dateFormatToStr2(diagnose_date_end));
		}
		
//		HttpSession session =  request.getSession();
//		Customer loginCustomer = (Customer)session.getAttribute(Constant.SESSION_ID);
//		diagnose.setCustomer_id(loginCustomer.getId());
		
		Map<String, Object> mapParams = new HashMap<String,Object>();
		mapParams.put("start", vo.getStartIndex());
		mapParams.put("limit", vo.getPageSize());
		mapParams.put("domain",diagnose);
		
		List<Diagnose> diagnoseList = diagnoseService.queryDiagnoseData(mapParams);
		Integer totalCount = diagnoseService.queryDiagnoseCount(mapParams);
		
		vo.setTotalCount(totalCount);
		
		diagnose.setDiagnose_date_start(diagnose_date_start);
		diagnose.setDiagnose_date_end(diagnose_date_end);
		model.addAttribute("diagnose", diagnose);
		model.addAttribute("vo", vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("diagnoseList", diagnoseList);
		return "diagnose/diagnoseManagerList";
	}
	
	
	/**
	 * 导出excel
	 * @param request
	 * @param diagnose
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/exportDiagnoseData")
	public void exportDiagnoseData(HttpServletRequest request,HttpServletResponse response,Diagnose diagnose,Integer isIe) throws UnsupportedEncodingException{
		
		Map<String, Object> mapParams = new HashMap<String,Object>();
		if(diagnose == null){
			diagnose = new Diagnose();
		}
		
		//ajax请求过来的数据，出现乱码
		String uniCode = "UTF-8";
		/*if(isIe == 1){
			uniCode = "GBK";
		}*/
		
		String diagnose_date_start = diagnose.getDiagnose_date_start();
		String diagnose_date_end = diagnose.getDiagnose_date_end();
		if(!StringUtils.isBlank(diagnose_date_start) &&
				diagnose_date_start.length() == 10	){
			diagnose.setDiagnose_date_start(DateUtil.dateFormatToStr2(diagnose_date_start));
		}
		
		if(!StringUtils.isBlank(diagnose_date_end) &&
				diagnose_date_end.length() == 10	){
			diagnose.setDiagnose_date_end(DateUtil.dateFormatToStr2(diagnose_date_end));
		}
		
		diagnose.setCustomer_name(new String(diagnose.getCustomer_name().getBytes("ISO8859-1"), uniCode));
		diagnose.setLogin_name(new String(diagnose.getLogin_name().getBytes("ISO8859-1"), uniCode));
		diagnose.setDoctor_name(new String(diagnose.getDoctor_name().getBytes("ISO8859-1"), uniCode));
		
		mapParams.put("domain",diagnose);
		
		List<Diagnose> diagnoseList = diagnoseService.queryDiagnoseData(mapParams);
		
		response.setContentType("application/vnd.ms-excel");  
	     String codedFileName = null;  
	     OutputStream fOut = null;  
	     try  
	     {  
	         // 进行转码，使其支持中文文件名  
	         codedFileName = java.net.URLEncoder.encode("客户诊断信息列表", "UTF-8");  
	         response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");  
	         // response.addHeader("Content-Disposition", "attachment;   filename=" + codedFileName + ".xls");  
	         // 产生工作簿对象  
	         HSSFWorkbook workbook = new HSSFWorkbook();  
	         
	         // 设置字体   
	         HSSFFont headfont = workbook.createFont();   
	         headfont.setFontName("黑体");   
	         headfont.setFontHeightInPoints((short) 12);// 字体大小   
	         headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗   
	         
	         // 另一个样式   
	         HSSFCellStyle headstyle = workbook.createCellStyle();   
	         headstyle.setFont(headfont);   
	         //headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中   
	         headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中   
	         headstyle.setLocked(true);   
	         headstyle.setWrapText(true);// 自动换行 
	         
	         //产生工作表对象  
	         HSSFSheet sheet = workbook.createSheet("客户诊断信息");
	         sheet.setColumnWidth(0, 1000 * 3); 
	         sheet.setColumnWidth(1, 1200 * 3); 
	         sheet.setColumnWidth(2, 1000 * 3); 
	         sheet.setColumnWidth(3, 1800 * 3); 
	         sheet.setColumnWidth(4, 1800 * 3); 
	         sheet.setColumnWidth(5, 1800 * 3); 
	         sheet.setColumnWidth(6, 4000 * 3); 
	         sheet.setColumnWidth(7, 2000 * 3); 
	         sheet.setColumnWidth(8, 6000 * 3); 
	         
	         
	         HSSFRow row = sheet.createRow(0);//创建一行  
             HSSFCell cell0 = row.createCell(0);//创建一列  
             cell0.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell0.setCellValue("客户名称");
             cell0.setCellStyle(headstyle);
             
             HSSFCell cell1 = row.createCell(1);//创建一列  
             cell1.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell1.setCellValue("客户登录名");
             cell1.setCellStyle(headstyle);
             
             HSSFCell cell2 = row.createCell(2);//创建一列  
             cell2.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell2.setCellValue("诊断医生");
             cell2.setCellStyle(headstyle);
             
             HSSFCell cell3 = row.createCell(3);//创建一列  
             cell3.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell3.setCellValue("诊断时间");
             cell3.setCellStyle(headstyle);
             
             HSSFCell cell4 = row.createCell(4);//创建一列  
             cell4.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell4.setCellValue("申请诊断状态");
             cell4.setCellStyle(headstyle);
             
             HSSFCell cell5 = row.createCell(5);//创建一列  
             cell5.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell5.setCellValue("诊断主要症状");
             cell5.setCellStyle(headstyle);
             
             HSSFCell cell6 = row.createCell(6);//创建一列  
             cell6.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell6.setCellValue("诊断一般症状");
             cell6.setCellStyle(headstyle);
             
             HSSFCell cell7 = row.createCell(7);//创建一列  
             cell7.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell7.setCellValue("诊断结果");
             cell7.setCellStyle(headstyle);
             
             HSSFCell cell8 = row.createCell(8);//创建一列  
             cell8.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell8.setCellValue("处方");
             cell8.setCellStyle(headstyle);
             
	         for(int i =1 ;i<= diagnoseList.size() ; i++){
	        	 Diagnose tempDiagnose = diagnoseList.get(i-1);
	        	 HSSFRow tempRow = sheet.createRow(i);//创建一行  
	             HSSFCell tempcell0 = tempRow.createCell(0);//创建一列  
	             tempcell0.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             tempcell0.setCellValue(tempDiagnose.getCustomer_name());
	             
	             HSSFCell tempcell1 = tempRow.createCell(1);//创建一列  
	             tempcell1.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             tempcell1.setCellValue(tempDiagnose.getLogin_name());
	             
	             HSSFCell tempcell2 = tempRow.createCell(2);//创建一列  
	             tempcell2.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             tempcell2.setCellValue(tempDiagnose.getDoctor_name());
	             
	             HSSFCell tempcell3 = tempRow.createCell(3);//创建一列  
	             tempcell3.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             tempcell3.setCellValue(tempDiagnose.getDiagnose_date());
	             
	             HSSFCell tempcell4 = tempRow.createCell(4);//创建一列  
	             tempcell4.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             
	             
				 String applyReplyStatusName = "未申请专家确诊";
				 int applyReplyStatus = 1;
				 if(null !=  tempDiagnose.getApply_reply_status()){
					 applyReplyStatus = tempDiagnose.getApply_reply_status().intValue();
				 }
				 switch (applyReplyStatus) {
					case 1:
						applyReplyStatusName = "未申请专家确诊";
						break;
					case 2:
						applyReplyStatusName = "已申请专家确诊";
						break;
					case 3:
						applyReplyStatusName = "专家已确诊";
						break;

				default:
					break;
				}
	             
	             tempcell4.setCellValue(applyReplyStatusName);
	             
	             HSSFCell tempcell5 = tempRow.createCell(5);//创建一列  
	             tempcell5.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             tempcell5.setCellValue(tempDiagnose.getMain_sysptom());
	             
	             HSSFCell tempcell6 = tempRow.createCell(6);//创建一列  
	             tempcell6.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             tempcell6.setCellValue(tempDiagnose.getLess_sysptom());
	             
	             HSSFCell tempcell7 = tempRow.createCell(7);//创建一列  
	             tempcell7.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             
	             String diagnoseRes = tempDiagnose.getIn_bw_first_name() + tempDiagnose.getIn_by_first_name();
	             if(!StringUtils.isBlank(tempDiagnose.getIn_by_second_name())){
	            	 diagnoseRes +="且"+tempDiagnose.getIn_by_second_name();
	             }
	             
	             tempcell7.setCellValue(diagnoseRes);
	             
	             HSSFCell tempcell8 = tempRow.createCell(8);//创建一列  
	             tempcell8.setCellType(HSSFCell.CELL_TYPE_STRING);  
	             tempcell8.setCellValue(tempDiagnose.getPrescription2_medicinal());
	         }
	         
	        
	         fOut = response.getOutputStream();  
	         workbook.write(fOut);  
	     }  
	     catch (UnsupportedEncodingException e1)  
	     {}  
	     catch (Exception e)  
	     {}  
	     finally  
	     {  
	         try  
	         {  
	             fOut.flush();  
	             fOut.close();  
	         }  
	         catch (IOException e)  
	         {}  
	     }  
	     System.out.println("文件生成...");  
	}
	
}
