class GfG
{
    Node deleteNode(Node head, int x)
    {
        if (head == null) return head;
        int count = 1;
        Node deleteNode;
        if (count == x) {
            deleteNode = head;
            head = head.next;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (count == x - 1) {
                    deleteNode = temp.next;
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
                count++;
            }
        }
        deleteNode = null;
        return head;
    }
}
