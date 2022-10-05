class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        if(nums.length==3) return Math.max(nums[0]+nums[2], nums[1]);
            
        
        int[] maxs=new int[nums.length];
        maxs[0]=nums[0];
        maxs[1]=nums[1];
        maxs[2]=nums[2]+nums[0];
        
        for(int i=3; i< maxs.length; i++){
            maxs[i]=nums[i]+Math.max(maxs[i-2], maxs[i-3]);
        }
        
        return Math.max(maxs[maxs.length-1], maxs[maxs.length-2]);
    }
}