class Solution {
    
    public int numIslands(char[][] grid) {
        int islandCounter = 0;
        
        for(int row=0; row < grid.length; row++){
            for(int col=0; col < grid[0].length; col++){
                if(grid[row][col]=='1'){
                    exploreIsland(grid, row, col);
                    islandCounter++;
                }
            }
        }
        
        return islandCounter;
    }
    
    void exploreIsland(char[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return;
        
        if(grid[row][col]=='1'){
            grid[row][col]='2';
            if(row+1<grid.length)       exploreIsland(grid,row+1,col);
            if(row>0)                   exploreIsland(grid,row-1,col);
            if(col+1<grid[0].length)    exploreIsland(grid,row,col+1);
            if(col>0)                   exploreIsland(grid,row,col-1);
        }
    }   
}