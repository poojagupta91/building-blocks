package datastructure;
/**
 * Node class for link list node
 * @author POOJA
 * @implements Generics 
 */
public class Node<T> {
	
	T data;
	Node<T> next;
	
	Node(){
		data = null;
		next = null;
	}
	Node(T node){
		this.data = node;
		this.next = null;
	}
}
