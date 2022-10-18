/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Set<Node> nodeset = dfs(node);
        Map<Node, Node> oldNew = new HashMap<>();
        
        for(Node old : nodeset){
            oldNew.put(old, new Node(old.val));
        }
        
        for(Node old : nodeset){
            for(Node nghbr : old.neighbors){
                oldNew.get(old).neighbors.add(oldNew.get(nghbr));
            }
        }
            
        return oldNew.get(node);
    }
    
    private Set<Node> dfs(Node node) {
        Set<Node> nodeset = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        
        stack.push(node);
        
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            nodeset.add(curr);
            
            for(Node n : curr.neighbors) {
                if(!nodeset.contains(n))
                    stack.push(n);
            }
        }
        
        return nodeset;
    }
}