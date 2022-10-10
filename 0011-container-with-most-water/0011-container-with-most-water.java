class Solution {
    public int maxArea(int[] height) {
        int max=0;
        
        int left=0;
        int right=height.length-1;
        
        while(left<right){
            max=Math.max(max, area(height, left, right));
            if(height[left]<height[right]) left++;
            else right--;
        }
        
        return max;
    }
    
    int area(int[] height, int i, int j){
        return Math.min(height[i], height[j])*Math.abs(j-i);
    }
}