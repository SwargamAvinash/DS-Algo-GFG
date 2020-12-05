
// Always try to dry run the code while you ar writing or after you write..
class GfG
{
    // head: head node
    Node removeDuplicates(Node root)
    {
        Node temp1 = root;
        while (temp1 != null && temp1.next !=null) {
            if (temp1.data == temp1.next.data) {
                Node temp2 = temp1.next;
                temp1.next = temp2.next;
                temp2 = null;
            }else {
                temp1 = temp1.next;
            }
        }
        
        return root;
    }
}