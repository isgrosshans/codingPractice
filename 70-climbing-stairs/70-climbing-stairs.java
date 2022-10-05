class Solution {
    public int climbStairs(int n) {
        int answer=0;
        int oneback=1;
        int twoback=0;
        for(int i=1; i<=n; i++){
            answer=oneback+twoback;
            twoback=oneback;
            oneback=answer;
        }
        return answer;

    }
}