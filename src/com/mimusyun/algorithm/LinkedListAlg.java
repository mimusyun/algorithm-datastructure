package com.mimusyun.algorithm;

import java.util.ArrayList;

import com.mimusyun.datastructure.ListNode;

public class LinkedListAlg {
	
	public static Boolean isListPalindrome(ListNode head) {
        
		if(head==null || head.next==null) return true;
		
		ArrayList<Integer> lst = new ArrayList<>();
		while(head.next!=null) {
			lst.add(head.data);
			head = head.next;
		}
		lst.add(head.data);
				
		for(int i=0; i<lst.size()/2; i++) {
			if(lst.get(i) != lst.get(lst.size()-i-1)) {
				return false;
			}
		}

		return true;

	}
	
	public static ListNode createLinkedList(String str) {
		String[] arr = str.split("->");
		
		ListNode node = new ListNode(Integer.valueOf(arr[0]));
		ListNode head = node;

		for(int i=1; i<arr.length; i++) {
			node.next = new ListNode(Integer.valueOf(arr[i]));
			node = node.next;
		}
		
		return head;
		
	}
	
	public static ListNode insertAtHead(ListNode head, int data) {

		if(head==null) return new ListNode(data);
		
		ListNode newHead = new ListNode(data);
		newHead.next=head;
		
		return newHead;
        
	}
	
	public static Boolean isListEven(ListNode head) {
		
		if(head==null) return null;
	    
		int cnt = 1;
	    while(head.next!=null) {
	    	cnt++;
	    	head=head.next;
	    }
	    
	    return cnt%2 == 0;

	}
	
	
	public static ListNode insertAtPosition(ListNode head, int data, int pos) {
		
		if(head==null) return new ListNode(data);
		
		if(pos==0) {
			return new ListNode(data);
		} else if(pos==1) {
			ListNode newHead = new ListNode(data);
			newHead.next = head;
			return newHead;
		} else {
			
			ListNode cur = head, pre = head;
			
			int cnt = 0;
			while(cnt<pos-1) {
				pre = cur;
				
				cnt++;
				
				if(cur.next!=null) cur = cur.next;
				else if(cur.next==null && cnt==pos-1) {				
					cur.next = new ListNode(data);
					return head;
				}
				else return head;	
			}
			
			pre.next = new ListNode(data);
			pre = pre.next;
			pre.next = cur;
			
			return head;
		}
	
	}
	
public static ListNode deleteAtMiddle(ListNode head, int position) {
		
		if(head==null) return null;
		
		int crtPos = 1;
		ListNode crt = head, last=null;
		
		while(crt.next!=null) {
			if(crtPos==position) break;
			last = crt;
			crt = crt.next;
			crtPos++;
		}
		
		// Delete First Node
		if(last==null) {
			head = null;
			crt = crt.next;
			return crt;
		}
		
		// position exceeds the number of nodes
		if(crtPos<position) {
			return head;
		}
		
		last.next = crt.next;
		crt = null;
		
		return head;
	    
	}

}
