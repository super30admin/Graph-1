//BFS

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(maze.size()==0){
            return false;
        }
        queue<vector<int>> q;
        int m = maze.size();
        int n = maze[0].size();
        vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        q.push(start);
        maze[start[0]][start[1]] = 2;
        while(!q.empty()){
            vector<int> curr = q.front();
            q.pop();
            if(curr[0]==destination[0] && curr[1]==destination[1]){
                return true;
            }
            for(vector<int> dir : dirs){
                int i = curr[0];
                int j = curr[1];
                while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1){
                    i = i+dir[0];
                    j = j+dir[1];
                }
                i = i-dir[0];
                j = j-dir[1];
                if(maze[i][j]!=2){
                    q.push({i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
};

//DFS (same TC and SC as above)

class Solution {
    int m,n;
    vector<vector<int>> dirs;
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(maze.size()==0){
            return false;
        }
        dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        m = maze.size();
        n = maze[0].size();
        return dfs(maze, start, destination);
    }
    
    bool dfs(vector<vector<int>>& maze, vector<int> start, vector<int>& destination){
        //base
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        if(maze[start[0]][start[1]]==2){
            return false;
        }
        //logic
        
        maze[start[0]][start[1]] = 2;
        for(vector<int> dir: dirs){
            int i = start[0];
            int j = start[1];
            while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1){
                i = i+dir[0];
                j = j+dir[1];
            }
            i = i-dir[0];
            j = j-dir[1];
            if(maze[i][j]!=2){
                if(dfs(maze, {i,j}, destination)){
                    return true;
                }
            }
        }
        return false;
    }
};
