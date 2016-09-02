public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // Two numbers mutiply, the product's max digit is the sum of these two
        int[] mul = new int[m+n];
        for(int i = m - 1; i >= 0; --i){
            for(int j = n - 1; j >= 0; --j){
                int pos1 = i + j, pos2 = i + j + 1;
                // From the end to the front
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + mul[pos2];
                mul[pos1] += sum / 10;
                mul[pos2] = sum % 10;
            }
        }
        // Transfer this array to a string
        StringBuilder sb = new StringBuilder();
        for(int p : mul){
            if(!(sb.length() == 0 && p == 0)){
                sb.append(p);
            }
        }
        // corner case '0'
        return sb.length() == 0 ? "0" : sb.toString();
    }
}