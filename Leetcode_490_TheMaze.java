//this is the premium problem
//approach -1 BFS - not optimized!
//we are given start position, destination position , start[0] is row and start[1] = col
//initialize, queue of int[] and start position to it - new int[] {start[0], start[1]}
// now we will mark position start as -1, so we will never come back and traverse all four direction for it. 
//For directions - T, D, L, R we will take dirs array
//we go into while loop, poll the curr element to traverse. 
//extract it's index in r and c. 
//go to the dirs array, and one by one evalualte all four directions. 
//inside dirs array , we'll assign r and c to new i and j. 
    //go into the loop and check for the bounds, if that coordinates are in bound then , we traverse through the direction
    //till the wall hits and for that we just add the i+dir[0] and j+ dir[1]  will lead us to the end of the wall . 

    //once we come out of the while loop , we have already advanced i and j , so we will do i = i-dir[0] && j= j-dir[1]
    //now we will check mark them as visited  == -1
    //add them to queue. 


    //TC - O(m*n)K; here K  = Max(m,n) ; k represents direction traversal for all the elements needed. 
    //SC - O(m*n) - we are using queue. 

public class Solution{

    public boolean findDestination(int[][] maze, int[] start, int[] destiation)
    {
        if(maze == null || maze.length ==0) return false;
        if(start[0] >= m || start[1] >=n || start[0] <0  || start[1] < 0 ) return false;
        if(destiation[0] >= m || destiation[1] >=n || destiation[0] <0  || destiation[1] < 0 ) return false;

        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //T D L R

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]}); //we added the start index;

        maze[start[0]][start[1]] = -1; //mark as visited.

        //start BFS
        while(!q.isEmpty())
        {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int[] dir : dirs)
            {
                int i = r;
                int j = c;

                while( i >=0 && i<m && j>=0 && j<n && maze[i][j] != 1)
                {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                //we come here when we reach at the last pooint in that direction, and at the wall may be
                // so deduct the dir[0] and dir[1] to get to the position before wall/ 
                i = i-dir[0];
                j = j-dir[1];

                //check if those are the destination
                if(i == destination[0] && j == destination[1])
                {
                    return true;
                }
                maze[i][j] = -1;
                q.add(new int[]{i,j});
            }
        }
        return false;
    }
}


//approach -2
//DFS
//TC - Not exponential , for Recursive problem- like pre-order, post oreder all has DFS solution with TC of O(n) astouch each nodes. 
//same here, we touch mostly all locations, and so we says , it's O(m*n)
//sc - O(m*n) - recursive stack space  

public class Solution{
    int i , j, m, n;
    public boolean findDestination(int[][] maze, int[] start, int[] destiation)
    {
        if(maze == null || maze.length ==0) return false;
        if(start[0] >= m || start[1] >=n || start[0] <0  || start[1] < 0 ) return false;
        if(destiation[0] >= m || destiation[1] >=n || destiation[0] <0  || destiation[1] < 0 ) return false;

        m = maze.length;
        n = maze[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //T D L R
        i = destination[0];
        j = destination[1];

        return helper(maze, start[0], start[1]);
    }

    private boolean helper(int[][] maze, int r, int c)
    {
        //base case
        if( r== i && c == j) return true;

        //logic
        maze[r][c] = -1;

        for(int[] dir : dirs)
        {
            int p = r + dir[0];
            int q = c + dir[1];
            while(p>=0 && p<m && q >=0 && q < n && maze[p][q] != 1)
            {
                p = p+dir[0];
                q = q + dir[1];
            }
            //return helper(maze, p - dir[0], q - dir[1]);
            if(maze[p-dir[0]][q - dir[1]] != 1 && helper(maze, p - dir[0] ,q - dir[1]))
            {
                return true;
            }
        }
    }
}