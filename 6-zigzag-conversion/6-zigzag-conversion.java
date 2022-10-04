class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        
        String answer="";
        
        int bigStep = numRows*2-2;
        
        int i=0;
        
        for(int row=0; row < numRows; row++){
            i=row;
            while(i<s.length()){
                answer+=s.charAt(i);
                if(row>0 && row<numRows-1 && i+bigStep-(row*2)< s.length()){
                    answer+=s.charAt(i+bigStep-(row*2));
                } 
                i+=bigStep;
            }
        }
        
        return answer;
    }
}