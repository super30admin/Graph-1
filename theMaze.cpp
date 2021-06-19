// Time Complexity :O(nm) where n is the length of the string s 
// Space Complexity : O(mn) //Size in queue   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        queue<pair<int,int>> q;
        int m = maze.size();
        int n = maze[0].size();
        q.push({start[0],start[1]});
        maze[start[0]][start[1]] = 2;
        pair<int,int> curr;
        int dirs[4][2] = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.empty()){
            curr = q.front();
            q.pop();
            for(auto dir : dirs){
                int i = curr.first;
                int j = curr.second;
                while(i >=0 && i < m && j>=0 && j<n && maze[i][j] != 1){
                    i = i+dir[0];
                    j = j+dir[1];
                }
                i-=dir[0];
                j-=dir[1];
                if(i == destination[0] && j == destination[1]) return true;
                if(maze[i][j] != 2){
                    q.push({i,j});
                    maze[i][j] =2;
                }
            }
        }
        return false;
    }
};