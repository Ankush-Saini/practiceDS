package com.dataStructures.trees;

class Node1{
	int data;
	Node1 left,right;
	
	Node1(int value){
		data=value;
		left=right=null;
	}
}
public class BinaryTreeIdentical {
	Node1 root;
	
	BinaryTreeIdentical() {
		root=null;
	}
	BinaryTreeIdentical(int value){
		root=new Node1(value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeIdentical bt1=new BinaryTreeIdentical();
		BinaryTreeIdentical bt2=new BinaryTreeIdentical();
		
		//Create Root
		bt1.root=new Node1(1);

		bt1.root.left=new Node1(2);
		bt1.root.right=new Node1(3);

		bt1.root.left.left=new Node1(4);
		bt1.root.left.right=new Node1(5);

		//Create Root
		bt2.root=new Node1(1);

		bt2.root.left=new Node1(2);
		bt2.root.right=new Node1(3);

		bt2.root.left.left=new Node1(4);
		bt2.root.left.right=new Node1(5);		
		
		System.out.println(isIdentical(bt1.root, bt2.root));
	}
	public static boolean isIdentical(Node1 root1,Node1 root2) {
		if(root1==null&&root2==null) {
			return true;
		}
		return (root1!=null && root2!=null) && root1.data==root2.data 
				&& isIdentical(root1.left, root2.left)
				&&isIdentical(root1.right, root2.right); 
	}
}
