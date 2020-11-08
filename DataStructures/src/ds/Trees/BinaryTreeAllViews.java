package com.dataStructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
	Node n;
	int h;
	int v;
	public Pair(Node n,int h) {
		this.n=n;
		this.h=h;
	}
	public Pair(Node n,int h,int v) {
		this.n=n;
		this.h=h;
		this.v=v;
	}
}
public class BinaryTreeAllViews {
	static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root=new Node(50);
		root.left=new Node(30);
		root.right=new Node(60);
		root.left.left=new Node(5);
		root.left.right=new Node(20);
		root.right.left=new Node(45);
		root.right.right=new Node(70);
		root.right.right.left=new Node(65);
		root.right.right.right=new Node(80);
		allViews(root);
		root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 
		allViews(root);
	}
	private static void allViews(Node root) {
		if(root==null)
			return;
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(root,0,0));
		List<List<Integer>> level=new ArrayList<>();
		Map<Integer,List<Integer>> cMap=new TreeMap<>();
		while(!q.isEmpty()) {
			Pair temp=q.poll();
			Node r=temp.n;
			int h=temp.h;
			int v=temp.v;
			if(r.left!=null) {
				q.add(new Pair(r.left,h+1,v-1));
			}
			if(r.right!=null) {
				q.add(new Pair(r.right,h+1,v+1));
			}
			List<Integer> tList;
			if(level.size()<h+1) {
				tList=new ArrayList<Integer>();
				tList.add(r.data);
				level.add(h,tList);
			}else {
				tList=level.get(h);
				tList.add(r.data);
				level.set(h,tList);
			}
			if(cMap.containsKey(v)) {
				if(cMap.get(v).size()==1) {
					tList=cMap.get(v);
					tList.add(r.data);
					cMap.put(v,tList);
				}else {
					tList=cMap.get(v);
					tList.set(1,r.data);
					cMap.put(v,tList);
				}
			}else {
				tList=new ArrayList<Integer>();
				tList.add(r.data);
				cMap.put(v,tList);
			}
		}
		System.out.println(level);
		System.out.println(cMap);
		//LeftView
		for(List<Integer> left:level) {
			System.out.print(left.get(0)+" ");
		}
		System.out.println();
			
		//RightView
		for(List<Integer> right:level) {
			System.out.print(right.get(right.size()-1)+" ");
		}
		System.out.println();
		//TopView
		for(Integer top:cMap.keySet()){
			System.out.print(cMap.get(top).get(0)+" ");
		}
		System.out.println();
		//BottomView
		for(Integer bottom:cMap.keySet()){
			System.out.print(cMap.get(bottom).get(cMap.get(bottom).size()-1)+" ");
		}
		System.out.println();
	}

}
