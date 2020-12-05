/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

// Very good Algorithm...! In a recursive way....
// When you are going left come back to the root of the left which doesn't have any left....
// And Assign the preccedor's right to root... and root left to preccedor...

// When you are traversing the right come back to the root of the right which doesn't have any right ...
// And Assging the successor left to root and root's right to successor.!!



class GfG
{
    Node createLinksForDLL(Node root) {
        if (root == null) return root;
        
        if (root.left != null) {
            Node left = createLinksForDLL(root.left);
            
            // Now Root is root of Last left which doesn't have left.
            // Find the Predeccesor...one that comes behind this root.
            
            for (; left.right != null ; left = left.right);
            
            left.right = root;
            root.left = left;
        }
        
        if (root.right != null) {
            Node right = createLinksForDLL(root.right);
            
            // Find successor ..
            for (; right.left != null; right = right.left);
            right.left = root;
            root.right = right;
        }
        
        return root;
    }
    
    
    Node bToDLL(Node root)
    {
        root = createLinksForDLL(root);
        Node head = root;
        // Just find the last left and return
        for (;head.left!=null; head = head.left);
        
        return head;
    }
}