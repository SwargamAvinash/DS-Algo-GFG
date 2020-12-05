/*
class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}*/
// function to copy linked list
class Clone {
    
    void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            int arb_data = 0;
            if (temp.arb != null) arb_data = temp.arb.data;
            System.out.println("Data : " + temp.data + ",Arb : " + arb_data);
            temp = temp.next;
        }
        System.out.println("");
    }
    
    Node copyList(Node head) {
        Node head_new = new Node(head.data);
        
        Node temp1 = head;
        Node temp2 = head_new;
        Node prev = null;
        
        while (temp1 != null) {
            if (temp2 == null) {
                temp2 = new Node(temp1.data);
                prev.next = temp2;
            }
            
            temp2.arb = temp1.arb;
            temp1.arb = temp2;
            prev = temp2;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        temp1 = head;
        temp2 = head_new;
        while (temp2 != null && temp1 != null) {
            Node temp = null;
            if (temp2.arb != null) {
                temp = temp2.arb.arb;
            }
            temp1.arb = temp2.arb;
            temp2.arb = temp;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        printLL(head);
        System.out.println("Copy List\n");
        printLL(head_new);
        
        return head_new;
    }
}