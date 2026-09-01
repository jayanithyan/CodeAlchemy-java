"""

You are given an m x n grid classroom where a student volunteer is tasked with cleaning up litter scattered around the room. Each cell in the grid is one of the following:

'S': Starting position of the student
'L': Litter that must be collected (once collected, the cell becomes empty)
'R': Reset area that restores the student's energy to full capacity, regardless of their current energy level (can be used multiple times)
'X': Obstacle the student cannot pass through
'.': Empty space
You are also given an integer energy, representing the student's maximum energy capacity. The student starts with this energy from the starting position 'S'.

Each move to an adjacent cell (up, down, left, or right) costs 1 unit of energy. If the energy reaches 0, the student can only continue if they are on a reset area 'R', which resets the energy to its maximum capacity energy.

Return the minimum number of moves required to collect all litter items, or -1 if it's impossible

""";



import java.util.*;
class Solution{
    class state{
        int row;
        int col;
        int energy;
        int mask;
        int moves;
        state(int row,int col,int energy,int mask,int moves){
            this.row=row;
            this.col=col;
            this.energy=energy;
            this.mask=mask;
            this.moves=moves;
        }
    }
    public int minMoves(String[] classroom, int energy){
        int m=classroom.length;
        int n=classroom[0].length();
        int sr=0;
        int sc=0;
        int[][] litterId=new int[m][n];
        for(int r=0;r<m;r++){
            Arrays.fill(litterId[r],-1);
        }
        int litterCount=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(classroom[r].charAt(c)=='S'){
                    sr=r;
                    sc=c;
                }
                if(classroom[r].charAt(c)=='L'){
                    litterId[r][c]=litterCount++;
                }
            }
        }
        int targetMask=(1<<litterCount)-1;
        boolean[][][][] visited=new boolean[m][n][energy+1][1<<litterCount];
        Queue<state> queue=new LinkedList<>();
        queue.offer(new state(sr,sc,energy,0,0));
        visited[sr][sc][energy][0]=true;
        int[][] directions={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!queue.isEmpty()){
            state current=queue.poll();
            int r=current.row;
            int c=current.col;
            int currentEnergy=current.energy;
            int mask=current.mask;
            int moves=current.moves;
            if(mask==targetMask){
                return moves;
            }
            for(int[] direction:directions){
                int nr=r+direction[0];
                int nc=c+direction[1];
                if(nr<0||nr>=m||nc<0||nc>=n){
                    continue;
                }
                if(classroom[nr].charAt(nc)=='X'){
                    continue;
                }
                if(currentEnergy==0){
                    continue;
                }
                int newEnergy=currentEnergy-1;
                if(classroom[nr].charAt(nc)=='R'){
                    newEnergy=energy;
                }
                int newMask=mask;
                if(classroom[nr].charAt(nc)=='L'){
                    int litter=litterId[nr][nc];
                    newMask|=(1<<litter);
                }
                if(visited[nr][nc][newEnergy][newMask]){
                    continue;
                }
                visited[nr][nc][newEnergy][newMask]=true;
                queue.offer(
                    new state(
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves+1
                    )
                );
            }
        }
        return -1;
    }
}