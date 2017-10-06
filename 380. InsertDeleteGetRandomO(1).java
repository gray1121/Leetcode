import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class RandomizedSet {
    // use a dynamic data structure to store numbers
    ArrayList<Integer> list;
    // use a map to mark the index of every numbers
    // if duplicate allowed, use Map<Integer, Set<Integer>>
    Map<Integer, Integer> map;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) { return false; }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) { return false; }
        int index = map.get(val);
        // swap the last number with the one need to be removed
        if (index != list.size()) {
            int last = list.get(list.size() - 1);
            map.put(last, index);
            list.set(index, last);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // Use ArrayList becauese get() only needs O(1) time
        return list.get(rand.nextInt(list.size()));
    }
}