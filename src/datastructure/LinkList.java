package datastructure;

import datastructure.Node;

public class LinkList{
	
	// Insert node at the tail of the list.
	public Node insert(int data,Node head){
		Node node = new Node(data);
		Node ptr = null;
		
		if(head == null){
			head = node;
			return head;
		}
		else {
			ptr = head;
			while(ptr.next != null){
				ptr = ptr.next;
			}
			ptr.next = node;
		}
		return head;
	}
	
	// Insert node at defined position
	public Node insert(int data,int pos,Node head){
		Node node = new Node(data);
		Node ptr,temp = null;		
		
		if(head == null){
			head = node;
			return head;
		}
		else {
			ptr = head;
			for(int i=0;i<pos-1;i++){
				ptr = ptr.next;
			}
			temp = ptr.next;
			ptr.next = node;
			node.next = temp;
		}
		return head;
	}
	
	// Delete node from the tail of the list.
	public void delete(Node head){
		Node ptr = null;
		Node prev = null;
		
		if(head == null){
			System.out.println("Link List Empty");
		}
		else {
			ptr = head;
			while(ptr.next != null){
				prev = ptr;
				ptr = ptr.next;
			}
			prev.next = null;
		}
	}
	
	// Delete node from a position
	public void delete(Node head,int pos){
		Node ptr = null;
		Node prev = null;
		if(head == null){
			System.out.println("Empty link list");
		}
		else{
			ptr = head;
			for(int i=0;i<pos-1;i++){
				prev = ptr;
				ptr = ptr.next;
			}
			prev.next = ptr.next;
		}
	}
	
	// Print the nodes in the list.
	public int[] printList(Node head,int size){
		Node ptr = null;
		int nodes[] = new int[size];
		if(head == null){
			System.out.println("Link List Empty");
		}
		else {
			ptr = head;
			int i=0;
			while(ptr != null){
				System.out.print(ptr.data + " ");
				nodes[i]=ptr.data;
				ptr = ptr.next;
				i++;
			}
		}
		return nodes;
	}	
}

