public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        if (n <= 0)
            return res;
        dfs(n, res, "", 0 , 0);
        return res;
    }
    private void dfs(int n, List<String> res, String s, int left, int right) {
        if (s.length() == n * 2)
            res.add(s);
        if (left < n)
            dfs(n, res, s + "(", left + 1, right);
        if (right < left)
            dfs(n, res, s + ")", left, right + 1);
    }
}