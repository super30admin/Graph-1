//Time O(m * n)
//Space O(m * n)
//Leetcode: yes
//issue seen: none
class Solution {
public:
    int row[4] = {-1, 1, 0, 0};
    int col[4] = {0, 0, -1, 1};

    bool dfs(vector<vector<int>>& maze, int r, int c, vector<int>& dest,
             vector<vector<int>>& visited) {
        if (visited[r][c] == 1) {

            return false;
        }

        if ((r == dest[0]) && (c == dest[1])) {

            return true;
        }

        visited[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int new_r = r;
            int new_c = c;

            while (new_r >= 0 && new_r < maze.size() && new_c >= 0 &&
                   new_c < maze[0].size() && maze[new_r][new_c] == 0) {
                new_r += row[i];
                new_c += col[i];
            }

            new_r -= row[i];
            new_c -= col[i];
            if (dfs(maze, new_r, new_c, dest, visited)) {
                return true;
            }
        }
        return false;
    }
    bool hasPath(vector<vector<int>>& maze, vector<int>& start,
                 vector<int>& destination) {
        int i = start[0];
        int j = start[1];
        vector<vector<int>> visited(maze.size(),
                                    vector<int>(maze[0].size(), 0));
        return dfs(maze, i, j, destination, visited);
    }
};
