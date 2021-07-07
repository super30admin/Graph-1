//Time Complexity-O(m*n)-->'m' is number of rows and 'n' is number of columns
//Space Complexity-O(1)
//Did the code execute on Leetcode? yes

class Solution {
public:
    bool a=0;
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination)     {
        int x=start[0];
        int y=start[1];
        dfs(maze,x,y,destination);
        if(a==0)
        {
            return false;
        }
        else
        {
            return true;
        }    
    }
    vector<vector<int>>dir={{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(vector<vector<int>>& maze,int x,int y, vector<int>& destination)
    {
        if(x==destination[0] && y==destination[1])
        {
            a=1;
            return;
        }
        maze[x][y]=2;
        for(int i=0;i<dir.size();i++)
        {
            int row=x;
            int col=y;
            while(row>=0 && row<maze.size() && col>=0 && col<maze[0].size() && (maze[row][col]==0||maze[row][col]==2))
            {
                row+=dir[i][0];
                col+=dir[i][1];
            }
            row-=dir[i][0];
            col-=dir[i][1];
            if(maze[row][col]!=2)
            {
                dfs(maze,row,col,destination);
            }
        }
    }
};