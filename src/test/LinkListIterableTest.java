package test;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.LinkListIterable;

public class LinkListIterableTest {

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
	public final void testIterator() {
		LinkListIterable<String> list = new LinkListIterable<String>();
		list.addFirst("p");
		list.addFirst("a");
	    list.addFirst("g");
	    list.addFirst("e");
	    list.addLast("s");
	    
	    Iterator<String> itr = list.iterator();
	    System.out.print(itr.next()+ " ");
	    System.out.println();
	    
	    for(Object item : list){
	    	System.out.print(item + " ");
	    }
	    System.out.println();
	    
	    list.insertAfter("e","eee");
	    list.insertBefore("g","hh");
	    list.remove("p");
	    for(Object item : list){
	    	System.out.print(item + " ");
	    }
	}

}
