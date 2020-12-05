/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

// Iterative.
public static int getCount(Node head)
{
	int l = 0;
	Node temp = head;
	while (temp != null) {
		temp = temp.next;
		l++;
	}
	return l;
}

// Recursive 
public static int getCount(Node head)
{
	if (head == null) return 0;
	
	return 1 + getCount(head.next);
}
