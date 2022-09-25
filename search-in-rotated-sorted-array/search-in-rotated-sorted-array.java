class Solution {
    public int search(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int middle;
        while(start<=end){
            middle=(start+end)/2;
            if(target == nums[middle]) return middle;
            
            if(target<nums[middle]){
                if(nums[middle]<nums[end])  end=middle-1;
                else if(target>nums[end])     end=middle-1;
                else if(target<nums[start])       start=middle+1;
                else end=middle-1;
            }
            else{   //target>nums[middle]
                if(nums[end]<nums[middle])  start=middle+1;
                else if(target<nums[start])       start=middle+1;
                else if(target>nums[end])     end=middle-1;
                else start=middle+1;
            }
            
        }
        return -1;
    }
}