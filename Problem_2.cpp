/**
 * @Time Complexity:
 * BFS: O(mn)
 * DFS: O(mn)
 */

/**
 * @Space complexity:
 * BFS: O(mn)
 * DFS: O(mn)
 * 
 */

/**
 * @Approach:
 * 
 * We can use both BFS and DFS
 * BFS:
 * We start with starting point in the queue and start exploring
 * all the directions while doing the bound check and wall check.
 * We do the wall check because if the ball starts moving in 
 * one direction, it does not stop until it reaches the wall.
 * 
 * Then we need to step back too becasue while calculating
 * new r and c values the while loop will end at the wall and
 * not before the wall that is the values of r and c will be
 * equivalen to the r and c values of the wall. So, we have to
 * come a step backward. Now we compare the r and c values with
 * the r and c values of the destination. If they are equal
 * we are at the destination. Otherwise we mark the cell
 *  as 2 if it was not marked as 2 earlier and store
 * the value sof r and c in queue.
 * 
 * DFS:
 * We use the same approach as in BFS. First explore all the directions
 * and then step back. Then for that values of r and c check if we reach
 * destination or not. If not then check if their value is equal to 2 or in other words
 * they have visited that earlier or not.
 */

//BFS
class Solution {
    

public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(maze.empty() || maze.size() == 0) return false;
        vector<vector<int>> dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = maze.size();
        int n = maze[0].size();
        if(start[0]== destination[0] && start[1]== destination[1]) return true;
        queue<vector<int>> q;
        q.push(start);
        while(!q.empty()){
            vector<int> curr = q.front();
            q.pop();
            for(vector<int> dir: dirs){
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] != 2){
                    maze[r][c] = 2;
                    q.push(vector<int> {r,c});
                }    
            }
        }
        return false;
    }
};



//DFS
class Solution {
    
    vector<vector<int>> dirs;
    int m,n;
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(maze.empty() || maze.size() == 0) return false;
        dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        m = maze.size();
        n = maze[0].size();
        
        return dfs(maze, start, destination);
    }
    
    private:
    
    bool dfs(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination){
        //base
        if(start[0]== destination[0] && start[1] == destination[1]) return true;
        if(maze[start[0]][start[1]] == 2) return false;
        maze[start[0]][start[1]] = 2;
        
        //logic
        for(auto dir: dirs){
            int r = start[0];
            int c = start[1];
            while(r >=0 & r <m && c >=0 && c <n && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];
            }
            
            r -= dir[0];
            c -= dir[1];
            vector<int> temp {r,c};
            if(dfs(maze, temp, destination)) return true;
        }
        return false;
    }
};