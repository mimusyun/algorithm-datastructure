package com.mimusyun.main;

import java.util.ArrayList;

import com.mimusyun.algorithm.*;
import com.mimusyun.datastructure.*;
import com.mimusyun.algorithm.book.examples.*;

public class Main {
	
	public static void main(String[] args) {
		
		int[][] matrix = new int[][]
				{
			{1,2,3},
			{4,5,6},
			{7,8,9}
				};
		
		MatrixAlg.rotateSquareImageCCW(matrix);
		MatrixAlg.printMatrix(matrix);
	}
	

	public static void print(Object str){
		System.out.println(str.toString());
	}
	

}













