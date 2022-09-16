class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        for(int element : nums1){
            nums1Set.add(element);
        }
        for(int element : nums2){
            nums2Set.add(element);
        }
        
        nums1Set.retainAll(nums2Set);
        int i = 0;
        int[] res = new int[nums1Set.size()];
        for(int element : nums1Set){
            if(nums2Set.contains(element)){
                res[i++]=element;
            }
        }
        return res;
    }
}