// ## Problem2 The Maze (https://leetcode.com/problems/the-maze/)

class Solution {
    // BFS - The neighbors is the next position we will stop at, 
    // and not immediate neighbors like in a regular BFS
    // we will maintain visited by marking a node as 2
    // Time - O(mn)
    // Space - O(mn)

    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        this.dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0}};

        Queue<int []> q=new LinkedList<>();
        q.add(start);
        //mark visited
        maze[start[0]][start[1]]=2;

        while(!q.isEmpty()){
            int[] curr=q.poll();

            // iterate over neighbors
            for(int[] dir:dirs){
                int r=curr[0];
                int c=curr[1];

                // move in current direction till we hit a wall or go out of bounds
                while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1){
                    r+=dir[0];
                    c+=dir[1];
                }

                //step-back in the same direction as we went one step ahead
                r-=dir[0];
                c-=dir[1];

                //check if not already visited and add to queue
                if(maze[r][c]!=2){

                    //if desitantion
                    if(r==destination[0] && c==destination[1]){
                        return true;
                    }

                    q.add(new int[] {r,c});
                    maze[r][c]=2;
                }
            }
        }

        // cannot reach
        return false;
    }
}