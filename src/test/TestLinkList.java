/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.*;

/**
 * @author POOJA
 *
 */
public class TestLinkList {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link datastructure.LinkList#insert(int, datastructure.Node)}.
	 */
	@Test
	public final void testInsertIntNode() {
		int[] listNodes = {1,2,3,4};
		int size = listNodes.length;
		Node head = null;
		LinkList list = new LinkList();
		int i = 0;
		while(size-->0){
			head = list.insert(listNodes[i], head);
			i++;
		}
		assertArrayEquals("testInsertIntNode ",listNodes,list.printList(head,listNodes.length));	
	}

	/**
	 * Test method for {@link datastructure.LinkList#insert(int, int, datastructure.Node)}.
	 */
	@Test
	public final void testInsertIntIntNode() {
		int[] listNodes = {1,2,3,4};
		int size = listNodes.length;
		Node head = null;
		LinkList list = new LinkList();
		int i = 0;
		int pos = 2;
		int ele = 5;
		while(size-->0){
			head = list.insert(listNodes[i], head);
			i++;
		}
		head = list.insert(ele, pos, head);
		int[] listNewNodes = {1,2,5,3,4};
		assertArrayEquals("testInsertIntIntNode ",listNewNodes,list.printList(head, 5));
	}

	/**
	 * Test method for {@link datastructure.LinkList#delete(datastructure.Node)}.
	 */
	@Test
	public final void testDeleteNode() {
		int[] listNodes = {1,2,3,4};
		int size = listNodes.length;
		Node head = null;
		LinkList list = new LinkList();
		int i = 0;
		int numOfNodesDel = 3;
		while(size-->0){
			head = list.insert(listNodes[i], head);
			i++;
		}
		while(numOfNodesDel-->0){
			 list.delete(head);
		}
		int[] listNewNodes = {1};
		assertArrayEquals("testDeleteNode",listNewNodes,list.printList(head,(listNodes.length-3)));
	}

	/**
	 * Test method for {@link datastructure.LinkList#delete(datastructure.Node,int)}.
	 */
	@Test
	public final void testDeleteNodeInt() {
		int[] listNodes = {1,2,3,4};
		int size = listNodes.length;
		Node head = null;
		LinkList list = new LinkList();
		int i = 0;
		int pos = 3;
		while(size-->0){
			head = list.insert(listNodes[i], head);
			i++;
		}
		list.delete(head, pos);
		int[] listNewNodes = {1,2,4};
		assertArrayEquals("testDeleteNodeInt",listNewNodes,list.printList(head,(listNodes.length-1)));
	}
}
