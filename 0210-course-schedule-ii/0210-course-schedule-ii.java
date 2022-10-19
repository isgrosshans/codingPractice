class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] order = new int[numCourses];
        int orderidx = 0;
        
        int[] indegree = new int[numCourses];
        
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        
        Stack<Integer> zeroIndegree = new Stack<>();
        
        
        for(int i = 0; i < numCourses; i++){
            dependencies.put(i, new ArrayList());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int dep = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[dep]++;
            dependencies.get(pre).add(dep);
        }
          
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                zeroIndegree.push(i);
        }
        
        while(!zeroIndegree.isEmpty()) {
            int curr = zeroIndegree.pop();
            
            order[orderidx++] = curr;
            
            for(int d : dependencies.get(curr)){
                
                if(--indegree[d] == 0){
                    zeroIndegree.push(d);
                }
            }
        }
        
        if(orderidx == numCourses) return order;
        return new int[]{};
    }
}