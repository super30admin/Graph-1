// Time Complexity : O((m * n) * max(m, n)) 
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Perform DFS operation, change the direction only when the boundry or wall is hit.
 * To indicate visited cell, set its value to 2. 
 */

class Solution {
public:
    vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;  
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        
        if (maze.size() == 0)
        {
            return false;
        }
        
        m = maze.size();
        n = maze[0].size();
                
        return dfs(maze, start[0], start[1], destination);
    }
    
    bool dfs(vector<vector<int>>& maze, int& currRow, int& currCol, vector<int>& destination)
    {
        
        // base case
        
        if (currRow == destination[0] && currCol == destination[1])
        {
            return true;
        }
        
        if (maze[currRow][currCol] == 2)
        {
            return false;
        }

        // Logic
        
        maze[currRow][currCol] = 2;
        
        for (const auto& dir : dirs)
        {
            int i = currRow;
            int j = currCol;
                
            while (i < m && i >= 0 && j < n && j >= 0 && maze[i][j] != 1)
            {
                i += dir[0];
                j += dir[1];
            }
            
            i -= dir[0];
            j -= dir[1];
                                
            if (maze[i][j] == 0 && dfs(maze, i, j, destination))
            {
                return true;
            }
        }
        
        return false;
    }
};