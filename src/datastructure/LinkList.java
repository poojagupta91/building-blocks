package datastructure;

import java.util.Scanner;

class Node {
	int data;
	Node next;
	
	Node(int node){
		this.data = node;
		this.next = null;
	}
}

public class LinkList {
	
	// Insert node at the tail of the list.
	public static Node insert(int data,Node head){
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
	public static Node insert(int data,int pos,Node head){
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
	public static void delete(Node head){
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
	public static void delete(Node head,int pos){
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
	public static void printList(Node head){
		Node ptr = null;
		
		if(head == null){
			System.out.println("Link List Empty");
		}
		else {
			ptr = head;
			while(ptr != null){
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
		}
	}	
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		Node head = null;
		
		int choice = 0;

			while(choice != 6){
				int n,m,ele,pos;
				
				
				System.out.println("\nEnter the required input \n" + 
									"1. Add node(s) in the link list. \n" +
									"2. Add node at x position in the link list. \n" +
									"3. Delete node(s) from link list.\n" +
									"4. Delete node from x position in link list.\n" +
									"5. Print link list\n" +
									"6. Exit.");
				choice = in.nextInt();
				switch(choice){
				
				case 1 : System.out.println("Enter number of node(s)and node(s): ");
						 n = in.nextInt();
						while(n-->0){
							ele = in.nextInt();
							head = insert(ele, head);
						}
						break;
						
				case 2 : System.out.println("Enter the position and node : ");
						  pos = in.nextInt();
						  ele = in.nextInt();
						  head = insert(ele, pos, head);
						  break;
						  
				case 3 : System.out.println("Enter number of node(s) to be deleted: ");
						  m = in.nextInt();
						 while(m-->0){
							 delete(head);
						 }
						 break;
				
				case 4 : System.out.println("Enter the position of the node");
						 pos = in.nextInt();
						 delete(head,pos);
						 break;
				case 5 : printList(head);
						 break;
						 
				case 6 : break;
				
				default : System.out.println("Incorrect input");		 
				}		
			}
		in.close();
		
	}
	
}

