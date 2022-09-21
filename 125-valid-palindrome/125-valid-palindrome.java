class Solution {
    public boolean isPalindrome(String s) {
                            
        s=s.replaceAll("[^A-Za-z0-9]", "");
        s=s.toLowerCase();
        
        if(s.length()<=1) return true;
        
        int l = 0;
        int r = s.length()-1;
        
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}