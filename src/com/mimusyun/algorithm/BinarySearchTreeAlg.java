package com.mimusyun.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import com.mimusyun.datastructure.TreeNode;

public class BinarySearchTreeAlg {
	
	
	public static TreeNode createBinaryTree() {
		
		TreeNode one = new TreeNode(1,null,null);
		TreeNode two = new TreeNode(2,null,null);
		TreeNode three = new TreeNode(3,null,null);
		TreeNode four = new TreeNode(4,null,null);
		TreeNode five = new TreeNode(5,null,null);
		TreeNode six = new TreeNode(5,null,null);
		TreeNode seven = new TreeNode(5,null,null);
		
		one.left=two;
		one.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
		
		return one;
	}
	
	public static String serializeTree(TreeNode root){
		return "a";
	}
	
	

	public void restoreTree(String str){
	    System.out.println();
	}
	
	public static boolean validateBSTItr(TreeNode root) {
		
		
        return true;
	}
	
	public static boolean validateBST(TreeNode root) {
	    return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public TreeNode findNode(TreeNode root, int val) {
	    
	    if(root==null) return null;
	    
	    Stack<TreeNode> unvisited = new Stack<>();
	    unvisited.push(root);
	    
	    while(!unvisited.isEmpty()) {
	        TreeNode node = unvisited.pop();
	        if(node.data == val) return node;
	        if(node.right!=null) unvisited.push(node.right);
	        if(node.left!=null) unvisited.push(node.left);
	    }
	    
	    return null;
	    
	}

	private static boolean validate(TreeNode root, int left, int right){
	    
	    if (root==null) return true; 
	    if (root.data<=left || root.data>=right) return false;
	    
	    return validate(root.left, left, root.data) && validate(root.right, root.data, right);
	}
	
	public static TreeNode findDeepest(TreeNode root) { 
	    
	    if(root==null) return null;
	    
	    LinkedList<TreeNode> lst = new LinkedList<>();
	    lst.add(root);
	    
	    TreeNode node = root;
	    
	    while(!lst.isEmpty()) {
	        node = lst.remove();
	        if(node.left!=null) lst.add(node.left);
	        if(node.right!=null) lst.add(node.right);
	    }
	    
	    return node;
	    
	}
	
	public static ArrayList<Integer> preorderItr(TreeNode root) {
	    
	    ArrayList<Integer> lst = new ArrayList<>();
	    Stack<TreeNode> unvisited = new Stack<>();
	    
	    if(root==null) return lst;
	    unvisited.push(root);
	    
	    while(!unvisited.empty()) {
	        TreeNode node = unvisited.pop();
	        lst.add(node.data);
	        if(node.right != null) unvisited.push(node.right);
	        if(node.left != null) unvisited.push(node.left);
	    }
	    
	    return lst;
	    
	}
	
	public static int diameter(TreeNode root) {
	    
		if (root == null) return 0;

	    int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
	    int leftDiameter = diameter(root.left);
	    int rightDiameter = diameter(root.right);

	    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));

	}
	
	public static int getHeight(TreeNode root) {
	    if (root == null) return 0;
	    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public static TreeNode findMax(TreeNode root) {
        
		if(root==null) return null;
		while(root.right != null) root = root.right;
		
		return root;
		
	}
	
	public static TreeNode insert(TreeNode root, int data) { 
	    
		TreeNode newNode = new TreeNode(data,null,null);
		if (root == null) {
	        return newNode;
	    } else if (newNode.data > root.data) {
	    	root.right = insert(root.right, data);
	    } else if (newNode.data < root.data) {
	    	root.left = insert(root.left, data);
	    }

	    return root;

	}
	
	public static ArrayList<Integer> inorderItr(TreeNode root) {
	    
		if(root==null) return new ArrayList<>();
		
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		TreeNode node = root;
		
		while(!st.isEmpty() || node!=null) {
			
			if(node!=null) {
				st.push(node);
				node = node.left;
			} else {
				node=st.pop();
				ans.add(node.data);
				node = node.right;
			}
			
		}
		
		return ans;

	}
	
	public static ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        
		LinkedList<TreeNode> lst = new LinkedList<>();
		LinkedList<TreeNode> children = new LinkedList<>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		lst.add(root);
		
		while(!lst.isEmpty()) {
			ArrayList<Integer> l = new ArrayList<>();
			
			while(!lst.isEmpty()) {
				TreeNode node = lst.pollLast();
				l.add(node.data);
				if(node.left!=null) children.push(node.left);
				if(node.right!=null) children.push(node.right);
			}
			
			ans.add(l);
			
			for(TreeNode n : children) lst.add(n);
			children.clear();
		}
		
		return ans;

	}
	
	public static int minTreeDepth(TreeNode root) {
		
		if (root == null) return 0;

        int left = minTreeDepth(root.left);
        int right = minTreeDepth(root.right);

        // current node is not leaf node
        if (root.left == null) {
            return 1 + right;
        } else if (root.right == null) {
            return 1 + left;
        }

        return (left<right) ? 1+left : 1+right;
	    
	}

	public static int maxTreeDepth(TreeNode root) {
	    
	    if (root == null) return 0;
	    
	    int left = maxTreeDepth(root.left);
	    int right = maxTreeDepth(root.right);

	    if (root.left == null) {
	        return 1 + right;
	    } else if (root.right == null) {
	        return 1 + left;
	    }
	    
	    return (left>right) ? 1+left : 1+right;

	}

}
