class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2) return s;
        
        int start=0, end=0;
        for(int i = 0; i + 1 < s.length(); i++){
            int oddLen = expandFromCenter(s, i, i);
            int evenLen = expandFromCenter(s, i, i+1);
            int len = Math.max(oddLen, evenLen);
            if(end-start < len){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        
        return s.substring(start, end+1);
    }
    
    int expandFromCenter(String s, int L, int R){
        while(L>=0 && R<s.length() &&
                    s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1; //length of the palindrome
    }
}