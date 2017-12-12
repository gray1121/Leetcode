// Sliding Window
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
// Sliding Window Optimized
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) { return 0; }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // "abba" 
                j = Math.max(j, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - j);
        }
        return maxLen;
    }
}