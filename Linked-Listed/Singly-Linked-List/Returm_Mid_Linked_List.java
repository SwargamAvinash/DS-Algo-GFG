// Use two pointers if even two mids you should return the secound one;
int getMiddle(Node head)
    {
        if(head == null) return -1; 
         Node temp1 = head;
         Node temp2 = head;
        int mid = -1;
        
        while (true) {
            if (temp2.next == null) {
                mid = temp1.data;
                break;
            }
            
            if(temp2.next.next == null) {
                mid = temp1.next.data;
                break;
            }
            
            temp2 = temp2.next.next;
            temp1 = temp1.next;
        }
        
        return mid;
    }