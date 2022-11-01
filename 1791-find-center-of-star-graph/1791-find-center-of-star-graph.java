class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < edges.length; i++) {
            for (int n : edges[i]) {
                if (seen.contains(n)) return n;
                seen.add(n);
            }
        }
        return -1;
    }
}