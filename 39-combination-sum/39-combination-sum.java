class Solution {
    List<List<Integer>> answer = new LinkedList();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tempList = new LinkedList();
        comboFinder(tempList, candidates, target);
        return answer;

    }
    
    void comboFinder(List<Integer> soFar, int[] candidates, int target) {
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] <= target){
                List<Integer> tempList = new LinkedList();
                tempList.addAll(soFar);
                tempList.add(candidates[i]);
                
                if(candidates[i] == target){
                    answer.add(tempList);
                }   //candidates[i] < target
                else{
                    int[] tempCandidates = new int[candidates.length-i];
                    for(int j = 0; j < tempCandidates.length; j++){
                        tempCandidates[j] = candidates[j+i];
                    }
                    comboFinder(tempList, tempCandidates, target-candidates[i]);
                }
            }
            //if candidates[i] > target -> do nothing
        }
    }
}