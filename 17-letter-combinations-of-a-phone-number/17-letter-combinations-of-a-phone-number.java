class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList();
        
        if(digits.length()==0 || !(digits.matches("[2-9]*"))) return res;
        
        backtrack(digits, "", res);
        
        return res;
    }
    
    void backtrack(String digitsLeft, String stb, List<String> res){
        if(digitsLeft.length()==0) res.add(stb);
        
        else {
            for(char digit : digitLetters(digitsLeft.charAt(0)).toCharArray()){
                backtrack(digitsLeft.substring(1), stb+digit, res);
            }
        }
    }
    
    
    String digitLetters(char digit){
        
        if(digit=='2') return "abc";
        if(digit=='3') return "def";
        if(digit=='4') return "ghi";
        if(digit=='5') return "jkl";
        if(digit=='6') return "mno";
        if(digit=='7') return "pqrs";
        if(digit=='8') return "tuv";
        if(digit=='9') return "wxyz";
        return "";
    }
}