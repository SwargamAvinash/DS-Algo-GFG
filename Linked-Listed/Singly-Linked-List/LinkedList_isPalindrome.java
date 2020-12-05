/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

// without extra space and O(N) -> Need to reverse half of the LinkedList

class Palindrome
{
    Node reverseLL(Node head, Node temp) {
        Node curr = head;
        Node prev = null;
        while (curr != temp) {
            Node temp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp1;
        }
        
        return prev;
    }
    
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        Node temp1 = head;
        Node temp2 = head;
        String evenOrOdd = "even";
        boolean palindrome = true;
        
        while (temp1 != null && temp2!=null) {
            if (temp2.next == null) {
                evenOrOdd = "odd";
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        
        Node revHalfList = reverseLL(head, temp1);
        
        if (evenOrOdd == "odd") {
            temp1 = temp1.next;
        }
        
        while(revHalfList!=null && temp1!=null) {
            if (revHalfList.data != temp1.data) {
                palindrome = false;
                break;
            }
            revHalfList = revHalfList.next;
            temp1 = temp1.next;
        }
        
        
        return palindrome;
    }    
}