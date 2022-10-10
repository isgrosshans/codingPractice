class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i< numbers.length; i++){
            int otherAddend = binSearch(numbers, target-numbers[i], i+1, numbers.length-1);
            if(otherAddend!=-1) return new int[]{i+1, otherAddend+1};
        }
        return new int[0];
    }
    
    int binSearch(int[] nums, int target, int left, int right){
        
        while(left<=right){
            int middle=(left+right)/2;
            if (nums[middle] == target) return middle;
            else if(nums[middle] > target) right=middle-1;
            else left = middle+1;
        }
        return -1;      
        
    }
}