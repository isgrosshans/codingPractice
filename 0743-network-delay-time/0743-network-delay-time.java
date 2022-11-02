class Solution {
    //times: (u,v,w)  (u)--w-->(v)
    //n = number of nodes
    //k = strating node
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> adj = createAdj(times, n);
        int[] delay = new int[n];
        // Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            delay[i] = Integer.MAX_VALUE;
        }
        
        q.add(k);
        delay[k-1] = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            if (adj.containsKey(curr)) {
                Map<Integer, Integer> map = adj.get(curr);
                for (int t : map.keySet()) {
                    if(delay[t-1] > delay[curr-1] + map.get(t)) {
                        delay[t-1] = delay[curr-1] + map.get(t);
                        q.add(t);
                    }
                }       
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, delay[i]);
        }
        
        if(max == Integer.MAX_VALUE) return -1;
        return max;
    }
    
    private Map<Integer, Map<Integer, Integer>> createAdj(int[][] times, int n) {
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        
        for (int[] t : times) {
            adj.putIfAbsent(t[0], new HashMap<>());
            adj.get(t[0]).put(t[1], t[2]);
        }
        
        return adj;
    }
}


/*
[1,2,0],
[1,3,79],
[1,4,99],
[1,5,61],

[2,1,47],
[2,3,13],
[2,4,77],
[2,5,58],

[3,1,81],
[3,2,18],
[3,4,68],
[3,5,46],

[4,1,6],
[4,2,76],
[4,3,30],
[4,5,19],

[5,1,25],
[5,2,74]
[5,3,44],
[5,4,7],

5
3

*/