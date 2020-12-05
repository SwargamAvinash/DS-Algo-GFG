
// Use two pointers when they both are same break the loop and start counting by moving the other 
// one and when they meet again return the number.
static int countNodesinLoop(Node head)
{
	int count = 0;
	Node temp1 = head;
	Node temp2 = head;
	boolean loop = false;
	
	
	while (temp1 != null && temp2 != null && temp2.next != null) {
		temp1 = temp1.next;
		temp2 = temp2.next.next;
		
		if (temp1 == temp2) {
			loop = true;
			break;
		}
	}
	
	if (loop) {
		temp1 = temp1.next;
		count++;
		while (temp1 != temp2) {
			temp1 = temp1.next;
			count++;
		}
	}
	
	return count;
}