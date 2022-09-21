class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] alphabetCounter = new int[26];
        for(int i=0; i<s.length(); i++){
            alphabetCounter[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            alphabetCounter[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++){
            if(alphabetCounter[i]!=0) return false;
        }
        return true;
    }
}