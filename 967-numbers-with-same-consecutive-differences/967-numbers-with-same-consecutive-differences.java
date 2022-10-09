class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> intermediateRes = new ArrayList<>();
        
        
        for(int i=1; i<10; i++){
            if(i+k<10 || i-k>=0){
                backtrack(intermediateRes, i, 1, n, k);
            }
        }
        
        int[] result = new int[intermediateRes.size()];
        int i=0;
        for(int element : intermediateRes){
            result[i]=element;
            i++;
        }
        
        return result;
    }
    
    void backtrack(List<Integer> intermediateRes, 
                   int numberSoFar,
                   int currSize, 
                   int targetSize, 
                   int difference){
        
        if(currSize==targetSize) {
            intermediateRes.add(numberSoFar);
            return;
        }
        
        if(numberSoFar%10 + difference < 10){
            backtrack(intermediateRes, 
                      numberSoFar*10 + numberSoFar%10 + difference,
                      currSize+1,
                      targetSize, 
                      difference);
        }
        
        if(difference!=0 && numberSoFar%10 - difference >= 0){
            backtrack(intermediateRes, 
                      numberSoFar*10 + numberSoFar%10 - difference,
                      currSize+1,
                      targetSize, 
                      difference);
        }       
    }
}