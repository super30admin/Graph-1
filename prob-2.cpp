//t-c: (m*n)*(m+n)
//s-c: m+n
class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        vector<vector<int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        queue<int> q;
        q.push(start[0]);
        q.push(start[1]);
        maze[start[0]][start[1]] = -1;
        int row, col, r, c;
        while(!q.empty()){
            row = q.front();
            q.pop();
            col = q.front();
            q.pop();
            for(auto dir: dirs){
                r = row;
                c = col;
                while(r >= 0 && r < maze.size() && c >= 0 && c < maze[0].size() && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1]){
                        return true;
                }
                if(maze[r][c] != -1){
                    q.push(r);
                    q.push(c);
                    maze[r][c] = -1;
                }
            }
        }
        return false;
        
    }
};
