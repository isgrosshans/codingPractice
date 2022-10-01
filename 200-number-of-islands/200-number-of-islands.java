class Solution {
    Set<Integer> visited = new HashSet();
    
    public int numIslands(char[][] grid) {
        int islandCounter = 0;
        
        for(int row=0; row < grid.length; row++){
            for(int col=0; col < grid[0].length; col++){
                if(grid[row][col]=='1' && !(visited.contains(cellId(grid,row,col)))){
                    exploreIsland(grid, row, col);
                    islandCounter++;
                }
            }
        }
        
        return islandCounter;
    }
    
    void exploreIsland(char[][] grid, int row, int col){
        if(visited.contains(cellId(grid,row,col))) return;
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return;
        
        if(grid[row][col]=='1'){
            visited.add(cellId(grid,row,col));
            exploreIsland(grid,row+1,col);
            exploreIsland(grid,row-1,col);
            exploreIsland(grid,row,col+1);
            exploreIsland(grid,row,col-1);
        }
    }   
    
    int cellId(char[][] grid, int row, int col){
        return row * grid[0].length + col;
    }
}