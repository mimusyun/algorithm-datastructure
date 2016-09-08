package com.mimusyun.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import com.mimusyun.datastructure.BNode;
import com.mimusyun.datastructure.TreeNode;

public class BinarySearchTreeAlg {
	
	
	public static TreeNode createBinaryTree() {
		
		TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(4);
//        root.left.left.left = new TreeNode(8);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(10);
		
		return root;
	}
	
	public int sumItr(TreeNode root) { 
	    
	    int total = 0;
	    
	    if(root==null) return total;
	    Stack<TreeNode> st = new Stack<>();
	    st.push(root);
	    
	    while(!st.isEmpty()) {
	        TreeNode node = st.pop();
	        total += node.data;
	        if(node.left!=null) st.push(node.left);
	        if(node.right!=null) st.push(node.right);
	    }
	    
	    return total;

	}
	
	public static int numberOfFullNodes(TreeNode root) { 
	    
	    if(root==null) return 0;
	    
	    Stack<TreeNode> st = new Stack<>();
	    st.push(root);
	    int cnt = 0;
	    
	    while(!st.isEmpty()) {
	        TreeNode node = st.pop();
	        boolean left = node.left!=null;
	        boolean right = node.right!=null;
	        
	        if(left && right) cnt++;
	        if(left) st.push(node.left);
	        if(right) st.push(node.right);
	    }
	    
	    return cnt;
	    
	}
	
	public static TreeNode findKthLargest(TreeNode root, int k) {
		if(root==null) return null;
	    int rightSize = 0;
	    if(root.right!=null) rightSize = findTreeSize(root.right);
	    if(rightSize+1 == k) { 
            return root;
        } else if(k > rightSize+1) {
            return findKthLargest(root.left, k-rightSize-1);
        } else {
            return findKthLargest(root.right, k);
        }
	}
	
	public static int findTreeSize(TreeNode root) {
		if (root == null) return 0;
	    return 1 + findTreeSize(root.left) + findTreeSize(root.right);
	}
	
	public static TreeNode decompressTree(String str){
	    
		if(str.length()==1) {
			if(str.equals("*")) return null;
			else return new TreeNode(Integer.valueOf(str), null, null);
		}
		String[] arr = str.split(",");
	    LinkedList<String> nodes = new LinkedList<>(Arrays.asList(arr));
	    TreeNode root = new TreeNode(Integer.valueOf(nodes.remove()), null, null);
	    LinkedList<TreeNode> st = new LinkedList<>();
	    st.add(root);
	    
	    while(!nodes.isEmpty()) {
	    	TreeNode node = st.remove();
	    	String left = nodes.remove();
	    	String right = nodes.remove();
	    	if(!left.equals("*")) {
	    		node.left = new TreeNode(Integer.valueOf(left), null, null);
	    		st.add(node.left);
	    	}
	    	if(!right.equals("*")) {
	    		node.right = new TreeNode(Integer.valueOf(right), null, null);
	    		st.add(node.right);
	    	}
	    }
	    
	    return root;
	    
	}	
	
	/** finds the k-th smallest tree node */
	public static TreeNode findKthSmallest(TreeNode root, int k) {
		
	    if(root==null) return null;
	    int leftSize = 0;
	    if(root.left!=null) leftSize = findTreeSize(root.left);
	    if(leftSize+1 == k) { 
            return root;
        } else if(k <= leftSize) {
            return findKthSmallest(root.left, k);
        } else {
            return findKthSmallest(root.right, k-leftSize-1);
        }
	}
	
	public static ArrayList<Integer> preorderItr(TreeNode root) {
	    
		if(root==null) return null;
		
		ArrayList<Integer> ansLst = new ArrayList<>();
		Stack<TreeNode> lst = new Stack<>();
	    lst.add(root);
	    
	    while(!lst.isEmpty()) {
	    	
	    	TreeNode node = lst.pop();
	    	ansLst.add(node.data);
	    	if(node.right!=null) lst.push(node.right);
	    	if(node.left!=null) lst.push(node.left);
	    	
	    }
	    
	    return ansLst;
	    
	}
	
	public static int maxSumPath(TreeNode root) {
		int[] max = new int[1];
		maxSumPathHelper(root, max);
		return max[0];
	}
	
	private static int maxSumPathHelper(TreeNode root, int[] max) {
		
		if (root == null) return 0;
		
		int left = maxSumPathHelper(root.left, max);
		int right = maxSumPathHelper(root.right, max);
	 
		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
	 
		max[0] = Math.max(max[0], Math.max(current, left + root.data + right));
	 
		return current;
	}
	
	
	public static boolean validateBSTItr(TreeNode root) {
		if(root == null) return true;
        
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while(!queue.isEmpty()){
        	BNode b = queue.poll();
        	if(b.n.data <= b.left || b.n.data >=b.right){
        		return false;
        	}
        	if(b.n.left!=null){
        		queue.offer(new BNode(b.n.left, b.left, b.n.data));
        	}
        	if(b.n.right!=null){
        		queue.offer(new BNode(b.n.right, b.n.data, b.right));
        	}
        }
        
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
	
	public static int findDiameter(TreeNode root) {
	    
		if (root == null) return 0;

	    int rootDiameter = findHeight(root.left) + findHeight(root.right) + 1;
	    int leftDiameter = findDiameter(root.left);
	    int rightDiameter = findDiameter(root.right);

	    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));

	}
	
	public static int findHeight(TreeNode root) {
	    if (root == null) return 0;
	    return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
	}
	
	public static TreeNode findMax(TreeNode root) {
        
		if(root==null) return null;
		while(root.right != null) root = root.right;
		
		return root;
		
	}
	
	public static int findSize(TreeNode root) {
		TreeNode _root = root;
		Stack<TreeNode> st = new Stack<>();
		st.push(_root);
		int count = 0;
		
		while(!st.isEmpty()) {
			TreeNode node = st.pop();
			count++;
			if(node.left!=null) st.push(node.left);
			if(node.right!=null) st.push(node.right);
		}
		
		return count;
	}
	
	public ArrayList<Integer> levelorder(TreeNode root) {
	    
	    if(root==null) return null;
	    
	    ArrayList<Integer> lst = new ArrayList<>();
	    LinkedList<TreeNode> st = new LinkedList<>();
	    st.push(root);
	    
	    while(!st.isEmpty()) {
	        TreeNode node = st.remove();
	        lst.add(node.data);
	        if(node.left!=null) st.add(node.left);
	        if(node.right!=null) st.add(node.right);
	    }
	    
	    return lst;

	}
	
	/** Insert TreeNode */
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
	
	/* Serialize & Restore */
	public static String serializeTree(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeTreeHelper(root, sb);
		if(sb.length()>0) sb.deleteCharAt(0);
		return sb.toString();
	}
	
	private static StringBuilder serializeTreeHelper(TreeNode node, StringBuilder sb) {
		if(node==null) sb.append(",#");
		else {
			sb.append(","+node.data);
			serializeTreeHelper(node.left, sb);
			serializeTreeHelper(node.right, sb);
		}
		return sb;
	}
	
	public static int numberOfHalfNodes(TreeNode root) { 
        
		if(root==null) return 0;
		
		Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int counter = 0;
        
        while(!st.isEmpty()) {
        	TreeNode node = st.pop();
        	if(node.left!=null || node.right!=null) counter++;
        	if(node.right!=null) st.add(node.right);
        	if(node.left!=null) st.add(node.left);
        }
	    return counter;
	}
	
	public static TreeNode restoreTree(String str) {
		String[] nodes = str.split(",");
		LinkedList<String> lst = new LinkedList<>(Arrays.asList(nodes));
		return restoreTreeHelper(lst);
	}
	
	private static TreeNode restoreTreeHelper(LinkedList<String> nodes) {
		String nodeData = nodes.remove();
		if(nodeData.equals("#")) return null;
		TreeNode t = new TreeNode(Integer.valueOf(nodeData), null, null);
		t.left = restoreTreeHelper(nodes);
		t.right = restoreTreeHelper(nodes);
		return t;
	}
	
	public boolean isIdenticalIter(TreeNode root1, TreeNode root2) {
	    
	    if(root1 == null && root2 == null) return true;
	    if(root1 == null || root2 == null) return false;
	    
	    Stack<TreeNode> st = new Stack<>();
	    st.push(root1);
	    st.push(root2);
	    
	    while(!st.isEmpty()) {
	        TreeNode first = st.pop();
	        TreeNode second = st.pop();
	        
	        if(first.data!=second.data) return false;
	        if(first.left!=null && second.left==null) return false;
	        if(first.left==null && second.left!=null) return false;
	        
	        if(first.left!=null) st.push(first.left);
	        if(second.left!=null) st.push(second.left);
	        if(first.right!=null) st.push(first.right);
	        if(second.right!=null) st.push(second.right);
	    }
	    
	    return true;

	}
	
	public static TreeNode mirror(TreeNode root) {
		if (root == null)
            return null;
 
        /* do the subtrees */
		TreeNode left = mirror(root.left);
		TreeNode right = mirror(root.right);
 
        /* swap the left and right pointers */
		root.left = right;
		root.right = left;
 
        return root;
	}
	
}
