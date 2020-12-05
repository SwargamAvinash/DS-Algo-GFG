/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class GfG
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
        Node temp = head;
        
        if (x == 1) {
            head = temp.next;
            head.prev = null;
            temp = null;
            return head;
        }
        
        while (x > 1) {
            temp = temp.next;
            x--;
        }
        
        Node prev = temp.prev;
        prev.next = temp.next;
        if (temp.next != null) temp.next.prev = prev;
        temp = null;
        
        return head;
    }
}