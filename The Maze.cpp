//time: O(m*n)
//space: O(m*n)
class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        int m = maze.size();
        int n = maze[0].size();
        queue<vector<int>> q;
        vector<vector<int>> dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}}; // right, down, up, left
        q.push(start);
        maze[start[0]][start[1]] = -1;
        while(!q.empty()) {
            vector<int> curr = q.front();
            q.pop();
            for(auto dir : dirs) {
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1]) {
                    return true;
                }
                if(maze[r][c] != -1) {
                    q.push({r,c});
                    maze[r][c] = -1;
                }
            }
        }
        return false;
    }
};