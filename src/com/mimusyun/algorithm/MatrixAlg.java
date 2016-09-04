package com.mimusyun.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixAlg {
	
	public static void printMatrix(int[][] matrix) {
		System.out.println(Arrays.deepToString(matrix));
	}
	
	public static void rotateSquareImageCCW(int[][] matrix) {
	    transposeMatrix(matrix);
	    flipItHorizontalAxis(matrix);
	}	
	
	public static void findSpiral(int[][] arr) {
		printTopRight(arr, 0, 0, arr.length, arr[0].length);
	}
	
	public static void printTopRight(int a[][], int x1, int y1, int x2, int y2) {
	    int i = 0, j = 0;

	    // print values in the row.
	    for(i = x1; i<=x2; i++) {
	    	System.out.print(a[y1][i]+ " ");
	    }
	    

	    // print values in the column.
	    for(j = y1 + 1; j <= y2; j++) {
	    	System.out.print(a[j][x2]+ " ");
	    }

	    // see if more layers need to be printed.
	    if(x2-x1 > 0) {
	        // if yes recursively call the function to 
	        // print the bottom left of the sub matrix.
	        printBottomLeft(a, x1, y1 + 1, x2-1, y2);
	    }
	}

	// function to print the bottom-left peel of the matrix and 
	// recursively call the print top-right on the submatrix.
	public static void printBottomLeft(int a[][], int x1, int y1, int x2, int y2) {
	    int i = 0, j = 0;

	    // print the values in the row in reverse order.
	    for(i = x2; i>=x1; i--) {
	        System.out.print(a[y2][i] + " ");
	    }

	    // print the values in the col in reverse order.
	    for(j = y2 - 1; j >= y1; j--) {
	    	System.out.print(a[j][x1] + " ");
	    }

	}

	
	


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
