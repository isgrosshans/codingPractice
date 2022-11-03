class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] givesTrust = new int[n+1];
        int[] isTrusted = new int[n+1];
        
        for( int[] t : trust) {
            givesTrust[t[0]]++;
            isTrusted[t[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if(givesTrust[i]==0 && isTrusted[i]==n-1)
                return i;
        }
        
        return -1;
    }
}