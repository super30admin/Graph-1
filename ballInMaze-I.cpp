// BFS
// Time Complexity : O(mn) worst case, we'll visit all elements of matrix
// Space Complexity : O(min(m,n)) diagonal of matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Standard BFS traversal, only deviation is while adding children to queue, don't just add next in each direction
// 2. For each direction, go either till boundary of matrix or till we reach an obstacle, then retract by one step
// 3. While adding children to queue if destination is reached, return true

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(!maze.size())
            return false;
        int m=maze.size(), n=maze[0].size();
        queue<vector<int>> q;
        q.push(start);
        vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.empty()){
            auto curr = q.front(); q.pop();
            maze[curr[0]][curr[1]] = 2;
            int r=curr[0], c=curr[1];
            for(auto dir: dirs){
                curr[0]=r; curr[1]=c;
                while(curr[0]>=0 && curr[0]<m && curr[1]>=0 && curr[1]<n && 
                      maze[curr[0]][curr[1]] != 1){
                    curr[0]+=dir[0];
                    curr[1]+=dir[1];
                }
                // it'll be on a violating block now, so take one step back
                curr[0]-=dir[0];
                curr[1]-=dir[1];
                // if landed on visited, take diff direction
                if(maze[curr[0]][curr[1]] == 2)
                    continue;
                // check while pushing if its destination
                if(curr == destination)
                    return true;
                q.push({curr[0],curr[1]});
            }
        }
        return false;
    }
};