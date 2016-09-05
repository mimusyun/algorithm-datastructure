package com.mimusyun.main;

import java.util.ArrayList;
import java.util.Stack;

import com.mimusyun.algorithm.*;
import com.mimusyun.datastructure.*;
import com.mimusyun.algorithm.book.examples.*;

public class Main {
	
	public static void main(String[] args) {
		
		ListNode _node = LinkedListAlg.createLinkedList("1");
		ListNode node = removeDuplicates(_node);
		
		while(node!=null) {
			print(node.data);
			node = node.next;
		}
		
		
	}
	
	public static ListNode removeDuplicates(ListNode head) {
        
		if(head==null) return null;
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode _head = head;
		
		while(_head.next!=null) {
			curr = _head.next;
			prev = _head;
			while(curr!=null) {
				if(_head.data==curr.data) {
					prev.next = curr.next;
					curr=null;
					continue;
				}
				prev = curr;
				curr = curr.next;
			}
			_head = _head.next;
		}

		return head;


	    
	}
	
	public static void print(Object str){
		System.out.println(str.toString());
	}
	
	public ArrayList<Integer> ancestorsList = new ArrayList<Integer>();
	public static boolean printAncestors(TreeNode node, int target) {
		
		/* base cases */
        if (node == null) return false;
        if (node.data == target) return true;
  
        /* If target is present in either left or right subtree 
           of this node, then print this node */
        if (printAncestors(node.left, target)) {
        	System.out.print(node.data + " ");
            return true;
        } else if (printAncestors(node.right, target)) {
        	System.out.print(node.data + " ");
            return true;
        }
                
  
        /* Else return false */
        return false;
   	    
	}
	

}













