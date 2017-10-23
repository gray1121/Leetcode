// recursive
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) { return null; }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
    }
}
// iterative 
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = null;
        while (root != null) {

            if (root.val > p.val) {
                node = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return node;
    }
}