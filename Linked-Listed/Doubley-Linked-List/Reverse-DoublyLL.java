/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    Node curr = head;
    Node prev = null;
    
    
    while (curr != null) {
        Node temp = curr.next;
        curr.next = prev;
        curr.prev = temp;
        
        prev = curr;
        curr = temp;
    }
    
    return prev;
}