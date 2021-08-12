package medium;

import java.util.*;

public class LRUCache {
	class Node {
		int key;
		int value;
		Node next;
		Node prev;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = this.prev = null;
		}
	}
	
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	private int cap = 0;
	private HashMap<Integer, Node> map = null;
	
	private void removeNode(Node node) {
		if(this.size == 1) {
			this.head = this.tail = null;
		} else if(node == head) {
			head = head.next;
			head.prev = null;
		} else if(node == tail) {
			tail = tail.prev;
			tail.next = null;
		} else {
			Node nm1 = node.prev;
			Node np1 = node.next;
			
			nm1.next = np1;
			np1.prev = nm1;
		}
		this.size--;
	}
	
	private void addLast(Node node) {
		if(this.size == 0) {
			head = tail = node;
			this.size = 1;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
			this.size++;
		}
	}
	
	private int removeFirst() {
		Node rem = head;
		head = head.next;
		head.prev = null;
		
		rem.next = null;
		this.size--;
		return rem.key;
	}
	
	public LRUCache(int capacity) {
		this.cap = capacity;
		map = new HashMap<>();
	}
	
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	int value = map.get(key).value;
        	// call put to update 
        	this.put(key, value);
        	return value;
        } else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
        	// updataion
        	Node node = map.get(key);
        	node.value = value;
        	removeNode(node);
        	addLast(node);
        } else {
        	// insertion
        	
        	// 1. add new application in recent tab
        	Node node = new Node(key, value);
        	map.put(key, node);
        	addLast(node);
        	// 2. if no of tab cross capacity then remove least used  app (removeFirst)  
        	if(this.size > cap) {
        		int remKey = removeFirst();
        		map.remove(remKey);
        	}
        }
    }
}
