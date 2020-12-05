/* Linked List Node class
   class Node  {
     int data;
     Node next;
     Node(int data)
     {
         this.data = data;
         next = null;
     }
  }
*/
class GFG
{
    // Should swap Kth node from beginning and 
    // Kth node from end in list and return new head.
    Node swapkthnode(Node head, int num, int k)
    {
        if (k > num) return head;
        
        Node k_prev = head;
        Node n_k_prev = head;
        if (k == 1 || k == num) {
            // head to swap with tail
            Node prev = null;
            while (n_k_prev.next!=null) {
                prev = n_k_prev;
                n_k_prev = n_k_prev.next;
            }
            
            prev.next = head;
            n_k_prev.next = head.next;
            head.next = null;
            return n_k_prev;
        }
        int temp = k;
        
        while (temp > 2) {
            k_prev = k_prev.next;
            temp--;
        }
        
        temp = num - k + 1;
        while (temp > 2){
            n_k_prev = n_k_prev.next;
            temp--;
        }
        
        Node temp1 = k_prev.next;
        Node temp2 = n_k_prev.next;
        
        k_prev.next = temp2;
        n_k_prev.next = temp1;
        
        Node temp3 = temp1.next;
        temp1.next = temp2.next;
        temp2.next = temp3;
        
        return head;
    }
}