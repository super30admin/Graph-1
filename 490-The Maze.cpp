/*
BFS Solution
TC = O((m+n)(mn))
SC = O(mn)
where m is the number of rows and n is the number of coloumns.
*/
class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int m = maze.size();
        int n = maze[0].size();
        queue<vector<int>> q;
        maze[start[0]][start[1]]=2;
        q.push(start);
        vector<vector<int>> dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.empty())
        {
            vector<int> point(q.front());
            maze[point[0]][point[1]]=2;
            q.pop();
            for(int i=0;i<dir.size();i++)
            {
                int r = point[0];
                int c = point[1];
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
                {
                    r = r + dir[i][0];
                    c = c + dir[i][1];
                }
                r = r - dir[i][0];
                c = c - dir[i][1];
                if(r==destination[0] && c== destination[1])
                    return true;
                if(maze[r][c]!=2)
                {
                    maze[r][c]=2;
                    vector<int> point2{r,c};
                    q.push(point2);
                }
            }
        }
        return false;
    }
};

/*
DFS Solution
TC = O((m+n)(mn))
SC = O(h)
where m is the number of rows and n is the number of coloumns.
where h is the height of the tree.
That is how far we can traverse in one direction until one of the base case is hit.
*/
class Solution {
public:
    vector<vector<int>> dir;
    int m,n;
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        m = maze.size();
        n = maze[0].size();
        dir = {{0,1},{0,-1},{1,0},{-1,0}};
        return dfs(maze,start[0],start[1],destination);
    }
    bool dfs(vector<vector<int>> &maze, int row, int col, vector<int> &destination)
    {
        //base
        if(row==destination[0] && col==destination[1])
            return true;
        
        //logic
        maze[row][col]=2;
        for(auto d :dir)
            {
                int r = row;
                int c = col;
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
                {
                    r = r + d[0];
                    c = c + d[1];
                }
                r = r - d[0];
                c = c - d[1];
                if(maze[r][c]!=2 && dfs(maze,r,c,destination))
                    return true;
            }
        return false;
    }
};
