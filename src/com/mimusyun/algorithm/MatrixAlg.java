package com.mimusyun.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixAlg {
	
	public static void printMatrix(int[][] matrix) {
		System.out.println(Arrays.deepToString(matrix));
	}
	
	public void print(int arr[][],int row, int col,int result[],int pos){
        System.out.println(row + " " + col);
		if(row == arr.length-1 && col == arr[0].length-1){
            result[pos] = arr[row][col];
            System.out.println(Arrays.toString(result));
            return;
        }
        if(row >= arr.length || col >= arr[0].length){
            return;
        }
        
        result[pos] = arr[row][col];
        print(arr,row,col+1,result,pos+1);
        print(arr,row+1,col,result,pos+1);
    }
	
	public static void flipItVerticalAxis(int[][] matrix) {
	    for(int[] arr : matrix) {
	        for(int i=0; i<arr.length/2; i++) {
	            int tmp = arr[i];
	            arr[i] = arr[arr.length-1-i];
	            arr[arr.length-1-i] = tmp;
	        }
	    }
	}
	
	public static void rotateSquareImageCW(int[][] matrix) {
	    transposeMatrix(matrix);
	    flipItVerticalAxis(matrix);
	}	
	
	public static void rotateSquareImageCCW(int[][] matrix) {
	    transposeMatrix(matrix);
	    flipItHorizontalAxis(matrix);
	}	
	
	public static ArrayList<Integer> findSpiral(int[][] arr) {
		
		ArrayList<Integer> spiralOrder = new ArrayList<>();
		if(arr == null || arr.length == 0) return spiralOrder;
		int m=arr.length, n=arr[0].length;
		int x=0, y=0;
		while(m>0 & n>0) {
			
			if(m<=1) {
				for(int i=0; i<n; i++) {
					spiralOrder.add(arr[x][y++]);
				}
				break;
			
			} else if (n<=1) {
				for(int i=0; i<m; i++) {
					spiralOrder.add(arr[x++][y]);
				}
				break;
			}
			
			for(int i=0; i<n-1; i++) {
				spiralOrder.add(arr[x][y++]);
			}
			for(int j=0; j<m-1; j++) {
				spiralOrder.add(arr[x++][y]);
			}
			for(int j=0; j<n-1; j++) {
				spiralOrder.add(arr[x][y--]);
			}
			for(int j=0; j<m-1; j++) {
				spiralOrder.add(arr[x--][y]);
			}
			
			x++;
			y++;
			m=m-2;
			n=n-2;
		}
		
		return spiralOrder;
	}
	
	public static void print(Object str){
		System.out.println(str.toString());
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
