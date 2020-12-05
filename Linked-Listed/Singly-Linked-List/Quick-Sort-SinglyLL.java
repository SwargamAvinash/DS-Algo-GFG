/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function


/* // TODO If you are thinking to swap nodes instead of values Then just just keep 
    values which are which are greater than pivot(tail) after the tail..!! Very easy..
  */


class GfG
{
    public static void swap(Node n1, Node n2) {
        int temp = n2.data;
        n2.data = n1.data;
        n1.data = temp;
    }
    
    public static Node partition(Node head, Node tail) {
        // Need to select a pivot and make the linked list two 
        // partition one which contains less and other more ..
        
        Node prev = null;
        Node i = head;
        Node j = head;
        Node pivot = tail;
        
        while (j!=tail) {
            if (pivot.data >= j.data) {
                swap(i, j);
                prev = i;
                i = i.next;
            }
            j = j.next;
        }
        
        swap(i, pivot);
        
        return prev;
    }

	// Need to always dry run .. when writing a partition Algoritm like Quick sort or 
	// Merge Sort.. for the Increasing case and also check or dry run for the decreasing case.
    public static void quickSort(Node head, Node tail) {
        
        if (head != tail && head!=null && tail!=null) {
            // This Function should return Node which is selected and 
            // in it correct position.
            Node pivot_prev = partition(head, tail);
            // System.out.println("After partition :");
            // printLL(head, tail);
            
            if (pivot_prev == null) {
                quickSort(head.next, tail);
            } else {
                quickSort(head, pivot_prev);
                if (pivot_prev.next != tail && pivot_prev.next.next != tail){
                    quickSort(pivot_prev.next.next, tail);
                }
            }
        }
        return;
    }
    
    public static void printLL(Node head, Node tail) {
        Node temp = head;
        while (temp != tail.next) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("");
    }
    
    public static Node quickSort(Node node)
    {
        Node temp1 = node;
        while (temp1.next!=null) {
            temp1 = temp1.next;
        }
        Node tail = temp1;
        
        
        quickSort(node, tail);
        return node;
    }
    
    
}