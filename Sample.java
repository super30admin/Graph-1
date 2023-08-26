//Problem 1 - > Find the town judge
// Time Complexity : O(n+(n^2-1))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//try to find out trust dependencies and maintain an array. find element which is trusted by all n-1 elements, if not found we dont have a judge
class Solution {
    //O(V+E)==O(n+(n^2-1)) //SC: O(V)=O(n)
    public int findJudge(int n, int[][] trust) {
        int[] indegrees= new int[n];

        for(int[] arr: trust){
            indegrees[arr[1]-1]++;
            indegrees[arr[0]-1]--;
        }

        for(int i=0;i<n;i++){
            if(indegrees[i]==n-1) return i+1;
        }
        return -1;
    }
}


//Problem 2 - > The maze
// Time Complexity : O(4mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// We have to check for all possible paths a ball can take and check if the ball STOPS at destination. if not return false
//BFS O(4m*n) O(m*n)
//DFS O(4m*n) O(m*n)
class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        if(maze==null) return false;
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        int m=maze.length;
        int n=maze[0].length;
        // Queue<int[]> q=new LinkedList<>();
        // q.add(start);
        // maze[start[0]][start[1]]=2;
        // while(!q.isEmpty()){
        //     int[] cur=q.poll();

        //     for(int[] dir: dirs){
        //         int nr=cur[0];
        //         int nc=cur[1];

        //         while(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc]!=1){
        //             nr+=dir[0];
        //             nc+=dir[1];
        //         }

        //         nr-=dir[0];
        //         nc-=dir[1];
        //         if(nr==destination[0] && nc==destination[1]) return true;

        //         if(maze[nr][nc]!=2)
        //             q.add(new int[]{nr,nc});
        //         maze[nr][nc]=2;
        //     }//for
        // }//while

        // return false;


        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] cur, int[] dest){
        //base
        if(cur[0]==dest[0] && cur[1]==dest[1]) return true;
        if(maze[cur[0]][cur[1]]==2) return false;
        //logic
        maze[cur[0]][cur[1]]=2;

        for(int[] dir: dirs){
                int nr=cur[0];
                int nc=cur[1];

                while(nr>=0 && nc>=0 && nr<maze.length && nc<maze[0].length && maze[nr][nc]!=1){
                    nr+=dir[0];
                    nc+=dir[1];
                }

                nr-=dir[0];
                nc-=dir[1];
                int[] ne= new int[]{nr,nc};

                if(dfs(maze, ne, dest)) return true;
        }
        return false;
    }
}