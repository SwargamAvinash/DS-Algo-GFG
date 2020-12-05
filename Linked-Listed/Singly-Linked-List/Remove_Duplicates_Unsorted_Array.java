/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }s
}
*/

class GfG
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         Map<Integer,Integer> hashmap = new HashMap<>();
         Node temp1 = head;
         
         while (temp1 != null && temp1.next != null) {
             hashmap.put(temp1.data, 1);
             if (hashmap.containsKey(temp1.next.data)) {
                 Node temp2 = temp1.next;
                 temp1.next = temp2.next;
                 temp2 = null;
             }else {
                 temp1 = temp1.next;
             }
         }
         
         return head;
    }
}
