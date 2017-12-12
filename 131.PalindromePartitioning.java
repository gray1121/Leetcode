class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s == null || s.length() == 0) { return res; }
        dfs(res, new LinkedList<String>(), s, 0);
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> list, String s, int pos) {
        if (pos == s.length()) { 
            res.add(new LinkedList<String>(list)); 
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            if(isPalindrome(s.substring(pos, i))) {
                list.add(s.substring(pos, i));
                dfs(res, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while(i < j) {
            if (str.charAt(i) != str.charAt(j)) { return false; }
            i++;
            j--;
        }
        return true;
    }
}