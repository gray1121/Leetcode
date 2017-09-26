class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            // reserve the size, q.size() is mutable
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
                list.add(temp.val);
            }
            res.add(new LinkedList<Integer>(list));
        }
        return res;
    }
}