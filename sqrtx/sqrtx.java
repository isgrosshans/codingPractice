class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        
        int t=x/2;
        int b=2;
        int m;
        long guess;
        
        while(b<=t){
            m=(t+b)/2;
            guess=(long)m*m;
            if(guess > x) t=m-1;
            else if(guess < x) b=m+1;
            else return m;
        }
        
        return t;
    }
}