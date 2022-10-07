class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList();
        backtrack(n, 0 , 0, "", res);
        return res;
    }
    
    void backtrack(int n, int open, int closed, String intermediate, List<String> res){
        if(open == closed && open==n){
            res.add(intermediate);
        }
        
        else if(open == closed && open < n){
            backtrack(n, open+1, closed, intermediate+"(", res);  
        }
        
        else if(open>closed && open==n){
            backtrack(n, open, closed+1, intermediate+")", res);  
        }
        
        else if(open>closed && open<n){
            backtrack(n, open, closed+1, intermediate+")", res);  
            backtrack(n, open+1, closed, intermediate+"(", res);  
        }
    }
}