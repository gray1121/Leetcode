class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) { return intervals; }
        // Greedy Sort 
        Collections.sort(intervals, new Comparator<Interval>() {
           @Override
            public int compare(Interval l1, Interval l2) {
                return l1.start - l2.start;
            }
        });
        List<Interval> res = new LinkedList<Interval>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (pre.end < temp.start) {
                res.add(pre);
                pre = temp;
            }
            else {
                pre.end = Math.max(pre.end, temp.end);
            }
        }
        res.add(pre);
        return res;
    }
}