/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        
        if (key <= head1.data || head1 == null) {
            Node temp = new Node(key);
            temp.next = head1;
            return temp;
        }
        
        Node temp = head1;
        while (temp.next!=null && temp.next.data < key) {
            temp = temp.next;
        }
        
        Node temp1 = new Node(key);
        temp1.next = temp.next;
        temp.next = temp1;
    
        return head1;
    }
}