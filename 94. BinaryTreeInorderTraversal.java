class Solution {
    // 1. recurision
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
    // 2. iteration
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}