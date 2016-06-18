package datastructure;

import java.util.*;

class TreeNode{
	int data;
	TreeNode left,right;
	
	TreeNode(){
		this.left = null;
		this.right = null;
	}
	
	TreeNode(int value){
		this.data = value;
		this.left = null;
		this.right = null;
	}
}

public class binarSearchTree {
	
	// Insert node in the tree
	public static TreeNode insert(TreeNode root,int data){

		if(root==null){
			root = new TreeNode(data);
			return root;
		}
		else {
			TreeNode temp;
			if(data <= root.data){
				temp = insert(root.left, data);
				root.left = temp;
			}
			else{
				temp = insert(root.right,data);
				root.right = temp;
			}
			return root;
		}
	}
	
	// Print level order nodes in the tree
	public static void printLevelOrderTree(TreeNode root){
		Queue<TreeNode> tree = new LinkedList<TreeNode>();
		TreeNode cur = null;
		if(root==null){
			System.out.println("Empty Tree");
		}
		else {
			tree.add(root);
			while(!tree.isEmpty()){
				cur = tree.remove();
				System.out.print(cur.data + " ");
				if(cur.left != null)
					tree.add(cur.left);
				if(cur.right != null)
					tree.add(cur.right);
			}
		}
	}
	
	// inOrder tree traversal
	public static void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	// postOrder tree traversal
	public static void postOrder(TreeNode root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	// preOrder tree traversal
	public static void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	// Returns height of the tree
	public static int treeHeight(TreeNode root){
		int height = 0;
		if(root == null)
			return -1;
		else{
			height = 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
			return height;
		}
	}
	
	// Search an element in tree
	public static boolean searchElement(TreeNode root,int value){
		if(root == null){
			return false;
		}
		if(value == root.data){
			return true;
		}
		else{
			if(searchElement(root.left, value) == true || searchElement(root.right, value)== true)
				return true;
			else 
				return false;
		}	
	}
	
	// Delete element from tree
	public static TreeNode deleteElement(TreeNode root,int value){
	
		if(root == null)
			return root;
		if(value < root.data)
			root.left = deleteElement(root.left, value);
		else if(value > root.data)
			root.right = deleteElement(root.right, value);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			root.data = maxValue(root.left);
			
			root.left = deleteElement(root.left,root.data);
		}
		 return root;	
	}
	
	// find predecessor of node
	public static int maxValue(TreeNode node){
		int max = node.data;
		while(node.right != null){
			max = node.right.data;
			node = node.right;
		}
		return max;
	}
	
	
	public static void main(String arg[]){
		
		TreeNode root = null;
		root = insert(root, 5);
		root = insert(root, 2);
		root = insert(root, 7);
		root = insert(root, 1);
		root = insert(root, 6);
		root = insert(root, 3);
		root = insert(root, 8);
		
		printLevelOrderTree(root);
		System.out.println("");
		inOrder(root);
		System.out.println("");
		postOrder(root);
		System.out.println("");
		preOrder(root);
		
		System.out.println("");
		root = deleteElement(root, 5);
		inOrder(root);
		
	}
}
