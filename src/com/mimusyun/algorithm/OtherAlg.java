package com.mimusyun.algorithm;

import java.util.ArrayList;
import java.util.HashSet;

import com.mimusyun.datastructure.Interval;

public class OtherAlg {
	
	public static String computeBinary(int val) {
		
		if(val==0) return "0";
		StringBuffer sb = new StringBuffer();
		
		while(val>=1) {
			sb.append(val%2);
			val /= 2;
		}

		return sb.reverse().toString();

	}
	
	public static String computeBinaryRecur(int val) {
		
		if(val<=1) return String.valueOf(val);
		
		return computeBinaryRecur(val/2) + (val%2); 

	}
	
	public static int fib(int n) {
		
		if(n<=1) return n;
		
		int x=0, y=1, cnt=2;
		int tmp = 0;
		while(cnt<=n) {
			tmp = x+y;
			x = y;
			y = tmp;
			cnt++;
		}
		
		return tmp;
		
	}
	
	public static boolean isHappyNumber(int n) {
	    
		HashSet<Integer> map = new HashSet<>();
		map.add(n);
		
		int ans = n;
		while(ans!=1) {
			String str = String.valueOf(ans);
			char[] arr = str.toCharArray();
			
			ans=0;
			for(char c : arr) {
				int v = Character.getNumericValue(c);
				ans += v*v;
			}
			
			if(!map.contains(ans)) map.add(ans);
			else return false;	
		}
		
		return true;

	}
	
	public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervalsList) {
		
		if(intervalsList.size()==0) return new ArrayList<Interval>();
		
		ArrayList<Interval> ansArr = new ArrayList<>();
		
		for(int i=0; i<intervalsList.size(); i++) {
			
			boolean merge = false;
			Interval interval = intervalsList.get(i);
			
			for(int j=0; j<ansArr.size(); j++) {
				
				Interval in = ansArr.get(j);
				boolean isMerge = (in.start <= interval.start && interval.start <= in.end);
				
				if(i == j || !isMerge) continue;
					
				merge = true;
				int start = in.start;
				int end = (in.end>interval.end) ? in.end : interval.end;
					
				ansArr.set(j, new Interval(start, end));
				break;
				
			}
			if(!merge) ansArr.add(interval);

		}
		
		return ansArr;	    
	}

	public static ArrayList<String> printParentheses(int n) {
		return validParentheses(n, n, "", new ArrayList<String>());
	}
	
	private static ArrayList<String> validParentheses(int openP, int closeP, String string, ArrayList<String> arr) {
		
		// print(openP + "-" +closeP + " START " + string);
		if (openP == 0 && closeP == 0) {
			print("### ADD 0-0 " + string );
			arr.add(string);
		}
		
		if (openP > closeP){
			// print(openP + ">" +closeP + " " + string);
			return null;
		}
		
		if (openP > 0) {
			// print(openP + "-" +closeP + " openP>0 " + string);
			validParentheses(openP - 1, closeP, string + "(", arr);
		}
		if (closeP > 0) {
			// print(openP + "-" +closeP + " closeP>0 " + string);
			validParentheses(openP, closeP - 1, string + ")", arr); 
		}
		
		print(openP + "-" +closeP + " return " + string);
		return arr;
	}
	
	public static void print(String str){
		System.out.println(str);
	}
	
	public static void print(Object str){
		System.out.println(str);
	}

}
