"""

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

""";



class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color)
            return image;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        int[][]  directions={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        image[sr][sc]=color;
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int row=current[0];
            int col=current[1];
            for(int[] direction:directions){
                int newRow=row+direction[0];
                int newCol=col+direction[1];
                if(newRow>=0 && newRow<image.length && newCol>=0 && newCol<image[0].length && image[newRow][newCol]==originalColor){
                    image[newRow][newCol]=color;
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }
        return image;
    }
}