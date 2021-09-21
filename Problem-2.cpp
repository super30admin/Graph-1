/*
BFS Solution
TC = O((m+n)(mn))
SC = O(mn)
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
