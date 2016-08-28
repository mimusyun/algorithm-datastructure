package com.mimusyun.datastructure;

import java.util.HashMap;

public class Trie {
    private TrieNode root;
    
    // Implement these methods : 
    public Trie() { this.root = new TrieNode(); }
    
    public void insertWord(String word) {
    	
    	if(word==null || word.length()<1) return;
    	
    	TrieNode node = root;
    	HashMap<Character, TrieNode> children = node.children;
    	
    	for(int i=0; i<word.length(); i++) {
    		
    		char c = word.charAt(i);

    		if(children.containsKey(c)) {
    			node = children.get(c);
    		} else {
    			TrieNode n = new TrieNode(c);
    			children.put(c, n);
    			node = n;
    		}
    		
			children = node.children;
			
			if(i==word.length()-1) node.isLeaf = true;
    		 		
    	}
    }
    
    public Boolean searchWord(String word) {
    	
    	TrieNode node = root;
    	HashMap<Character, TrieNode> children = node.children;
    	
    	for(int i=0; i<word.length(); i++) {
    		
    		char c = word.charAt(i);
    		if(children.containsKey(c)) {
    		    node = children.get(c);
    		    children = node.children;
    		}
    		else return false;
   		}
   		
    	return node.isLeaf;
    }
	
    public Boolean searchPrefix(String word) {
    	if(word==null) return false;
    	
    	TrieNode node = root;
    	HashMap<Character, TrieNode> children = node.children;
    	
    	for(int i=0; i<word.length(); i++) {
    		
    		char c = word.charAt(i);
    		if(children.containsKey(c)) {
    		    node = children.get(c);
    		    children = node.children;
    		}
    		else return false;
   		}
    	return true;
	}
}

