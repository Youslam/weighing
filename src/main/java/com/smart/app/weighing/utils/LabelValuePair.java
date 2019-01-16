package com.smart.app.weighing.utils;

public class LabelValuePair {

	private String label;
	private String value;
	
	public LabelValuePair() {}
	
	public LabelValuePair(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
