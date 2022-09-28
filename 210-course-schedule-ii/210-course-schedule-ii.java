class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // directed graph:  [B, A]
        // A -> B   means A is a prerequisite to B
        //          IE you must complete A to do B
        
        int[] order = new int[numCourses];
        
        //early return: no prerequisites
        if(prerequisites.length==0){
            for(int i = 0; i < numCourses; i++)
                order[i]=i;
            return order;
        }
            
        int[] indegree = new int[numCourses];
        Queue<Integer> zeroIndegree = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        Map<Integer, HashSet<Integer>> adjacencies = new HashMap<>();
        
        //initialize nodes in adjacency list
        for(int j = 0; j < numCourses; j++){
            adjacencies.put(j, new HashSet<>());
        }
        
        //fill adjacency list
        for(int row = 0; row < prerequisites.length; row++){
            adjacencies.get(prerequisites[row][1]).add(prerequisites[row][0]);
            indegree[prerequisites[row][0]]++;
        }
        
        //put elements with indegree 0 into the queue
        for(int k=0; k < numCourses; k++){
            if(indegree[k]==0) zeroIndegree.add(k);
        }
        
        
        
        int orderSize=0;
        
        while(!zeroIndegree.isEmpty()){
            int curr=zeroIndegree.poll();
            if(adjacencies.containsKey(curr)){
                for(int adjNode : adjacencies.get(curr)){
                    if(indegree[adjNode]-- == 1){
                        zeroIndegree.add(adjNode);
                    }
                }
                indegree[curr]--;
                order[orderSize++]=curr;
                adjacencies.remove(curr);
            }
        }
        
        
        if(orderSize<numCourses) return new int[0];
        
        return order;
    }
    
    
}