package com.uporanges.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Util {
	
	public static void writeJson(HttpServletResponse response, String data){
		response.setContentType("application/json");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
