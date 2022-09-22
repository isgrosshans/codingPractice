class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> alphabet = new HashMap();
        int l=0;
        int maxLength=0;
        int currentLength;
        for(int r=0; r<s.length(); r++){
            if(alphabet.containsKey(s.charAt(r))){
                currentLength=r-l;
                if(maxLength<currentLength){
                    maxLength=currentLength;
                }
                if(alphabet.get(s.charAt(r))>=l){
                    l=alphabet.get(s.charAt(r))+1;
                }
            }
            alphabet.put(s.charAt(r),r);
        }
        currentLength=s.length()-l;
        if(maxLength<currentLength){
            maxLength=currentLength;
        }
        return maxLength;
    }
}