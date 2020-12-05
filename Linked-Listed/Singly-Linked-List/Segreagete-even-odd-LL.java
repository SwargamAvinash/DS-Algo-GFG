import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node next;
    
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class SinglyLinkedList {
    public Node head;
    public Node tail;
    
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public void addAtEnd(int data) {
        if (head == null) {
            this.head = new Node(data, null);
            this.tail = this.head;
            return;
        }
        
        Node temp = this.head;
        tail.next = new Node(data, null);
        this.tail = tail.next;
    }
    
    public void printLL() {
        for (Node temp = this.head ; temp!=null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println("");
    }
    
    public void segregate() {
        Node temp1 = this.head;
        Node temp2 = this.tail;
        
        while (temp1.data % 2 != 0) {
            temp2.next = temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp2.next = null;
        }
        
        this.head = temp1;
        
        while (temp1.next != this.tail && temp1 != this.tail) {
            if (temp1.next.data % 2 != 0) {
                // System.out.println("Odd encounter :" + temp1.next.data);
                Node temp3 = temp1.next;
                temp1.next = temp3.next;
                temp2.next = temp3;
                temp3.next = null;
                temp2 = temp2.next;
            } else {
                temp1 = temp1.next;
            }
            // printLL();
        }
        
        if (this.tail.data % 2 != 0 && this.tail != temp2) {
            Node temp3 = temp1.next;
            temp1.next = temp3.next;
            temp2.next = temp3;
            temp3.next = null;
            temp2 = temp2.next;
        }
        
        this.tail = temp2;
    }
}


class GFG
 {
     
     private static Scanner in = new Scanner(System.in);
    public static void main (String[] args)
    {
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            SinglyLinkedList list = new SinglyLinkedList();
            for (int i=0;i<n;i++) {
                list.addAtEnd(in.nextInt());
            }
            // list.printLL();
            list.segregate();
            list.printLL();
            t--;
        }
    }
}