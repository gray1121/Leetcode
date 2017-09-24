// naive recursive inorder traverse
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> bst = new ArrayList<Integer>();
        inorder(root, bst);
        return bst.get(k - 1);
    }
    private void inorder(TreeNode root, List<Integer> bst) {
        if (root == null)
            return;
        inorder(root.left, bst);
        bst.add(root.val);
        inorder(root.right, bst);
    }
}
// better recursive
class Solution {
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) 
            return -1;
        int i = kthSmallest(root.left, k);
        count++;
        if (k == count) 
            return root.val;
        if (i == -1) {
            i = kthSmallest(root.right, k);
        } 
        else 
            return i;
        return i;
    }
}
// iterate solution, best one 
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.empty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0)  return root.val;
            root = root.right;
        }
        return -1;
    }
}