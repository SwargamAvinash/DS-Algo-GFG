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
}
*/
class GfG
{
   
    public static int getNth(Node node, int ind)
    {
       //Your code here
       Node temp = node;
       
       int i = 1;
       int ans = 0;
       while (temp != null) {
           if(i == ind) {
               ans = temp.data;
               break;
           }
              
           temp = temp.next;
           i++;
       }
       return ans;
    }
}