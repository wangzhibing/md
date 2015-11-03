package com.md.common;



/**
 * 业务处理过程中，记录药材及对应的药材值
 * @author wzb
 */
public class MedicinalValue {

	private String medicinal_code;
	
	private float medicinal_value;
	
	private Integer medicinal_action;
	
	public MedicinalValue(String medicinal_code,float medicinal_value,Integer medicinal_action){
		this.medicinal_code = medicinal_code;
		this.medicinal_value = medicinal_value;
		if(null == medicinal_action || 0 == medicinal_action.intValue()){
			//初始为10000
			this.medicinal_action = Constant.DEDICINAL_VALUE;
		}
		else{
			this.medicinal_action = medicinal_action;
		}
	}
	
	/**
	 * 重写equal方法
	 */
	public boolean equals(Object obj) {
		MedicinalValue mv = (MedicinalValue) obj;
		return mv.getMedicinal_code().equals(this.getMedicinal_code());
	}

	public String getMedicinal_code() {
		return medicinal_code;
	}

	public void setMedicinal_code(String medicinal_code) {
		this.medicinal_code = medicinal_code;
	}

	public float getMedicinal_value() {
		return medicinal_value;
	}

	public void setMedicinal_value(float medicinal_value) {
		this.medicinal_value = medicinal_value;
	}

	public Integer getMedicinal_action() {
		return medicinal_action;
	}

	public void setMedicinal_action(Integer medicinal_action) {
		this.medicinal_action = medicinal_action;
	}
	
	
}
