/*
Intuition: We can consider this as a connceted component problem. This can be solved via bfs or dfs

The only difference is that we will be going till the ball hits any of the walls

Time Complexity: O(M*N)
Space Complexity: O(M*N)
*/

//BFS
class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        queue<pair<int,int>> queue;
        queue.push({start[0], start[1]});
        int rows = maze.size();
        int cols = maze[0].size();
        vector<vector<int>> dirs;
        maze[start[0]][start[1]] = 2;
        dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while ( queue.size() != 0){
            auto currIJ = queue.front();
            queue.pop();
            
            for ( auto dir: dirs){
                int i = currIJ.first;
                int j = currIJ.second;
                while ( i >=0 and i < rows and j >= 0 and j < cols and maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];   
                if ( i == destination[0] and j == destination[1]) return true;
                if ( maze[i][j] != 2){
                    maze[i][j] = 2;
                    cout<<i<<" "<<j<<endl;
                    queue.push({i, j});
                }
            }
        }
        return false;
    }
};
//DFS
class Solution {
public:
    vector<vector<int>> dirs;
    int rows, cols;
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        rows = maze.size();
        cols = maze[0].size();
        dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        return dfs(maze, start[0], start[1], destination);
    }
    bool dfs(vector<vector<int>>& maze, int r, int c, vector<int>& destination){
        if ( r == destination[0] and c == destination[1]) return true;
        if ( maze[r][c] == 2) return false;

        maze[r][c] = 2;
        for ( auto dir: dirs){
            int i = r;
            int j = c;
            while ( i >=0 and i < rows and j >= 0 and j < cols and maze[i][j] != 1){
                i += dir[0];
                j += dir[1];
            }
            i -= dir[0];
            j -= dir[1];   
            if(dfs(maze, i, j, destination)) return true;
        }
        return false;

    }

};