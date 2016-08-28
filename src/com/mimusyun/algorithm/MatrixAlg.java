package com.mimusyun.algorithm;

public class MatrixAlg {
	
	public static void flipHorizontalAxis(int[][] matrix) {
	    for(int i=0; i<matrix.length/2; i++) {
	        int[] tmp = matrix[i];
	        matrix[i] = matrix[matrix.length-i-1];
	        matrix[matrix.length-i-1] = tmp;
	    }
	}
	
	public static void transposeMatrix(int[][] matrix) {
	    
		int cols=matrix.length;
	    int rows=matrix[0].length;
	    
	    int[][] newMatrix = new int[rows][cols];
	    
	    for(int i=0; i<cols; i++) {
	    	for(int j=0; j<rows; j++) {
	    		int val = matrix[i][j];
	    		newMatrix[j][i] = val;
	    	}
	    }
	    
	    for(int i=0; i<rows; i++) {
	    	for(int j=0; j<cols; j++) {
	    		matrix[i][j] = newMatrix[i][j];
	    	}
	    }
	}

}
