package datastructure;
/**
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java
 */
import java.util.*;
import java.util.NoSuchElementException;

public class LinkListIterable<T> implements Iterable<T> {
	
	Node<T> head;
	
	public LinkListIterable(){
		head = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void addFirst(T node){
		head = new Node<T>(node,head);
	}
	
	public T getFirst(){
		if(head == null)
			throw new NoSuchElementException();
		return head.data;
	}
	
	public T removeFirst(){
		T temp = getFirst();
		head = head.next;
		return temp;
	}
	
	public void addLast(T node){
		if(head == null)
			addFirst(node);
		else{
			Node<T> temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new Node<T>(node);
		}
	}
	
	public T getLast(){
		if(head == null)
		 throw new NoSuchElementException();
		Node<T> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp.data;
	}
	
	public void clear(){
		head = null;
	}
	
	public boolean contains(T node){
		for(T temp : this){
			if(temp.equals(node))
				return true;
		}
		return false;
	}
	
	public T getAt(int pos){
		if(head == null)
			throw new NoSuchElementException();
		Node<T> temp = head;
		for(int i=0;i<pos;i++){
			temp = temp.next;
		}
		if(temp == null)
			throw new IndexOutOfBoundsException();
		return temp.data;
	}
	
	public void insertAfter(T key,T toInsert){
		Node<T> temp = head;
		while(temp != null && !temp.data.equals(key)){
			temp = temp.next;
		}
		if(temp != null){
			temp.next = new Node<T>(toInsert,temp.next);
		}
	}
	
	public void insertBefore(T key, T toBefore){
		if(head == null){
			head = new Node<T>(toBefore);
			return;
		}
		if(head.data.equals(key)){
			addFirst(toBefore);
			return;
		}
		Node<T> curr = head;
		Node<T> prev = null;
		
		while(curr != null && !curr.data.equals(key)){
			prev = curr;
			curr = curr.next;
		}
		if(curr != null){
			prev.next = new Node<T>(toBefore,curr);
		}
	}
	
	public void remove(T key){
		if(head == null){
			throw new RuntimeException("No element present !");
		}
		if(head.data.equals(key)){
			head = head.next;
			return;
		}
		Node<T> curr = head;
		Node<T> prev =  null;
		
		while(curr != null && !curr.data.equals(key)){
			prev = curr;
			curr = curr.next;
		}
		if(curr == null)
			throw new RuntimeException("Can not delete.");
		prev.next = curr.next;  
 	}
	
	public Iterator<T> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>{
		private Node<T> nextNode;
		
		public LinkedListIterator(){
			nextNode = head;
		}
		
		public boolean hasNext(){
			return nextNode != null;
		}
		
		public T next(){
			if(!hasNext())
				throw new NoSuchElementException();
			T res = nextNode.data;
			nextNode = nextNode.next;
			return res;
		}
		 public void remove(){
			 throw new UnsupportedOperationException();
		 }
		
	}
	
}
