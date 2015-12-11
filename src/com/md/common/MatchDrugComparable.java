package com.md.common;


/**
 * 符合临时药方的中成药对象
 * 
 * @author owen
 *
 */
public class MatchDrugComparable implements Comparable<MatchDrugComparable> {

	private String drug_name;

	private String drug_code;

	private int match_count;
	
	public MatchDrugComparable(String drug_name,String drug_code,int match_count){
		this.drug_name = drug_name;
		this.drug_code = drug_code;
		this.match_count = match_count;
	}

	public String getDrug_name() {
		return drug_name;
	}

	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	public String getDrug_code() {
		return drug_code;
	}

	public void setDrug_code(String drug_code) {
		this.drug_code = drug_code;
	}

	public int getMatch_count() {
		return match_count;
	}

	public void setMatch_count(int match_count) {
		this.match_count = match_count;
	}

	@Override
	public int compareTo(MatchDrugComparable o) {
		int flag = this.getMatch_count() - o.getMatch_count();
		if (flag == 0) {
		    return -this.getDrug_code().compareTo(o.getDrug_code());
		} else {
			return flag;
		}
	}
}
