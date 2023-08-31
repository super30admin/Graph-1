//time : O(m*n)
//space: O(m*n)

class Solution {
public:
    
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size(), n = maze[0].size();
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        queue<vector<int>> queue;
        vector<vector<bool>> visa(m, vector<bool>(n, false));
        queue.push(start);
        visa[start[0]][start[1]] = true;

        while (!queue.empty()) {
            vector<int> curr = queue.front();
            queue.pop();
            for (const auto& dir : dirs) {
                int r = curr[0];
                int c = curr[1];
                while (r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];

                if (visa[r][c])
                    continue;

                if (r == destination[0] && c == destination[1]) {
                    return true;
                }

                visa[r][c] = true;
                queue.push({r, c});
            }
        }

        return false;
        
    }
};

