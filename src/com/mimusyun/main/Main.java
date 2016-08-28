package com.mimusyun.main;

import com.mimusyun.algorithm.*;
import com.mimusyun.datastructure.*;

public class Main {
	
	public static void main(String[] args) {
		
		TreeNode node = BinarySearchTreeAlg.createBinaryTree();
		print(maxSumPath(node));
		
	}
	
	public static int maxSumPath(TreeNode root) {
	    int[] maxRecursiveHolder = new int[1];
	    return maxSumPathMain(root, maxRecursiveHolder);
	}
	
	private static int maxSumPathMain(TreeNode root, int[] holder) {
		if(root==null) return 0;
		
		int leftSum = maxSumPathMain(root.left, holder);
		int rightSum = maxSumPathMain(root.right, holder);
		
		int nodeCumVal = Math.max(root.data + leftSum, root.data + rightSum);
		print(leftSum + " " + rightSum + " " + nodeCumVal);
		holder[0] = Math.max(holder[0], leftSum + root.data + rightSum);
		return nodeCumVal;
		
	}
	
	public static void print(Object str){
		System.out.println(str.toString());
	}
	

}













