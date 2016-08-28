package com.mimusyun.algorithm;

public class ArrayAlg {
	
	public static int[] coupleSum(int[] numbers, int target) {
	    
	    int len = numbers.length;
	    int first=0, second=0;
	    
	    for(int i=0; i<len; i++){
	        for(int j=i+1; j<len; j++){
	            if(numbers[i]+numbers[j]==target){
	                first = i;
	                second = j;
	                break;
	            }
	        }
	    }
	    
	    return new int[]{first+1, second+1};
	    
	}
	
	public static int singleNumber(int[] A) {
	    
		int ans = A[0];		
	    for(int i=0; i<A.length; i++) {
	    	for(int j=0; j<A.length; j++) {
	    		if(i != j && A[i] == A[j]) break;
	    	}
	    	ans = A[i];
	    }

	    return ans;

	}
	

	public static int[] rotateLeft(int[] arr, int k) {
	    
		int len = arr.length;
		int[] ans = new int[len];
	    if(k>len) k=k%len;
	    
	    int i, j=0;
	    
	    for(i=0; i<len-k; i++) {
	    	ans[i] = arr[i+k];
	    }
	    
	    for(; i<len; i++) {
	    	ans[i] = arr[j];
	    	j++;
	    }
	    
	    return ans;
	    
	}
	
	public static int[] bubbleSortArray(int[] arr){
	    
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j+1]<arr[j]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

	    return arr;
	}
	
	public static int[] selectionSortArray(int[] arr){
	    
		int pos = 0, min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			//find minimum value
			for(int j=i; j<arr.length; j++) {
				if(arr[j]<min) {
					min=arr[j];
					pos=j;
				}
			}
			
			//replace it with arr[i]
			int tmp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = tmp;
			
			//init pos, min
			pos=0;
			min=Integer.MAX_VALUE;
		}

	    return arr;
	}

}
