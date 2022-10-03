class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList();
        
        if(heights == null || heights.length == 0) return answer;
        
        int gridRows = heights.length;
        int gridCols = heights[0].length;
        
        boolean[][] Pacific = new boolean[gridRows][gridCols];
        boolean[][] Atlantic = new boolean[gridRows][gridCols];
        
        int row, col;
        
        for(row = 0; row < gridRows; row++){
            oceanFill(row, 0, Pacific, heights);
            oceanFill(row, gridCols-1, Atlantic, heights);
        }
        
        for(col = 0; col < gridCols; col++){
            oceanFill(0, col, Pacific, heights);
            oceanFill(gridRows-1, col, Atlantic, heights);
        }
        
        
        for(row = 0; row < gridRows; row++){
            for(col = 0; col < gridCols; col++){
                if(Pacific[row][col] && Atlantic[row][col]){
                    List<Integer> tempList = new ArrayList();

                    tempList.add(row);
                    tempList.add(col);
                    
                    answer.add(tempList);
                }
            }
        }

        return answer;
        
    }
    
    void oceanFill(int row, int col, boolean[][] ocean, int[][] heights){
        ocean[row][col] = true;
        
        //up
        if(row>0 && !(ocean[row-1][col])){
            if(heights[row-1][col] >= heights[row][col])
                oceanFill(row-1, col, ocean, heights);
        }
        
        //down
        if(row+1<ocean.length && !(ocean[row+1][col])){
            if(heights[row+1][col]>=heights[row][col])
                oceanFill(row+1, col, ocean, heights); 
        }
        
        //left
        if(col>0 && !(ocean[row][col-1])){
            if(heights[row][col-1] >= heights[row][col])
                oceanFill(row, col-1, ocean, heights);
        }
        
        //right
        if(col+1<ocean[0].length && !(ocean[row][col+1])){
            if(heights[row][col+1] >= heights[row][col])
                oceanFill(row, col+1, ocean, heights);
        }
        
    }
}