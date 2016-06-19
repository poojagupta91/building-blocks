package datastructure;

import java.util.*;
import datastructure.TreeNode;

public class BinarySearchTree {
	
	// Insert node in the tree
	public TreeNode insert(TreeNode root,int data){

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
	public int[] printLevelOrderTree(TreeNode root,int size){
		Queue<TreeNode> tree = new LinkedList<TreeNode>();
		TreeNode cur = null;
		int[] nodes = new int[size];
		int i=0;
		if(root==null){
			System.out.println("Empty Tree");
		}
		else {
			tree.add(root);
			while(!tree.isEmpty()){
				cur = tree.remove();
				System.out.print(cur.data + " ");
				nodes[i] = cur.data;
				i++;
				if(cur.left != null)
					tree.add(cur.left);
				if(cur.right != null)
					tree.add(cur.right);
			}
		}
		return nodes;
	}
	
	// inOrder tree traversal
	public void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	// postOrder tree traversal
	public void postOrder(TreeNode root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	// preOrder tree traversal
	public void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	// Returns height of the tree
	public int treeHeight(TreeNode root){
		int height = 0;
		if(root == null)
			return -1;
		else{
			height = 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
			return height;
		}
	}
	
	// Search an element in tree
	public boolean searchElement(TreeNode root,int value){
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
	public TreeNode deleteElement(TreeNode root,int value){
	
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
	public int maxValue(TreeNode node){
		int max = node.data;
		while(node.right != null){
			max = node.right.data;
			node = node.right;
		}
		return max;
	}
}
