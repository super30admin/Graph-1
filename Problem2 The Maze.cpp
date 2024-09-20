//tc: (m*n) ((m+n)) - for each border cell we can traverse (m-1 * n-1) cells so exact tc will be [(m-1)*(n-1) * (4 * (m+n))]
//sc: m+n
class Solution {
public:
    vector<vector<int>> dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    bool dfs(vector<vector<int>>& maze, vector<vector<int>> &visited, int row, int col, int destRow, int destCol) {
        if (visited[row][col]) return false;
        if(row == destRow && col == destCol) return true;
        visited[row][col] = 1;
        for(auto &d : dirs) {
            int newRow = row;
            int newCol = col;
            while (newRow + d[0] >= 0 && newRow + d[0] < maze.size() && newCol + d[1] >= 0 && newCol + d[1] < maze[0].size() && maze[newRow + d[0]][newCol + d[1]] == 0) {
                newRow += d[0];
                newCol += d[1];
            }
            if(dfs(maze, visited, newRow, newCol, destRow, destCol)) return true;
        }
        return false;
    }
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& dest) {
        int rows = maze.size();
        int cols = maze[0].size();
        if(rows == 0) return false;
        vector<vector<int>> visited(rows, vector<int>(cols, 0));
        return dfs(maze, visited, start[0], start[1], dest[0], dest[1]);
    }
};