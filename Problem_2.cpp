//Time:O(mn)
//Space:O(mn)

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size();
        int n = maze[0].size();
        int dir[] = {0,1,0,-1,0};
        queue<vector<int>> q;
        q.push(start);
        maze[start[0]][start[1]] = -1;
        while(!q.empty()){
            vector<int> temp = q.front();
            q.pop();
            for(int i=0; i<4; i++){
                int r = temp[0];
                int c = temp[1];
                while(r + dir[i] >= 0 && r + dir[i] < m && c + dir[i + 1] >= 0 && c + dir[i + 1] < n && maze[r + dir[i]][c + dir[i + 1]] <= 0){
                    r+=dir[i];
                    c+=dir[i+1];
                }
                if (r == destination[0] && c == destination[1]) {
                    return true;
                }
                if(!maze[r][c]){
                    maze[r][c] = -1;
                    q.push({r,c});
                }
            }
        }
        return false;
    }
};