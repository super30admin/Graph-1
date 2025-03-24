// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
// Did this code successfully run on Leetcode : Yes

//Approach:
// 1. Create a queue to store the coordinates of the cells to be visited.
// 2. Create a visited vector to keep track of the visited cells.
// 3. Create a directions vector to store the possible directions to move.
// 4. Push the start cell into the queue and mark it as visited.
// 5. While the queue is not empty, pop the front cell and check if it is the destination cell.
// 6. If yes, return true.
// 7. Otherwise, iterate through the directions vector and keep moving in that direction until we hit a wall or the boundary.
// 8. If the cell is not visited, mark it as visited and push it into the queue.
// 9. If the destination cell is not reached, return false.

class Solution {
    public:
        bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
            int m = maze.size();
            int n = maze[0].size();
            queue<pair<int, int>> q;
            vector<vector<bool>> visited(m, vector<bool>(n, false));
    
            vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
            q.push({start[0], start[1]});
            visited[start[0]][start[1]] = true;
    
            while(!q.empty()){
                auto[x, y] = q.front();
                q.pop();
                
                if(x == destination[0] && y == destination[1]){
                    return true;
                }
    
                for(auto [dx, dy] : directions){
                    int newX = x, newY = y;
                    while(newX + dx >= 0 && newX + dx < m && 
                    newY + dy >= 0 && newY + dy < n && 
                    maze[newX + dx][newY + dy] == 0){
                        newX += dx;
                        newY += dy;
                    }
                     if(!visited[newX][newY]){
                        visited[newX][newY] = true;
                        q.push({newX, newY});
                     }
                }
            }
            return false;
        }
    };