class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1]>nums[nums.length - 2]) return nums.length - 1;
        
        int left = 0; 
        int right = nums.length-1;
        
        while(left <= right){           
            int mid = left + (right - left) / 2;
            if(mid<=0) mid=1;
            if(mid>=nums.length) mid=nums.length-1;
            
            
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}