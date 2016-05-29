package datastructure;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(){
		data = 0;
		next = null;
	}
	
	Node(int node){
		this.data = node;
		this.next = null;
	}
	
	public void insert(Node prevnode,Node newnode){
		Node temp = new Node();
		
		if(newnode == null)
			return;
		else {
			if(prevnode.next == null){
				prevnode.next = newnode;
			}
			else {
				temp.next = prevnode.next;
				prevnode.next = newnode;
				newnode.next = temp.next;
			}
		}
	}
}

public class LinkList {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node node = new Node(n);
		int nextn = in.nextInt();
		Node nextnode = new Node(nextn);
		nextnode.insert(node,nextnode);
		
		int k = in.nextInt();
		Node knode = new Node(k);
		knode.insert(node, knode);
		
		in.close();
		
	}
}

