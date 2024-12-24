// Time Complexity:  O(n) for average number of nodes
// space Complexity:  O(1) as no stack is used
//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class ValidBSTUsingMorisInorder {
    public boolean isValidBST(TreeNode root) {
        TreeNode current = root, predecessor = null;
        Integer prevValue = null; // to store previous node value

        while (current != null) {
            if (current.left == null) {
                // process the current node
                if (prevValue != null && current.val <= prevValue) {
                    return false;
                }
                    prevValue = current.val;
                    current = current.right; // move to right child
                } else {
                    // find in -order predecessor of current node
                    predecessor = current.left;
                    while (predecessor.right != null && predecessor.right != current) {
                        predecessor = predecessor.right;
                    }
                    if (predecessor.right == null) {
                        // create a temp thread to current node
                        predecessor.right = current;
                        current = current.left;
                    } else {
                        // restore the tree, break the head and process the current node
                        predecessor.right = null;
                        if (prevValue != null && current.val <= prevValue) {
                            return false;
                        }
                        prevValue = current.val;
                        current = current.right;
                    }
                }
            }
            return true; // tree is valid BST
        }

        public static void main(String[] args) {
            ValidBSTUsingMorisInorder solution = new ValidBSTUsingMorisInorder();

            // Example 1: Valid BST
            TreeNode root1 = new TreeNode(2);
            root1.left = new TreeNode(1);
            root1.right = new TreeNode(3);
            System.out.println("Example 1: " + solution.isValidBST(root1)); // Output: true

            // Example 2: Invalid BST
            TreeNode root2 = new TreeNode(5);
            root2.left = new TreeNode(1);
            root2.right = new TreeNode(4);
            root2.right.left = new TreeNode(3);
            root2.right.right = new TreeNode(6);
            System.out.println("Example 2: " + solution.isValidBST(root2)); // Output: false
        }
    }

