class Solution {
    public int distributeCandies(int[] candyType) {
        
        int n = candyType.length;
        
        Set<Integer> distinctCandyTypes = new HashSet<>();
        
        for(int i=0; i<n; i++){
            distinctCandyTypes.add(candyType[i]);    
            if(distinctCandyTypes.size()==n/2) return n/2;
        }
        
        return distinctCandyTypes.size();
    }
}