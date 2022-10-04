class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        
        int leftPivot;
        int rightPivot;
        String answer=s.charAt(0)+"";
        
        for(int i = 0; i + 1 < s.length(); i++){
            
            if(i+2<s.length() && s.charAt(i)==s.charAt(i+2)){
                
                leftPivot=i;
                rightPivot=i+2;
                String tempPalindrome=""+s.charAt(i+1);
                while(leftPivot>=0 && rightPivot<s.length() &&
                    s.charAt(leftPivot)==s.charAt(rightPivot)){
                    tempPalindrome = s.charAt(leftPivot--)
                        + tempPalindrome
                        + s.charAt(rightPivot++);
                }
                if(tempPalindrome.length()>answer.length())
                    answer=tempPalindrome;
            }
            
            if(s.charAt(i)==s.charAt(i+1)){
                leftPivot=i;
                rightPivot=i+1;
                String tempPalindrome="";
                while(leftPivot>=0 && rightPivot<s.length() &&
                    s.charAt(leftPivot)==s.charAt(rightPivot)){
                    tempPalindrome = s.charAt(leftPivot--)
                        + tempPalindrome
                        + s.charAt(rightPivot++);
                }
                if(tempPalindrome.length()>answer.length())
                    answer=tempPalindrome;
            }
        }
        return answer;
    }
}