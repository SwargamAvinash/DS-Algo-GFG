
// Use fast and slow pointers if they two meet then there is a cycle.
// From this only you can find the start of the cycle also.
public static boolean detectLoop(Node head){
	Node temp1 = head;
	Node temp2 = head;
	
	while (temp1 != null && temp2 != null && temp2.next != null) {
		temp1 = temp1.next;
		temp2 = temp2.next.next;
		
		if (temp1 == temp2) return true;
	}
	
	return false;
}