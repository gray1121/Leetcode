/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    // bruteforce O(N^2) Time
    // greedy O(N) Time with full check of the whole party
    public int findCelebrity(int n) {
        if (n <= 1) { return -1; }
        int celebrity = 0;
        // find the potential celebrity by one pass
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        // check if this candidate is valid
        for (int i = 0; i < n; i++) {
            if (i == celebrity) { continue; }
            if (knows(celebrity, i) || !knows(i, celebrity)) { return -1; }
        }
        return celebrity;
    }
}