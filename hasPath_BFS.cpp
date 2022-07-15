// Time Complexity : O((m * n) * max(m, n)) 
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Perform BFS operation, change the direction only when the boundry or wall is hit.
 * To indicate visited cell, set its value to 2. 
 */

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {

        if (maze.size() == 0)
        {
            return false;
        }

        int m = maze.size();
        int n = maze[0].size();

        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue<vector<int>> q;

        maze[start[0]][start[1]] = 2;
        q.push({start[0], start[1]});

        while (!q.empty())
        {
            int currRow = q.front()[0];
            int currCol = q.front()[1];
            q.pop();

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

                if (i == destination[0] && j == destination[1])
                {
                    return true;
                }

                if (maze[i][j] == 0)
                {
                    maze[i][j] = 2;
                    q.push({i, j});
                }
            }
        }

        return false;
    }
};