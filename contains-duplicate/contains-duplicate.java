class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int element : nums){
            if(hashSet.contains(element)) return true;
            hashSet.add(element);
        }
        return false;
    }
}