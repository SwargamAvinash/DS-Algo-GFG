/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
    public static Node insert(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }
        
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        
        return head;
    }
    
    
   public static Node findIntersection(Node head1, Node head2)
    {
        Node temp1 = head1;
        Node temp2 = head2;
        Node headAns = null;
        
        while (temp1!=null && temp2!=null) {
            if (temp1.data > temp2.data) {
                temp2 = temp2.next;
            } else if (temp1.data < temp2.data) {
                temp1 = temp1.next;
            } else {
                headAns = insert(headAns, temp1.data);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return headAns;
    }
}