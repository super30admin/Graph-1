

// Approach 1: BFS

// Time Complexity : O((m*n)*(m+n))
// Space Complexity : O(m*n) (it would be much less than this)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size();
        int n = maze[0].size();
        vector<vector<int>>dirs = {{-1,0},{1,0},{0,-1},{0,1}};// L R U D
        queue<pair<int,int>>q;
        q.push({start[0],start[1]});
        while(!q.empty())
        {
            int sz = q.size();
            while(sz--)
            {
                auto p = q.front();q.pop();
                if(p.first == destination[0] && p.second == destination[1]) return true;
                for(auto & dir: dirs){
                    int r = p.first;
                    int c = p.second;
                    while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1){
                        r = r + dir[0];
                        c = c + dir[1];
                    }
                    r = r - dir[0];
                    c = c - dir[1];
                    if(maze[r][c]==0){
                        maze[r][c] = 2;
                        q.push({r,c});
                    }
                }
            }
            
        }
        return false;
    }
};




// Approach 1: DFS

// Time Complexity : O((m*n)*(m+n))
// Space Complexity : O(m*n) (it would be much less than this)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int m = 0,n = 0;
    vector<vector<int>>dirs;
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        m = maze.size();
        n = maze[0].size();
        dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // L R U D
        if(dfs(maze,start[0],start[1],destination))
        {
            return true;
        }
        return false;
    }
    bool dfs(vector<vector<int>>& maze, int row,int col, vector<int>& destination)
    {
        if(row == destination[0] && col == destination[1]) return true;
        
        maze[row][col] = 2;
        for(auto & dir: dirs)
        {
            int r = row;
            int c = col;
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
            {
                r = r + dir[0];
                c = c + dir[1];
            }
            r = r - dir[0];
            c = c - dir[1];
            if(maze[r][c] == 0){
                if(dfs(maze,r,c,destination)) return true;
            }
        }
        return false;
    }
};