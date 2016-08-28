package com.mimusyun.algorithm;

import java.util.ArrayList;

public class OtherAlg {
	
	public static ArrayList<String> validParentheses(int openP, int closeP, String string, ArrayList<String> arr) {
		
		print(openP + "-" +closeP + " START " + string);
		if (openP == 0 && closeP == 0) {
			print("### ADD 0-0 " + string );
			arr.add(string);
		}
		
		if (openP > closeP){
			print(openP + ">" +closeP + " " + string);
			return null;
		}
		
		if (openP > 0) {
			print(openP + "-" +closeP + " openP>0 " + string);
			validParentheses(openP - 1, closeP, string + "(", arr);
		}
		if (closeP > 0) {
			print(openP + "-" +closeP + " closeP>0 " + string);
			validParentheses(openP, closeP - 1, string + ")", arr); 
		}
		
		print(openP + "-" +closeP + " return " + string);
		return arr;
	}

	public static ArrayList<String> printParentheses(int n) {
		return validParentheses(n, n, "", new ArrayList<String>());
	}
	
	public static void print(String str){
		System.out.println(str);
	}
	
	public static void print(Object str){
		System.out.println(str);
	}

}
