// Time Complexity : O(m*n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Almost. Some tests are failing
// Any problem you faced while coding this -

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        
        // Maze dimensions
        int m = maze.size();
        int n = maze[0].size();
        
        // Directions
        vector<pair<int, int>> dirs;
        dirs.push_back({-1,0});
        dirs.push_back({1,0});
        dirs.push_back({0,-1});
        dirs.push_back({0,1});
        
        // Queue for BFS
        queue<pair<int, int>> q;
        
        // Starting point
        q.push({start[0], start[1]});
        int i, r, c;
        pair<int, int> temp;
        
        // Continue until all points visited
        while(!q.empty())
        {
            temp = q.front();
            q.pop();

            // Mark as visited   
            maze[temp.first][temp.second] = 2;
            
            // Add neighbors to queue
            for(i = 0; i < 3; i++)
            {
                r = temp.first + dirs[i].first;
                c = temp.second + dirs[i].second;

                // Check if correct coordinates 
                if(r >= 0 && r < m && c >= 0 && c < n)
                {
                    // Check if destination reached
                    if(r == destination[0] && c == destination[1])
                    {
                        return true;
                    }

                    // Add the possible neighbors                
                    if(maze[r][c] == 0)
                    {
                        q.push({r,c});
                    }
                }
            }
        }

        return false;        
    }
};