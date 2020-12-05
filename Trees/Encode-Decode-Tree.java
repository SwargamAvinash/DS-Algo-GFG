/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Just create an Preorder String with NULL and Split and 
// Use that Null and Split to genrate Tree.

// Or you could have just used an array to Represent it and 
// Use that array to decode it too..
public class Codec {
    private static final String SPLIT = ",";
    private static final String NULL = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public void serializeUtil(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLIT);
            return;
        }
        
        sb.append(root.val).append(SPLIT);
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLIT)));
        
        return deserializeUtil(nodes);
    }
    
    public TreeNode deserializeUtil(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL)) return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeUtil(nodes);
        node.right = deserializeUtil(nodes);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));