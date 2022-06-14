/* 
    Time Complexity                              :  O(M*N) if the are no obstacles, traverse the entire 2d array.
    Space Complexity                             :  O(M*N) - used by the visited array in both the cases.
                                                    O(N) ~ Stack and Queue size. Will be less than O(N) since the co-ordinates stored in the queue are the co-ordinates where the direction changes.
                                                    The direction changes when the ball hits the wall or an obstruction. The wall will not reduce the space complexity but the
                                                    obstruction will since we cannot push it to the queue. Similarly for DFS and stack based approach.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/the-maze/


class Solution {
private:
    vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        return hPathDFS(maze, start, destination);
        return hPathBFS(maze, start, destination);
    }
     
    // iterative BFS
    bool hPathBFS(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size();
        int n = maze[0].size();
        
        queue<vector<int>> q;
        q.push(start);
        
        vector<vector<bool>> visited(m,vector<bool>(n,false));
        visited[start[0]][start[1]] = true;
        while(!q.empty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                auto t = q.front();q.pop();
                if(t == destination) {
                    return true;
                }
                
                int ci = t[0];
                int cj = t[1];

                for(auto dir : dirs) {
                    int ni = ci + dir[0];
                    int nj = cj + dir[1];

                    while(ni >= 0 and ni < m and nj >= 0 and nj < n and maze[ni][nj] == 0) {
                        ni += dir[0];
                        nj += dir[1];
                    }

                    ni -= dir[0];
                    nj -= dir[1];

                    if(ni == destination[0] and nj == destination[1]) {
                        return true;
                    }

                    if(visited[ni][nj] == false) {
                        visited[ni][nj] = true;
                        q.push({ni,nj});
                    }
                }
            }
        }
        
        
        return false;
    }
    
    
    // iterative DFS
    bool hPathDFS(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size();
        int n = maze[0].size();
        
        stack<vector<int>> st;
        st.push(start);
        
        vector<vector<bool>> visited(m,vector<bool>(n,false));
        visited[start[0]][start[1]] = true;
        while(!st.empty()) {
                auto t = st.top();st.pop();
                if(t == destination) {
                    return true;
                }
                
                int ci = t[0];
                int cj = t[1];

                for(auto dir : dirs) {
                    int ni = ci + dir[0];
                    int nj = cj + dir[1];

                    while(ni >= 0 and ni < m and nj >= 0 and nj < n and maze[ni][nj] == 0) {
                        ni += dir[0];
                        nj += dir[1];
                    }

                    ni -= dir[0];
                    nj -= dir[1];

                    if(ni == destination[0] and nj == destination[1]) {
                        return true;
                    }

                    if(visited[ni][nj] == false) {
                        visited[ni][nj] = true;
                        st.push({ni,nj});
                    }
                }   
        }
        return false;
    }
};