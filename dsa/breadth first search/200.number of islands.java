"""

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

""";



class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        Queue<int[]> queue=new LinkedList<>();
        int[][] directions={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    grid[i][j]='0';
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] current=queue.poll();
                        int currentRow=current[0];
                        int currentCol=current[1];
                        for(int[] direction:directions){
                             int newRow=currentRow+direction[0];
                             int newCol=currentCol+direction[1];
                             if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]=='1'){
                                grid[newRow][newCol]='0';
                                queue.offer(new int[]{newRow,newCol});
                             }
                        }
                    }
                }
            }
        }
        return count;
    }
}