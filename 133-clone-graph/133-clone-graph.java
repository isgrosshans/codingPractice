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
        
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        Map<Node, Node> oldAndClone = new HashMap<>();
        
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            if(!(visited.contains(curr))){
                visited.add(curr);
                oldAndClone.put(curr, new Node(curr.val));
                
                for(Node neighbor : curr.neighbors){
                    stack.push(neighbor);
                }
            }
        }
        
        for(Node old : oldAndClone.keySet()){
            Node currClone = oldAndClone.get(old);
            
            for(Node neighbor : old.neighbors){
                currClone.neighbors.add(oldAndClone.get(neighbor));
            }
        }
        
        return oldAndClone.get(node);
        
    }
}