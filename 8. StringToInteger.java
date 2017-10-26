// WTF is this problem

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) { return 0; }
        int sign = 1;
        int num = 0;
        int count = 0;
        boolean hasNum = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)) || (hasNum && str.charAt(i) == ' ')) { break; }
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == 1) { return Integer.MAX_VALUE; }
                else { return Integer.MIN_VALUE; }
            }
            if (count > 1) { return 0; }
            if (str.charAt(i) == '-' || str.charAt(i) == '+') { 
                if (str.charAt(i) == '-') { sign = -1; }
                hasNum = true;
                count++;
            }
            else if (Character.isDigit(str.charAt(i))) {
                hasNum = true;
                num = num * 10 + str.charAt(i) - '0';
            }
        }
        return num * sign;
    }
}