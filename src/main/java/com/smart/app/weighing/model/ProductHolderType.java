package com.smart.app.weighing.model;

public enum ProductHolderType {

	CLIENT(1, "client"),
	SUPPLIER(2, "supplier");
	
	int code;
	String name;
	
	private ProductHolderType(int code, String name) {
		this.code=code;
		this.name=name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
