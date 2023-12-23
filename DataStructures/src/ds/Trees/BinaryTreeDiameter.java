package com.dataStructures.trees;

class Node3 {
    int data;
    Node3 left, right;

    Node3(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTreeDiameter {
    Node3 root;

    public BinaryTreeDiameter() {
        // TODO Auto-generated constructor stub
        root = null;
    }

    public BinaryTreeDiameter(int value) {
        root = new Node3(value);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTreeDiameter bt = new BinaryTreeDiameter();
        int arr[] = {23, 1, 56, 24, 45, 34, 25, 32, 12, 5, 6};
        for (int i : arr) {
            bt.root = insert(bt.root, i);
        }
        System.out.println(diameterBT(bt.root) + " " + height(bt.root));
    }

    public static Node3 insert(Node3 root, int value) {
        if (root == null) {
            root = new Node3(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        }
        if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static int diameterBT(Node3 root) {
        if (root == null)
            return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int ld = diameterBT(root.left);
        int rd = diameterBT(root.right);

        //Because end leaf nodes can be present only in left subtree or right subtree
        return Math.max(lHeight + rHeight + 1, Math.max(ld, rd));
    }

    public static int height(Node3 root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
