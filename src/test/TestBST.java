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
	public final void testTreeMaxHeight() {
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nHeight of the tree :: " + tree.treeMaxHeight(root));	
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
	
	@Test
	public final void testTreeSize(){
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nSize of the tree is : " + tree.treeSize(root));
	}
	
	@Test
	public final void testMinValue(){
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nMininum value node in the tree is : " + tree.minValue(root));
	}
	
	@Test
	public final void testMaxValue(){
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nMaximum value node in the tree is : " + tree.maxValue(root));
	}
	
	@Test
	public final void testHasPathSum(){
		int[] nodes = {3,5,2,1,4,6,7};
		int sum = 10;
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		} 
		if(tree.hasPathSum(root,sum))
			System.out.println("\nTree has path of " + sum);
		else 
			System.out.println("\nTree does not has path of " + sum);
	}
	
	@Test
	public final void testPrintPaths(){
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		System.out.println("\nTree Paths :: ");
		tree.printPaths(root);
	}
	
	@Test
	public final void testMirror(){
		int[] nodes = {3,5,2,1,4,6,7};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		tree.mirror(root);
		System.out.println("\nMirror Tree :: level order ");
		tree.printLevelOrderTree(root, size);
	}
	
	@Test
	public final void testDoubleTree(){
		int[] nodes = {3,5,2,1};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		tree.doubleTree(root);
		System.out.println("\nDouble Tree :: level order ");
		tree.printLevelOrderTree(root, 2*size);
	}
	
	@Test
	public final void testSameTree(){
		int[] nodesA = {3,5,2,1};
		int sizeA = nodesA.length;
		TreeNode rootA = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<sizeA;i++){
			rootA = tree.insert(rootA,nodesA[i]);
		}
		int[] nodesB = {3,5,2,1};
		int sizeB = nodesB.length;
		TreeNode rootB = null;
		for(int i=0;i<sizeB;i++){
			rootB = tree.insert(rootB,nodesB[i]);
		}
		if(tree.isTreeSame(rootA, rootB))
			System.out.println("\nTrees are same");
		else
			System.out.println("\nTrees are not same");
	}
	
	@Test
	public final void testCountTree(){
		BinarySearchTree tree = new BinarySearchTree();
		int numNodes = 4;
		System.out.print("\nNumber of trees from " + numNodes + " nodes :: ");
		System.out.println(tree.countTrees(numNodes));
	}
	
	@Test
	public final void testIsBST(){
		int[] nodes = {3,5,2,1};
		int size = nodes.length;
		TreeNode root = null;
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0;i<size;i++){
			root = tree.insert(root,nodes[i]);
		}
		if(tree.isBST(root))
			System.out.println("\nTree is a BST");
		else
			System.out.println("\nTree is not a BST");
	}
}
