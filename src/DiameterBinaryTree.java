/**
 * 543. Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
 * the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

/**
 * The diameter of a tree T is the largest of the following quantities:
 *
 * the diameter of T’s left subtree
 * the diameter of T’s right subtree
 * the longest path between leaves that goes through the root of T
 *   (this can be computed from the heights of the subtrees of T)
 */

public class DiameterBinaryTree {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) { return 0; }

        // Computer diamter of the subtrees
        int diameterLeft = diameterOfBinaryTree(root.left);
        int diameterRight = diameterOfBinaryTree(root.right);

        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        // System.out.println("left = " + left);
        // System.out.println("right = " + right);

        int diameter = Math.max(left + right, Math.max(diameterLeft, diameterRight));

        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) { return -1; }

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;

    }

}
