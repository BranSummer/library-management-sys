package org.bran.valueBean;

public class Reader {
	private int id;
	private String name;
	private String type;	//读者类型
	private boolean isViolate;//是否违约
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
	
	
}
