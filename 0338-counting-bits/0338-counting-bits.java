class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for (int i = 0; i < n+1; i++) {
            int ones = 0;
            int j = i;
            while (j!=0) {
                ones = ones + (j%2);
                j = j/2;
            }
            ans[i]=ones;
        }
        
        return ans;
    }
}