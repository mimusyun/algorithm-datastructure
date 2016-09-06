package com.mimusyun.algorithm;

import java.util.HashMap;

public class StringAlg {
	
	public static String replace(String a, String b) {
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)==' ') sb.append(b);
			else sb.append(a.charAt(i));
		}
		
		return sb.toString();

	}
	
	public static String reverseString(String str){
		if(str==null) return null;
		
	    String inputString = str;
	    char[] arr = inputString.toCharArray();
	    
	    for(int i=0; i<str.length()/2; i++) {
	    	char tmp = arr[i];
	    	arr[i] = arr[str.length()-i-1];
	    	arr[str.length()-i-1] = tmp;
	    }
	    
	    return new String(arr);
	}
	
	public static boolean permutation(String str1, String str2) {
	    
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		
		for(Character c : str1.toCharArray()) {
			if(map1.containsKey(c)) map1.put(c, map1.get(c)+1);
			else map1.put(c, 1);
		}
		
		for(Character c : str2.toCharArray()) {
			if(map2.containsKey(c)) map2.put(c, map2.get(c)+1);
			else map2.put(c, 1);
		}
		
		return map1.equals(map2);

	}
	
	public static Character firstNonRepeatedCharacter(String str) {
	    
		boolean first;
		for(int i=0; i<str.length(); i++) {
			first = true;
			for(int j=0; j<str.length(); j++) {
				if(i!=j && str.charAt(i) == str.charAt(j)) {
					first = false;
					break;
				}
			}
			if(first) return new Character(str.charAt(i));
		}
		
		return null;
	    
	}
	
	public static String insertPairStar(String s) {
		
		if(s==null) return null;
		 
		if(s.length()<2) return s;
		
		StringBuffer sb = new StringBuffer();
		if(s.charAt(0)==s.charAt(1)) {
			sb.append(s.charAt(0));
			sb.append('*');
		} else {
			sb.append(s.charAt(0));
		}
		
		return sb.toString() + insertPairStar(s.substring(1));
		 
	}
}
