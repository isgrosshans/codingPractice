class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length < 3) return true;
        
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        
        int i = 0;
        while(i<graph.length && graph[i].length==0) i++;
        if (i==graph.length) return true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        A.add(i);
        
        boolean flag = true;
        
        for(i=0; i<graph.length; i++) {
            if(!A.contains(i) && !B.contains(i)) queue.add(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();

                if(A.contains(curr)) {
                    for (int n : graph[curr]){
                        if(A.contains(n)) return false;
                        if(!B.contains(n)){
                            B.add(n);
                            queue.add(n);
                        }
                    }
                }

                else {
                    for (int n : graph[curr]){
                        if(B.contains(n)) return false;
                        if(!A.contains(n)){
                            A.add(n);
                            queue.add(n);
                        }
                    }
                }
            }
        }
        
        return (true);
    }
}