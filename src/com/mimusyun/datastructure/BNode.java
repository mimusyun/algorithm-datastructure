package com.mimusyun.datastructure;

public class BNode{
    public TreeNode n;
    public int left;
    public int right;
    public BNode(TreeNode n, int left, int right){
        this.n = n;
        this.left = left;
        this.right = right;
    }
}