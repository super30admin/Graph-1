//1.Find the Town Jugde
//Time Compleixty -> O(v+e)
//Space Complexity -> O(e)
class Solution {
    public int findJudge(int n, int[][] trust) {
       // if(trust == null || trust.length == 0) return -1;
        //person[0] person trust person[1] person 
        //we will caluclate the indegrres and outdegrees of each indivijual in the same array
        //we will increase the indegree of person[1] and decrease the indegree of person[0]
        int[] inDegrees = new int[n+1];
        for(int[] persons : trust){
            inDegrees[persons[1]]++;
            inDegrees[persons[0]]--;
            
        }
        for(int i = 1 ;i < n+1 ;i++){
            if(inDegrees[i] == n-1){
                return i;
            }
        }

        return -1;
        
    }
}

//2nd Ball in a maze


class Solution {
    //Using BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) return false;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2; //mark as visited
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0];
                int c = curr[1];
                //we will go until we get a wall
                while(r>=0 && c>=0 && r<n && c<m && maze[r][c]!=1){
                    r = r + dir[0];
                    c = c + dir[1];
                }
                //take one step back
                r = r - dir[0];
                c = c - dir[1];
                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c]!=2){
                    q.add(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }
        
        }
        return false;
    }
}

class Solution {
    //Using DFS
    int n ;
    int m ;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) return false;
        this.n = maze.length;
        this.m = maze[0].length;
        this.dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        return dfs(maze,start,destination);
        
    }

    private boolean dfs(int[][] maze,int[] curr,int[] destination){
        //base case
        if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
        //means if we have reached our destination we return true
        if(maze[curr[0]][curr[1]] == 2) return false;
        //it means if we have already visited the cordinate and is not destination, not need to explore the path from this cordinate 
        //as it is already visited hence we return false

        //logic
        //when we come to a cordinate and it is not the destintion we make the coordinate mark as 2 or visited
        maze[curr[0]][curr[1]] = 2;
        for(int[] dir : dirs){
            int r = curr[0];
            int c = curr[1];
            while(r >=0 && c>=0 && r<n && c<m && maze[r][c]!=1){
                r = r + dir[0];
                c = c + dir[1];
            }
            //we have to take one step back as because of the while loop
            //we came to the cordinate of the wall and we need to get one step back from the wall
            //as we cant be on the wall
            r = r - dir[0];
            c = c - dir[1];
            int[] newCurr = new int[]{r,c};
            if(dfs(maze,newCurr,destination)) return true; //if we get a valid path from this cordiate we cn say that
            //it can lead to destination and hence we can return true;
        }
        //if any of the dirctions can't lead to destination hence we can say that it can't lead to a valid path hence return false'
        return false;

    }
}