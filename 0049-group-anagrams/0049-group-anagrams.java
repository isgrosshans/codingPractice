class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        
        HashMap<Map<Character, Integer>, List<String>> letterMapping = new HashMap<>();
        
        
        for(String s : strs){
            Set<Character> stringToCharSet = new HashSet<>();
            
            Map<Character, Integer> tempCharHeatMap = charHeatMap(s);
            
            if(!(letterMapping.containsKey(tempCharHeatMap))){
                letterMapping.put(tempCharHeatMap, new ArrayList<>());
            }
            letterMapping.get(tempCharHeatMap).add(s);
        }
        
        result.addAll(letterMapping.values());
        
        return result;
    }
    
    Map<Character, Integer> charHeatMap(String s){
        Map<Character, Integer> result = new HashMap<>();
        
        for(char c : s.toCharArray()){
            if(!(result.containsKey(c))) result.put(c,0);
            result.put(c, result.get(c)+1);
        }
        
        return result;
    }
}