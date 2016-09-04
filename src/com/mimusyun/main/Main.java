package com.mimusyun.main;

import java.util.ArrayList;
import java.util.Stack;

import com.mimusyun.algorithm.*;
import com.mimusyun.datastructure.*;
import com.mimusyun.algorithm.book.examples.*;

public class Main {
	
	public static void main(String[] args) {
		TreeNode node = BinarySearchTreeAlg.createBinaryTree();
		int bool = BinarySearchTreeAlg.numberOfHalfNodes(node);
		print(bool);
	}
	
	public static void print(Object str){
		System.out.println(str.toString());
	}
	
	public ArrayList<Integer> preorderItr(TreeNode root) {
	    
	    ArrayList<Integer> ansLst = new ArrayList<>();
	    if(root==null) return ansLst;
	    
	    Stack<TreeNode> st = new Stack<>();
	    st.add(root);
	    
	    while(!st.isEmpty()) {
	        TreeNode node = st.pop();
	        ansLst.add(node.data);
	        
	        if(node.right!=null) st.push(node.right);
	        if(node.left!=null) st.push(node.left);
	    }
	    
	    return ansLst;

	}
	

}













