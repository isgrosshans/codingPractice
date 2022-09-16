class MyHashMap {
    
    int[] keys = new int[1000001];
    int[] values = new int[1000001];

    public MyHashMap() {
        this.keys[0]=-1;
    }
    
    public void put(int key, int value) {
        this.keys[key] = key;
        this.values[key] = value;
    }
    
    public int get(int key) {
        if(keys[key] == key) return this.values[key];
        return -1;
    }
    
    public void remove(int key) {
        this.keys[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */