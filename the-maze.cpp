//Time - O(mn)
//Space - O(mn)
class Solution {
public:
    bool hasPath(vector<vector<int>> maze, vector<int> start, vector<int> destination){
        if(maze.size() == 0) return false;
        
        queue<pair<int,int>> q;
        q.push(make_pair(start[0],start[1]));
        maze[start[0]][start[1]] = 2;
        vector<vector<int>> dirs {{0,1},{1,0},{0,-1},{-1,0}};
        
        while(!q.empty()){
            int curri = q.front().first;
            int currj = q.front().second;
            q.pop();
            if(curri == destination[0] && currj == destination[1]) return true;
            for(auto d:dirs){
                int i = curri, j = currj;
                while(i>=0 && i<m && j>=0 && j<n && maze[i][j]==0){
                    i = i + d[0];
                    j = j + d[1];
                }
                i = i - d[0];
                j = j - d[1];
                if(maze[i][j] == 0){
                    q.push(make_pair(i,j));
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}