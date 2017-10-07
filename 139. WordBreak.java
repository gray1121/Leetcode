class Solution {
    // Use set
    // dp approach
    // O(n^2)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) { 
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

// if the wordDict is not very large (larger than the length of the string)
// this dp approach will be faster
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); ++i) {
            for (String word : wordDict) {
                int index = i - word.length();
                if ( index >= 0 && dp[index] && s.substring(index, i).equals(word)) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}