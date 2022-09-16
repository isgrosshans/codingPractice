class MyHashSet {
    
    int[] array = new int[1000001];

    public MyHashSet() {
        this.array[0] = -1;
    }
    
    public void add(int key) {
        array[key] = key;
    }
    
    public void remove(int key) {
        array[key] = -1;   
    }
    
    public boolean contains(int key) {
        return array[key] == key;
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */