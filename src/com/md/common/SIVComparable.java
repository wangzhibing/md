package com.md.common;

import java.util.HashMap;
import java.util.Map;

public class SIVComparable implements Comparable<SIVComparable> {

	private String sivName;

	private Float value;
	
	private static Map<String, Integer> dataMap;
	
	static{
		dataMap = new HashMap<String, Integer>();
		
		dataMap.put("W1", 1);dataMap.put("W2", 2);dataMap.put("W3", 3);
		dataMap.put("W4", 4);dataMap.put("W5", 5);dataMap.put("W6", 6);
		dataMap.put("W7", 7);dataMap.put("W8", 8);dataMap.put("W9", 9);
		
		dataMap.put("X", 11);   dataMap.put("ZA", 12);  dataMap.put("ZB", 13);	
		dataMap.put("ZC", 14);	dataMap.put("ZD", 15);	dataMap.put("ZE", 16);	
		dataMap.put("ZF", 17);	dataMap.put("ZG", 18);	dataMap.put("ZH", 19);
		dataMap.put("ZI", 20);	dataMap.put("ZJ", 21);	dataMap.put("ZK", 22);	
		dataMap.put("ZL", 23);	dataMap.put("ZM", 24);	dataMap.put("ZN", 25);	
		dataMap.put("ZO", 26);  dataMap.put("ZP", 27);  dataMap.put("ZQ", 28);	
		dataMap.put("ZR", 29);	dataMap.put("ZS", 30);	dataMap.put("ZT", 31);	
		dataMap.put("ZU", 32);	dataMap.put("ZV", 33);	dataMap.put("ZW", 34);
		dataMap.put("ZX", 35);	dataMap.put("ZY", 36);	dataMap.put("ZZ", 37);	
		dataMap.put("WR", 38);	dataMap.put("S", 39);
		
		dataMap.put("A1", 41);  dataMap.put("A2", 42);  dataMap.put("A3", 43);  dataMap.put("A4", 44);
		dataMap.put("B1", 45);  dataMap.put("B2", 46);  dataMap.put("B3", 47);  dataMap.put("B4", 48);
		dataMap.put("C1", 49);  dataMap.put("C2", 50);  dataMap.put("C3", 51);  dataMap.put("C4", 52);
		dataMap.put("D1", 53);  dataMap.put("D2", 54);  dataMap.put("D3", 55);  dataMap.put("D4", 56);
		dataMap.put("E1", 57);  dataMap.put("E2", 58);	dataMap.put("E3", 59);  dataMap.put("E4", 60);
		dataMap.put("F1", 61);  dataMap.put("F2", 62);  dataMap.put("F3", 63);  dataMap.put("F4", 64);
		dataMap.put("G1", 65);  dataMap.put("G2", 66);  dataMap.put("G3", 67);  dataMap.put("G4", 68);
		dataMap.put("H1", 69);  dataMap.put("H2", 70);  dataMap.put("H3", 71);  dataMap.put("H4", 72);
		dataMap.put("P1", 73);  dataMap.put("P2", 74);  dataMap.put("P3", 74);  dataMap.put("P4", 76);
		dataMap.put("J1", 77);  dataMap.put("J2", 78);  dataMap.put("J3", 79);  dataMap.put("J4", 80);
		dataMap.put("L1", 81);  dataMap.put("L2", 82);
		dataMap.put("K1", 83);  dataMap.put("K2", 84);  dataMap.put("K3", 85);
		dataMap.put("K4", 86);  dataMap.put("K5", 87);  dataMap.put("K6", 88);
		dataMap.put("M1", 89);  dataMap.put("M2", 90);  dataMap.put("M3", 91);
		dataMap.put("Q1", 92);  dataMap.put("Q2", 93);  dataMap.put("Q3", 94);  dataMap.put("Q4", 95);
		dataMap.put("Q5", 96);  dataMap.put("Q6", 97);  dataMap.put("Q7", 98);
	}

	public String getSivName() {
		return sivName;
	}

	public void setSivName(String sivName) {
		this.sivName = sivName;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	@Override
	public int compareTo(SIVComparable o) {
		int flag=this.getValue().compareTo(o.getValue());
		if(flag==0){
		   return -dataMap.get(this.getSivName()).compareTo(dataMap.get(o.getSivName()));
		   //return -this.getSivName().compareTo(o.getSivName());
		}
		else{
		   return flag;
		}
	}
}
