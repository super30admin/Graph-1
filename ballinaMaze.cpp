#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We keep rolling the ball in all directions until it hits a wall, starting from the current position.
Each time we land on a new stopping cell, we check if it's the destination and then DFS from there.
We mark visited cells as -1 to avoid revisiting the same paths again.
*/
class Solution{
    vector<vector<int>> dirs;
    int m, n;

    bool dfs(vector<vector<int>>& maze, int i, int j, vector<int>& destination){
        if(destination[0] == i && destination[1] == j) return true;
        if(maze[i][j] == -1) return false;

        maze[i][j] = -1;
        for(auto& dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];
            }

            r -= dir[0];
            c -= dir[1];

            if(dfs(maze, r, c, destination)) return true;
        }
        return false;
    }
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination){
        dirs = {{-1, 0}, {1,0}, {0,1}, {0, -1}};
        m = maze.size();
        n = maze[0].size();

        return dfs(maze, start[0], start[1], destination);
    }
};
