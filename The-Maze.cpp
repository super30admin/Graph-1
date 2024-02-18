// Time Complexity : O(M*N)

// Space Complexity : O(M*N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS - using a queue.

// 490. The Maze

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size();
        int n = maze[0].size();
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        queue<pair<int,int>> q;
        q.push({start[0],start[1]});
        maze[start[0]][start[1]] = 2;
        while(!q.empty()){
            auto curr = q.front();
            q.pop();
            for(auto dir : dirs){
                int r = curr.first;
                int c = curr.second;
                while(r < m && r >=0 && c < n && c >= 0 && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                // step back
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] != 2){
                    q.push({r,c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
};