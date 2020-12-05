class RandomizedSet {
    List<Integer> storage; // For Random Access -> Optimization
    Map<Integer, Integer> hashmap; // For insert and remove optimizaiton

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.storage = new ArrayList<>();
        this.hashmap = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashmap.containsKey(val)) {
            return false;
        }
        
        hashmap.put(val, storage.size()); // Storing the position of the Val in List
        storage.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hashmap.containsKey(val)) {
            return false;
        }
        
        int posi = hashmap.get(val);
        int posi2 = storage.size()-1;
        hashmap.put(storage.get(posi2), posi);
        hashmap.remove(val);
        storage.set(posi, storage.get(posi2));
        storage.remove(posi2);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int a = (int)(Math.random() * storage.size());
        return storage.get(a);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */