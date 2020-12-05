//function Template for Java

/* linked list node class:

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class ReverseLL
{
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverseList(Node head)
    {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp1;
        }
        
        return prev;
    }
}
