class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> once = new TreeSet();
        Set<Integer> thrice = new TreeSet();
        
        for(int n : nums){
            if(!thrice.contains(n)){
                if(once.contains(n)){
                    once.remove(n);
                    thrice.add(n);
                }
                else
                    once.add(n);
            }
        }
        
        for(int n : once){
            return n;
        }
        
        return -1;
    }
}