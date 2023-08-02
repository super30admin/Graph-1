// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

#include <vector>
#include <queue>
  
using namespace std;

class Solution {
public:
    bool hasPath(std::vector<std::vector<int>>& maze, std::vector<int>& start, std::vector<int>& destination) {
        int m = maze.size();
        int n = maze[0].size();

        std::queue<std::vector<int>> q;
        std::vector<std::vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        q.push(start);
        maze[start[0]][start[1]] = 2;

        while (!q.empty()) {
            std::vector<int> top = q.front();
            q.pop();

            int r = top[0];
            int c = top[1];

            if (r == destination[0] && c == destination[1]) {
                return true;
            }

            for (const auto& dir : dirs) {
                int i = r;
                int j = c;

                // Keep the ball rolling
                while (i >= 0 && j >= 0 && i < m && j < n && (maze[i][j] == 0 || maze[i][j] == 2)) {
                    i += dir[0];
                    j += dir[1];
                }

                // bring back to stop point
                i -= dir[0];
                j -= dir[1];

                if (maze[i][j] != 2) {
                    q.push({i, j});
                    maze[i][j] = 2;
                }
            }
        }

        return false;
    }
};
