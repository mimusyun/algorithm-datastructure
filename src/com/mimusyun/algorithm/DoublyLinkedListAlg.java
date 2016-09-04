package com.mimusyun.algorithm;

import com.mimusyun.datastructure.DoublyLinkedNode;

public class DoublyLinkedListAlg {
	
	public static DoublyLinkedNode createDoublyLinkedList(String str) {
		String[] arr = str.split("<=>");
		DoublyLinkedNode node = new DoublyLinkedNode(Integer.valueOf(arr[0]));
		DoublyLinkedNode prev;
		DoublyLinkedNode head = node;
		node.prev = null;
		
		for(int i=1; i<arr.length; i++) {
			prev = node;
			node.next = new DoublyLinkedNode(Integer.valueOf(arr[i]));
			node = node.next;
			node.prev = prev;
		}
		
		return head;
	}
	
	public static DoublyLinkedNode insertAtHead(DoublyLinkedNode head, int data) {

	    DoublyLinkedNode newHead = new DoublyLinkedNode(data);
	    
	    if(head==null) return newHead;
	    
	    newHead.next = head;
	    head.prev = newHead;

	    return newHead;

	}
	
	public static DoublyLinkedNode deleteAtPos(DoublyLinkedNode head, int pos) {
        
		if(head==null) return null;
		if(pos<1) return null;
		else if(pos==1) {
			
			if(head.next==null) return null;
			
			head = head.next;
			head.prev = null;
			return head;
		} 
		
		DoublyLinkedNode node = head;
		for(int i=1; i<pos; i++) {
			if(node.next!=null) node=node.next;
			else return head;
		}
		
		DoublyLinkedNode prev = node.prev;
		DoublyLinkedNode next = node.next;
		node = null;
		prev.next=next;
		
		return head;
		
	}

}
