package com.mimusyun.algorithm;

import java.util.Arrays;

public class MatrixAlg {
	
	public static void printMatrix(int[][] matrix) {
		System.out.println(Arrays.deepToString(matrix));
	}
	
	public static void rotateSquareImageCCW(int[][] matrix) {
	    transposeMatrix(matrix);
	    flipItHorizontalAxis(matrix);
	}	


//	public static void transposeMatrix(int[][] matrix) {
//	    int n = matrix.length - 1;
//	    int temp = 0;
//	    for(int i = 0; i <= n; i++){
//	        for(int j = i+1; j <= n; j++){
//	            temp = matrix[i][j];
//	            matrix[i][j] = matrix[j][i];
//	            matrix[j][i] = temp;
//	        }
//	    }
//	}


	private static void flipItHorizontalAxis(int[][] matrix) {
	    int r = matrix.length - 1, c = matrix[0].length - 1;
	    int temp = 0;
	    for(int i = 0; i <= r/2; i++){
	        for(int j = 0; j <= c; j++){
	            temp = matrix[i][j];
	            matrix[i][j] = matrix[r-i][j];
	            matrix[r-i][j] = temp;
	        }
	    }
	}
	
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
