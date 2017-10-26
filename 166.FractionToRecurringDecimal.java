/**
 * The important thing is to consider all edge cases while thinking this problem through, including: negative integer, possible overflow, etc.
 * Use HashMap to store a remainder and its associated index while doing the division so that whenever a same remainder comes up, we know there is a repeating fractional part.
 * Please comment if you see something wrong or can be improved. Cheers!
 **/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) { return "0"; }
        StringBuilder sb = new StringBuilder();
        // negative integer
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        // possible overflow
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        // integral part
        sb.append(num / den);
        num %= den;
        if (num == 0) { return sb.toString(); }
        // fractional part
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            }
            else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}