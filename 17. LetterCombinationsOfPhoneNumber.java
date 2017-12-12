class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) { return res; }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterBacktracking(map, res, digits, "");
        return res;
    }
    private void letterBacktracking(String[] map, List<String> res, String digits, String letters) {
        if (letters.length() == digits.length()) { 
            res.add(letters);
            return;
        }
        String sequence = map[digits.charAt(letters.length()) - '0'];
        for (int i = 0; i < sequence.length(); i++) {
            letterBacktracking(map, res, digits, letters + sequence.charAt(i));
        }
    }
}