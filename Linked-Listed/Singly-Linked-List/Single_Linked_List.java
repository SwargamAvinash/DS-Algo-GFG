import java.util.*;


class SingleLinkedListNode {
	int data;
	SingleLinkedListNode next;

	public SingleLinkedListNode(int data, SingleLinkedListNode node) {
		this.data = data;
		this.next = node;
	}
}

class SingleLinkedList {

	public SingleLinkedListNode head;
	public SingleLinkedListNode tail;

	public SingleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addNodeEnd(int data) {
		if (head == null) {
			head = new SingleLinkedListNode(data, null);
			tail = head;
		} else {
			SingleLinkedListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new SingleLinkedList(data, null);
			tail = temp.next;
		}
	}

	public void addNodeFront(int data) {
		SingleLinkedListNode temp = new SingleLinkedListNode(data, head);
		head = temp;
	}

	public printLinkedList() {
		SingleLinkedListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
		}
	}
}

class Solution {
	private static Scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
	}
}