package com.mimusyun.algorithm;

import java.util.ArrayList;
import java.util.HashSet;

import com.mimusyun.datastructure.ListNode;

public class LinkedListAlg {
	
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

	    ListNode newHead = new ListNode(data);
	    
	    if(head==null) return newHead;
	    
	    newHead.next = head;
	    return newHead;

	}
	
	public static ListNode createCircularList(String str) {
		String[] arr = str.split("->");
		
		ListNode node = new ListNode(Integer.valueOf(arr[0]));
		ListNode head = node;

		for(int i=1; i<arr.length; i++) {
			node.next = new ListNode(Integer.valueOf(arr[i]));
			node = node.next;
		}
		
		node.next = head;

		return head;
	}
	
	public ListNode insertAtTail(ListNode head, int data) {
	    
	    if(head==null) return new ListNode(data);
	    
	    ListNode _head = head;
	    while(_head.next!=null) _head=_head.next;
	    _head.next = new ListNode(data);
	    
	    return head;

	}
	
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
	
	public static Boolean isCyclic(ListNode head) {
	    
		if(head==null) return null;
		
		HashSet<Integer> set = new HashSet<>();
		set.add(head.data);
		
	    while(head.next!=null) {
	    	head = head.next;
	    	if(set.contains(head.data)) return true;
	    	else set.add(head.data);
	    }
	    
	    return false;

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
	
	public static ListNode reverseList(ListNode head) {
	    
		if(head==null) return null;
		
		ListNode curr = head;
	    ListNode prev = null;
	    ListNode next = null;
	    
	    while(curr!=null) {
	    	next = curr.next;
	    	curr.next = prev;
	    	prev = curr;
	    	curr = next;
	    }
		
	    return prev;

	}
	
	public static ListNode findNthNodeFromEnd(ListNode head, int n) {
        
		if(head==null) return null;
		
		ListNode current = head;
		
		int len = 1;
		while(head!=null) {
			head = head.next;
			len++;
		}
		
		int pos = len-n;
		int cur = 1;
		
		while(cur<pos) {
			current = current.next;
			cur++;
		}
		
		return current;
		
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode node = head;
	    
	    while (node != null && n > 0) {
	    	node = node.next;
	        n--;
	    }
	    if (node == null)
	        if (n > 0) return head;
	        else return head.next;
	    
	    ListNode rm = head;
	    while (node.next != null) {
	    	node = node.next;
	        rm = rm.next;
	    }
	    ListNode t = rm.next;
	    rm.next = t.next;

	    return head;
	}
	
	public static ListNode insertAtTailInCircularList(ListNode head, int data) {            
	      ListNode newNode = new ListNode(data);            
	      ListNode curr = head;             
	      newNode.next = newNode; //after creation, point to itself
	      if(head == null) {
	              head = newNode;
	      } else {
	          while(curr.next != head) {
	                  curr = curr.next;             
	          }
	          newNode.next = head;
	          curr.next = newNode;
	      }
	      return head;
	      
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


	
	

}
