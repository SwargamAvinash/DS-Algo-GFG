/*class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/

class GfG
{
void addNode(Node head_ref, int pos, int data)
	{
		Node temp = head_ref;
		
		while (pos > 0) {
		    temp = temp.next;
		    pos--;
		}
		
		Node temp2 = new Node(data);
		
		Node temp1 = temp.next;
		temp.next = temp2;
		temp2.next = temp1;
		temp2.prev = temp;
		if (temp1 != null) temp1.prev = temp2;
		
	}
}