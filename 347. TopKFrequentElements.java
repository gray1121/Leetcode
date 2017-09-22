class Solution {
    public List<Integer> topKFrequent1(int[] nums, int k) {
    // maxheap
    // frequence may be same
    // worst case O(nlog(n))
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0 || k == 0)
            return res;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> maxheap = new PriorityQueue<int[]>(map.size(), new Comparator<int[]>() {
           @Override
            public int compare(int[] a1, int[] a2) {
                return a2[1] - a1[1];
            }
        });
        for (int key : map.keySet()) {
            maxheap.offer(new int[]{key, map.get(key)});
        }
        while (k-- != 0) {
            res.add(maxheap.poll()[0]);
        }
        return res;
    }



    public List<Integer> topKFrequent2(int[] nums, int k) {
        // Use (more) space to optimize time
        // bucket sort
        // Worst Time O(n) Space O(n)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : map.keySet()) {
            int frequence = map.get(key);
            if(bucket[frequence] == null) {
                // use linkedlist to avoid collision
                bucket[frequence] = new LinkedList<Integer>();
            }
            bucket[frequence].add(key);
        }
        List<Integer> res = new LinkedList<Integer>();
        for(int i = nums.length; i > 0 && res.size() < k; --i) {
            if(bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}