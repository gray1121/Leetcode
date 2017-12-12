public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] mem = new int[len + 1];
        mem[len] = 1;
        mem[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;
        
        for(int i = len - 2; i >= 0; --i) {
            if(s.charAt(i) == '0')  continue;
            mem[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? mem[i + 1] + mem[i + 2] : mem[i + 1];  
        }
        return mem[0];
    }
}