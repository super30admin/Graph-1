// Approach - BFS
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = maze.size();
        int n = maze[0].size();
        queue<vector<int>> q;
        q.push(start);
        maze[start[0]][start[1]] = 2;
        
        while(!q.empty()){
            vector<int> curr = q.front(); q.pop();
            for(vector<int> dir : dirs){
                int i = curr[0];
                int j = curr[1];
                while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];
                if(maze[i][j] != 2){
                    if(i == destination[0] && j == destination[1])
                        return true;
                    q.push({i, j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
};


// Approach - DFS
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
// Problems Faced - No!
// It runs on Leetcode!

class Solution {
    vector<vector<int>> dirs;
    private:
    bool dfs(vector<vector<int>>& maze, int i, int j, vector<int>& destination, int m, int n){
        // if(maze[i][j] == 2)    this doesn't work
        //     return true;
        if(i == destination[0] && j == destination[1])
            return true;
        maze[i][j] = 2;
        for(vector<int> dir : dirs){
            int r = i;
            int c = j;
            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];
            if(maze[r][c] != 2 && dfs(maze, r, c, destination, m, n))
                return true;
        }
        return false;
    }
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = maze.size();
        int n = maze[0].size();
        return dfs(maze, start[0], start[1], destination, m, n);
    }
};