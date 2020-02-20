package com.dataStructures.trees.changes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;

class Node4{
	int data;
	Node4 left,right;
	Node4(int value){
		data=value;
		left=right=null;
	}
}
public class BinaryTreeVerticalView {
	Node4 root;
	public BinaryTreeVerticalView() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	BinaryTreeVerticalView(int value){
		root=new Node4(value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeVerticalView bt=new BinaryTreeVerticalView();
		bt.root=new Node4(1);
		
		bt.root.left=new Node4(2);
		bt.root.right=new Node4(3);
		
		bt.root.left.left=new Node4(4);
		bt.root.left.right=new Node4(5);
		
		bt.root.right.left=new Node4(6);
		bt.root.right.right=new Node4(7);
		
		bt.verticalOrderTraversal();
		Map<Integer,List<Integer>> cMap=new HashMap<Integer, List<Integer>>();
		
		levelOrderTraversal(bt.root, cMap, 0);
		
		for(Integer level:cMap.keySet()) {
			List<Integer> lList=cMap.get(level);
			System.out.print("Level "+level+": ");
			for(int i:lList) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public void verticalOrderTraversal() {
		Queue<Node4> q=new LinkedList<Node4>();
		q.add(root);
		while(!q.isEmpty()) {
			Node4 head=q.remove();
			System.out.print(head.data+" ");
			if(head.left!=null)
				q.add(head.left);
			if(head.right!=null)
				q.add(head.right);
		}
		System.out.println();
	}
	public static void levelOrderTraversal(Node4 root,Map<Integer,List<Integer>> cMap,int level) {
		if(root==null)
			return;
		if(cMap.containsKey(level)) {
			List<Integer> temp=cMap.get(level);
			temp.add(root.data);
			cMap.put(level, temp);
		}else {
			List<Integer> temp=new ArrayList<Integer>();
			temp.add(root.data);
			cMap.put(level, temp);
		}
		levelOrderTraversal(root.left, cMap, level+1);
		levelOrderTraversal(root.right, cMap, level+1);
	}

}
