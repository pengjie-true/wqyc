package com.uporanges.util;

public class Value {

	//用户头像地址
	private static final String userPicPath = "";
	//学生简历头像地址
	private static final String studentResumePicPath = "";
	//学生简历地址
	private static final String studentResumePath = "";
	//学生查询公司每次查询数值大小
	private static final int searchCompanySize = 5;

	public static int getSearchcompanysize() {
		return searchCompanySize;
	}

	public static String getStudentresumepicpath() {
		return studentResumePicPath;
	}

	public static String getStudentresumepath() {
		return studentResumePath;
	}

	public static String getUserpicpath() {
		return userPicPath;
	}
	
}
