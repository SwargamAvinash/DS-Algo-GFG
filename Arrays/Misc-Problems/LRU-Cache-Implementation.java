class LRUCache {
    Map<Integer, Integer> map;
    Set<Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new LinkedHashSet<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        cache.remove(key);
        cache.add(key);  
        
        System.out.println(map);
        System.out.println(cache);
        return map.get(key);
    
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.put(key,value);
            cache.remove(key);
            cache.add(key);
            return;
        }
        if (map.size() >= capacity) {
            int rm = cache.stream().findFirst().get();
            map.remove(rm);
            cache.remove(rm);
        }
        map.put(key, value);
        cache.add(key);
        
        System.out.println(map);
        System.out.println(cache);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */