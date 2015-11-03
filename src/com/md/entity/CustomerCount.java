package com.md.entity;

/**
 * 针对统计在线、注册用户数
 * 
 * @author owen
 * 
 */
public class CustomerCount {

	/** 注册普通人数 */
	private int registerCommonCount;

	/** 注册VIP人数 */
	private int registerVipCount;

	/** 注册医生人数 */
	private int registerExpertCount;

	/** 在线匿名人数 */
	private int onLineAnonymousCount;

	/** 在线普通人数 */
	private int onLineCommonCount;

	/** 在线VIP人数 */
	private int onLineVipCount;

	/** 在线医生人数 */
	private int onLineExpertCount;

	/** 在线 管理员人数 */
	private int onLineManagerCount;

	/** 在线统计人数 */
	private int onLineCount;

	public int getRegisterCommonCount() {
		return registerCommonCount;
	}

	public void setRegisterCommonCount(int registerCommonCount) {
		this.registerCommonCount = registerCommonCount;
	}

	public int getRegisterVipCount() {
		return registerVipCount;
	}

	public void setRegisterVipCount(int registerVipCount) {
		this.registerVipCount = registerVipCount;
	}

	public int getRegisterExpertCount() {
		return registerExpertCount;
	}

	public void setRegisterExpertCount(int registerExpertCount) {
		this.registerExpertCount = registerExpertCount;
	}

	public int getOnLineAnonymousCount() {
		return onLineAnonymousCount;
	}

	public void setOnLineAnonymousCount(int onLineAnonymousCount) {
		this.onLineAnonymousCount = onLineAnonymousCount;
	}

	public int getOnLineCommonCount() {
		return onLineCommonCount;
	}

	public void setOnLineCommonCount(int onLineCommonCount) {
		this.onLineCommonCount = onLineCommonCount;
	}

	public int getOnLineVipCount() {
		return onLineVipCount;
	}

	public void setOnLineVipCount(int onLineVipCount) {
		this.onLineVipCount = onLineVipCount;
	}

	public int getOnLineExpertCount() {
		return onLineExpertCount;
	}

	public void setOnLineExpertCount(int onLineExpertCount) {
		this.onLineExpertCount = onLineExpertCount;
	}

	public int getOnLineManagerCount() {
		return onLineManagerCount;
	}

	public void setOnLineManagerCount(int onLineManagerCount) {
		this.onLineManagerCount = onLineManagerCount;
	}

	public int getOnLineCount() {
		return onLineCount;
	}

	public void setOnLineCount(int onLineCount) {
		this.onLineCount = onLineCount;
	}

}
