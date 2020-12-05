/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/


class Solution {
    public void swapData(Node temp1, Node temp2) {
        int data = temp1.data;
        temp1.data = temp2.data;
        temp2.data = data;
    }
    
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        Node temp1 = head;
        Node temp2 = head.next;
        
        while (temp1!=null && temp2!=null) {
            swapData(temp1, temp2);
            if (temp2.next==null || temp2.next.next==null) {
                break;
            }
            temp1 = temp2.next;
            temp2 = temp2.next.next;
        }
        
        return head;
    }
}