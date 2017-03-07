package datastructure;
// http://cslibrary.stanford.edu/110/BinaryTrees.html
import java.util.*;
import datastructure.TreeNode;

public class BinarySearchTree {
	
	int MAX_PATHS = 1000;
	
	// Insert node in the tree
	public TreeNode insert(TreeNode root,int data){

		if(root==null){
			root = new TreeNode(data);
			return root;
		}
		else {
			if(data <= root.data){
				root.left = insert(root.left, data);
			}
			else{
				root.right = insert(root.right,data);
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
	public int treeMaxHeight(TreeNode root){
		int height = 0;
		if(root == null)
			return -1;
		else{
			height = 1 + Math.max(treeMaxHeight(root.left), treeMaxHeight(root.right));
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
		if(value < root.data)
			// Parse left sub-tree
				return searchElement(root.left, value);
		else 
			// Parse right sub-tree
				return searchElement(root.right, value);
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
			
			root.data = nodePredecessor(root.left);
			
			root.left = deleteElement(root.left,root.data);
		}
		 return root;	
	}
	
	// find predecessor of node
	public int nodePredecessor(TreeNode node){
		int max = node.data;
		while(node.right != null){
			max = node.right.data;
			node = node.right;
		}
		return max;
	}
	
	// size of the tree
	public int treeSize(TreeNode node){
		if(node == null)
			return 0;
		else
			return treeSize(node.left)+1+treeSize(node.right);
	}
	
	// min value in BST
	public int minValue(TreeNode node){
		if(node == null)
			return -1;
		else{
			while(node.left != null){
				node = node.left;
			}
		}
		return node.data;
	}
	
	// max value in BST
	public int maxValue(TreeNode node){
		if(node == null)
			return -1;
		else{
			while(node.right != null){
				node = node.right;
			}
		return node.data;	
		}
	}
	
	// has path as sum
	public boolean hasPathSum(TreeNode node,int sum){
		if(node == null){
			return(sum == 0);
		}
		else{
			return (hasPathSum(node.left,sum-node.data)||
					hasPathSum(node.right, sum-node.data));
		}
	}
	
	// print paths in tree
	public void printPaths(TreeNode node){
		int path[] = new int[MAX_PATHS];
		printPathRecur(node,path,0);
	}
	
	// print paths recursively in tree
	public void printPathRecur(TreeNode node,int[] path,int pathLen){
		if(node == null)
			return;
		else{
			path[pathLen] = node.data;
			pathLen++;
			
			if(node.left == null && node.right == null){
				printPathArray(path,pathLen);
			}
			else{
				printPathRecur(node.left, path, pathLen);
				printPathRecur(node.right, path, pathLen);
			}
		}
	}
	
	// print paths in tree
	public void printPathArray(int[] paths,int pathLen){
		for(int i=0;i<pathLen;i++){
			System.out.print(paths[i] + " ");
		}
		System.out.println();
	}

	// print mirror image of tree
	public void mirror(TreeNode node){
		if(node == null)
			return ;
		else{
			TreeNode temp = null;
			temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			mirror(node.right);
			mirror(node.left);
		}
	}
	
	// double tree
	public void doubleTree(TreeNode node){
	
	  if(node == null)
		  return;
	  else{
		  TreeNode newNode = new TreeNode(node.data);
		  TreeNode oldLeft = null;
		  
		  doubleTree(node.left);
		  doubleTree(node.right);
		  
		  oldLeft = node.left;
		  node.left = newNode;
		  newNode.left = oldLeft;  
	  }
	}
	
	// same tree
	public boolean isTreeSame(TreeNode nodeA,TreeNode nodeB){
		if(nodeA == null && nodeB == null)
			return true;
		else if (nodeA != null && nodeB != null){
			return ((nodeA.data == nodeB.data) && 
					isTreeSame(nodeA.left,nodeB.left) && 
					isTreeSame(nodeA.right, nodeB.right));
		}
		else
			return false;
		}
	
	// count number of trees with given nodes
	public int countTrees(int numNodes){
		int sum = 0;
		if(numNodes <= 1)
			return 1;
		else{
			int left,right,root;
			for(root=1;root<= numNodes;root++){
				left = countTrees(root-1);
				right = countTrees(numNodes - root);
				sum = sum + left*right;
			}
		return sum;	
		}
	}
	
	// checks tree is BST or not
	public boolean isBST(TreeNode node){
		int INT_MIN = minValue(node);
		int INT_MAX = maxValue(node);
		return(isBSTUtil(node,INT_MIN,INT_MAX));
	}
	
	public boolean isBSTUtil(TreeNode node,int min,int max){
		if(node == null)
			return true;
		if(node.data < min || node.data > max)
			return false;
		return(isBSTUtil(node.left, min, node.data) && 
			   isBSTUtil(node.right, node.data + 1, max));
	}
	
	
}

