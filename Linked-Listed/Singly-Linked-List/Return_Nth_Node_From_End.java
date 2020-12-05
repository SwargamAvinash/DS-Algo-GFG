class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

// Use two pointers don't need to find the length.
class GfG
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
        if (head == null) return 0;
    	Node temp1 = head;
    	Node temp2 = head;
    	
    	while(n > 0 && temp1!=null) {
    	    temp1 = temp1.next;
    	    n--;
    	}
    	
    	if (n > 0) return -1;
    	
    	while(temp1 != null) {
    	    temp2 = temp2.next;
    	    temp1 = temp1.next;
    	}
    	
    	return temp2.data;
    }
}
