class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int element : nums) {
            if(hashSet.contains(element)) hashSet.remove(element);
            else hashSet.add(element);
        }
        for(int element : hashSet){
            return element;
        }
        return 999999;
    }    
}