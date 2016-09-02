/*We start with trimming.
    If we see [0-9] we reset the number flags.
    We can only see . if we didn't see e or ..
    We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
    We can only see + and - in the beginning and after an e
    any other character break the validation.
*/
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean beforeE = false;
        boolean afterE = true;
        boolean eSeen = false;
        boolean dotSeen = false;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                beforeE = true;
                afterE = true;
            }else if(s.charAt(i) == 'e'){
                if (eSeen || !beforeE){
                    return false;
                }
                eSeen = true;
                afterE = false;
            }else if(s.charAt(i) == '.'){
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i == 0){
                    continue;
                }else if(s.charAt(i - 1) == 'e'){
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return beforeE&&afterE;
    }
}