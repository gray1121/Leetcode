// Perfect Tree
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) { return; }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
// What if the given tree could be any binary tree? Would your previous solution still work
// BFS
// O(N/2) space
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) { return; }
        List<TreeLinkNode> cur = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()) {
            int size = cur.size();
            List<TreeLinkNode> next = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeLinkNode temp = cur.get(i);
                if (temp.left != null) { next.add(temp.left); }
                if (temp.right != null) { next.add(temp.right); }
                temp.next = i == size - 1 ? null : cur.get(i + 1);
            }
            cur = next;
        }
    } 
}
//  use hashmap to store the previous node in every levels
// DFS
//  O(h) space
public class Solution {
    Map<Integer, TreeLinkNode> map = new HashMap<>();
    public void connect(TreeLinkNode root) {
        dfs(root, 0);
    }
    private void dfs(TreeLinkNode root, int level) {
        if (root == null) { return; }
        if (map.containsKey(level)) {
            map.get(level).next = root;
        }
        map.put(level, root);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
// dummy Node Linked List
// BFS
// O(1) space
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        while (root != null) {
            TreeLinkNode cur = dummy;
            while(root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = dummy.next;
            dummy.next = null;
        }
    }
}
