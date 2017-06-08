package org.bran.valueBean;

public class Reader {
	/**
	 * 读者类型
	 */
	public static final String MANAGER="0";
	public static final String USER="1";
	
	
	private int id;
	private String name;
	private String type;	//读者类型
	private boolean isViolate;//是否违约
	private int maximum;//最大借阅量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isViolate() {
		return isViolate;
	}
	public void setViolate(boolean isViolate) {
		this.isViolate = isViolate;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}
