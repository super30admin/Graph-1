//Time complexity:O(m*n)
//Space Complexity:O(m*n)
#include<iostream>
#include<vector>
#include<queue>
using namespace std;
class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& dest) {
        vector<vector<int>> dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int m = maze.size(), n = maze[0].size();
        queue<vector<int>> q;
        q.push({start[0], start[1]});
        maze[start[0]][start[1]] = -1;
        while(!q.empty()) {
            vector<int> p = q.front(); 
            q.pop();
            for(auto& d : dirs){
                int a = p[0] + d[0];
                int b = p[1] + d[1];
                while(a >= 0 && b >= 0 && a < m && b < n && maze[a][b] != 1){
                    a += d[0];
                    b += d[1];
                }
                a -= d[0];
                b -= d[1];
                if(a == dest[0] && b == dest[1]) return true;
                if(maze[a][b] != -1){
                    q.push({a,b});
                    maze[a][b] = -1;
                }
            }
        }
        return false;
    }
};
