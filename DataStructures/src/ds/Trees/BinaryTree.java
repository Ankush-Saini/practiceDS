package com.dataStructures;

class Node{
	int data;
	Node left,right;
	
	public Node(int item) {
		data=item;
		left=right=null;
	}
}
public class BinaryTree {
	//Define Root
	Node root;
	
	//constructors
	BinaryTree(int item){
		root=new Node(item);
	}
	
	BinaryTree(){
		root=null;
	}
	
	public static void main(String args[]) {
		//Initialize the tree
		BinaryTree bt=new BinaryTree();
		
		//Create Root
		bt.root=new Node(1);
		
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);
		
		bt.root.left.left=new Node(4);
		bt.root.left.right=new Node(5);
		
		/* Sample output of the tree will be:
		 *			
		 *			|
		 * 			1
		 * 		   / \
		 * 		  2   3
		 * 		 / \
		 * 		4   5
		 */
		inOrder(bt.root);
		
		System.out.println();
		
		int arr[]={23,1,56,24,45,34,24,32,12,5,6};

		BinaryTree bt1=new BinaryTree();
		
		for(int i=0;i<arr.length;i++){
			bt1.root=insert(bt1.root,arr[i]);
		}
		inOrder(bt1.root);
	}
	public static Node insert(Node root,int value){
		if(root==null){
			root=new Node(value);
			return root;
		}
		
		if(value<root.data){
			root.left=insert(root.left,value);
		}
		else if(value>root.data){
			root.right=insert(root.right,value);
		}
		return root;
	}
	public static void inOrder(Node root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		
		System.out.print(root.data+" ");
		
		inOrder(root.right);
	}
}
