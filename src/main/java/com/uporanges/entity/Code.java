package com.uporanges.entity;

public class Code {

	private Integer code_id;
	private String code_name;
	private String code_content;
	public Code() {}
	public Code(Integer code_id, String code_name, String code_content) {
		super();
		this.code_id = code_id;
		this.code_name = code_name;
		this.code_content = code_content;
	}
	public Integer getCode_id() {
		return code_id;
	}
	public void setCode_id(Integer code_id) {
		this.code_id = code_id;
	}
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public String getCode_content() {
		return code_content;
	}
	public void setCode_content(String code_content) {
		this.code_content = code_content;
	}
	
}
