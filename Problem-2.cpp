// https://leetcode.com/problems/the-maze/description/
// Time Complexity: (m*n) 
// Space Complexity: (m*n)


// BFS

class Solution {
    public:
        bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
            int n = maze.size();
            int m = maze[0].size();
            queue<vector<int>> q;
            q.push({start[0], start[1]});
            maze[start[0]][start[1]] = 2;
            vector<pair<int,int>> dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};
            while(!q.empty()){
                vector<int> curr = q.front(); q.pop();
                for(auto dir : dirs){
                    int nr = curr[0], nc = curr[1];
                    while (nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] != 1) {
                        nr += dir.first;
                        nc += dir.second;
                    }
                    nr -= dir.first;
                    nc -= dir.second;
                    if(nr == destination[0] && nc == destination[1]) return true;
                    if (maze[nr][nc] == 0) {
                        q.push({nr, nc});
                        maze[nr][nc] = 2;  
                    }
                }    
            }
            return false;
        }
    };

// DFS
// Time Complexity: (m*n)
// Space Complexity: (m*n)

class Solution {
    public:
        bool dfs(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination, vector<pair<int,int>> &dirs, int n, int m){
            if(start[0] == destination[0] && start[1] == destination[1]) return true;
            if(maze[start[0]][start[1]] == 2) return false;
            maze[start[0]][start[1]] = 2;
            for(auto dir : dirs){
                int nr = start[0], nc = start[1];
                while (nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] != 1) {
                        nr += dir.first;
                        nc += dir.second;
                }
                nr -= dir.first;
                nc -= dir.second;
                vector<int> r = {nr, nc};
                if(dfs(maze, r, destination, dirs, n, m)) return true;         
            }  
            return false;  
    
        }
        bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
            int n = maze.size();
            int m = maze[0].size();
            vector<pair<int,int>> dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};
            return dfs(maze, start, destination, dirs, n, m);
        }
    };