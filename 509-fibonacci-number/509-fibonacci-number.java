class Solution {

    public int fib(int n) {
        if(n<2) return n;
        
        int backOne = 1;
        int backTwo = 0;
        int answer=0;
        
        for(int i=1; i<n; i++){
            answer = backOne + backTwo;
            backTwo = backOne;
            backOne = answer;
        }
        
        return answer;
        
    }
}