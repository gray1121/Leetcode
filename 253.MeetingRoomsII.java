/**
 * Initially, j points to the first end event, and we move i which is the start event pointer. 
 * As we examine the start events, we’ll find the first two start events happen before the end event 
 * that j points to, so we need two rooms, as shown by the variable 
 * count. Then, as i points to the third start event, we’ll find that this event happens after the end event 
 * pointed by j, then we increment j so that it points to the next end event. What happens here can 
 * be thought of as one of the two previous meetings ended, and we moved the newly started meeting into that vacant 
 * room, thus we don’t need to increment count at this time and move both of the pointers forward.
 * Next, because j moves to the next end event, we’ll find that the start event pointed 
 * by i happens before the end event pointed by j. Thus, now we have 4 meetings started but only one ended,
 * so we need one more room. And it goes on as this.
 */

class Solution {
    // little faster than heap approach
    // but the idea is pretty similar
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) { return 0; }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int j = 0;
        // Greedy sort 
        // very tricky 
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[j] ) {
                count++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}






/******************** Heap approach ***********************/


class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) { return 0; }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            Interval temp = heap.poll();
            if (temp.end <= intervals[i].start) {
                temp.end = intervals[i].end;
            }
            else {
                heap.offer(intervals[i]);
            }
            heap.offer(temp);
        }
        return heap.size();
    }
}