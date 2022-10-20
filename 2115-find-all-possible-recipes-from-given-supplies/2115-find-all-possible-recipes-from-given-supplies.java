class Solution {
    Set<String> supplies = new HashSet<>();
    Map<String, List<String>> recipes = new HashMap<>();
    List<String> possibleRecipes = new ArrayList<>();
    
    public List<String> findAllRecipes(String[] recipesIn, 
                                       List<List<String>> ingredientsIn, 
                                       String[] suppliesIn) {
        
        for(String s : suppliesIn){
            supplies.add(s);
        }
        
        int i=0;
        
        for(List<String> ingredientList : ingredientsIn){
            recipes.put(recipesIn[i++], ingredientList);
        }
        
        for (String r : recipes.keySet()){
            if (isPossible(r)) {
                possibleRecipes.add(r);
            }
        }
        
        return possibleRecipes;
    }
    
    private boolean isPossible(String recipe) {
        
        Stack<String> stack = new Stack<>();
        
        stack.push(recipe);
        
        while(!stack.isEmpty()) {
            String curr = stack.pop();
            
            for (String ing : recipes.get(curr)){
                
                if(stack.contains(ing)) return false;
                
                else if(recipes.containsKey(ing)) stack.push(ing);
                    
                else if(!supplies.contains(ing)) return false;

            }
        }
        
        return true;
    }
    
}



/*
*   bread
*   |     \
*   yeast  flour
*
*
*   
*
*           sandwich
*           |       \
*       bread       meat
*       |   \
*   yeast   flour
*   
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*/