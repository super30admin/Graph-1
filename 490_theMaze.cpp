// Time Complexity : O(MN(M+N))
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(maze.empty() || maze.size() == 0)
            return false;
        int m = maze.size();
        int n = maze[0].size();
        queue<vector<int>> q;
        q.push({start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        vector<vector<int>> dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!q.empty()){
            vector<int> curr = q.front();
            q.pop();
            for(vector<int> dir : dirs){
                int row = curr[0]+dir[0];
                int col = curr[1]+dir[1];
                while(row>=0 && row<m && col>=0 && col<n && maze[row][col] != 1){
                    row += dir[0];
                    col += dir[1];
                }
                row = row - dir[0];
                col = col - dir[1];
                if(row == destination[0] && col == destination[1])
                    return true;
                if(maze[row][col] != 2){
                    q.push({row, col});
                    maze[row][col] = 2;
                }
            }
        }
        return false;
    }
};



// Time Complexity : O(MN(M+N))
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    vector<vector<int>> dir;
    int m,n;
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        m = maze.size();
        n = maze[0].size();
        dir = {{0,1},{0,-1},{1,0},{-1,0}};
        return dfs(maze,start[0],start[1],destination);
    }
    bool dfs(vector<vector<int>> &maze, int row, int col, vector<int> &destination)
    {
        //base
        if(row==destination[0] && col==destination[1])
            return true;
        
        //logic
        maze[row][col]=2;
        for(auto d :dir)
            {
                int r = row;
                int c = col;
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
                {
                    r = r + d[0];
                    c = c + d[1];
                }
                r = r - d[0];
                c = c - d[1];
                if(maze[r][c]!=2 && dfs(maze,r,c,destination))
                    return true;
            }
        return false;
    }
};
