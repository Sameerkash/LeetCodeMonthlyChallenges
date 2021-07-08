class RandomizedSet {

    // The most optimal way is to use HashMap + array 
    // HashSet will cause bottleneck in getRandom as there is no way access index;
    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
            arr.add(val);
            map.put(val, arr.size() -1 );
            return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    
    /// removing the element by index would take O(n) time, swapping takes O(1)
    public boolean remove(int val) {
        // get the index of the value to remove
        int index = map.getOrDefault(val, -1);
        if(index == -1) return false;
        // swap it with the last index;
        Collections.swap(arr, index, arr.size() -1);
        // update the map with the updated index of the map.
        map.put(arr.get(index), index);
        // remove the last element from array
        arr.remove(arr.size() - 1);
        // remove the value
        map.remove(val);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // generate a random number by the index of the array elements
        return arr.get(rand.nextInt(arr.size()));

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */