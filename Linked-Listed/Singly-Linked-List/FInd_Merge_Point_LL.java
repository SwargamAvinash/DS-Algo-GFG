/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */


// Using the Cycle finding detection in a graph alogirthm .
// just join the listA head to tail and Run Cycle detection Algoithm on the ListB will be 
// Able to find the link.

// Now this node both pointers point to has an additional property, 
//the distance from this node to the beginning of the cycle 
// (and therefore the merging node of the list) is equal to the distance the beginning of the list 
//has to the beginning of the cycle
class Intersect
{
    void printLL(Node head) {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " -->");
            temp = temp.next;
        }
        System.out.println("");
    }
    
	int intersectPoint(Node headA, Node headB)
	{
         Node tailA = headA;
         while (tailA.next!=null) {
             tailA = tailA.next;
         }
         
         tailA.next = headB; //Creating a Loop
         Node temp1 = headA;
         Node temp2 = headA;
         
         while (temp1!=null && temp2!=null && temp2.next!=null) {
             temp1 = temp1.next;
             temp2 = temp2.next.next;
             if (temp1 == temp2) break;
         }
         
         temp2 = headA;
         
         while(temp1!=temp2) {
             temp1 = temp1.next;
             temp2 = temp2.next;
         }
         
         return temp1.data;
	}
}
