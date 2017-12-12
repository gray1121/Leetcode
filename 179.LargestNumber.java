class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) { return ""; }
        String[] sa = new String[nums.length];
        // order by strings
        for (int i = 0; i < sa.length; i++) {
            sa[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sa, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String n1 = s1 + s2;
                String n2 = s2 + s1;
                return n2.compareTo(n1);
            }
        });
        // edge case: all 0
        if (sa[0].equals("0")) { return "0"; } 
        StringBuilder sb = new StringBuilder();
        for (String s : sa) {
            sb.append(s);
        }
        return new String(sb);
    }
}
