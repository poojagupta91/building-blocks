package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.BinarySearchTree;
import datastructure.TreeNode;

public class TestBST {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testInsert() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		int[] levelOrder = {3,2,5,1,4,6,7};
		System.out.println("\nInsert Node In Tree ::");
		assertArrayEquals("testInsert",levelOrder,tree.printLevelOrderTree(root,size));
	}

	@Test
	public final void testPrintLevelOrderTree() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		int[] levelOrder = {3,2,5,1,4,6,7};
		System.out.println("\nLevel Order Tree :: ");
		assertArrayEquals("testInsert",levelOrder,tree.printLevelOrderTree(root,size));
	}

	@Test
	public final void testInOrder() {
	int[] nodes = {3,5,2,1,4,6,7};
	int size = nodes.length;
	TreeNode root = null;
	BinarySearchTree tree = new BinarySearchTree();
	for(int i=0;i<size;i++){
		root = tree.insert(root,nodes[i]);
	}
	System.out.println("\nIn-Order Tree :: ");
	tree.inOrder(root);
	}

	@Test
	public final void testPostOrder() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nPost-Order Tree :: ");
		tree.postOrder(root);	
	}

	@Test
	public final void testPreOrder() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nPre-Order Tree :: ");
		tree.preOrder(root);	
	}

	@Test
	public final void testTreeHeight() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.print("\nHeight of the tree :: " + tree.treeHeight(root));	
	}

	@Test
	public final void testSearchElement() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		int value = 4;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		if(tree.searchElement(root, value))
			System.out.println("\n" + value + " present in the tree !");
		else
			System.out.println("\n" + value + " not present in the tree !");
	}

	@Test
	public final void testDeleteElement() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		int value = 3;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nDelete " + value +" :: ");
		root = tree.deleteElement(root, value);
		tree.printLevelOrderTree(root, size-1);	
	}
}
