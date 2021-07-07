//Time Complexity-O(m*n)-->'m' is number of rows and 'n' is number of columns
//Space Complexity-O(m*n)-->size of queue in worst case
//Did the code execute on Leetcode? Yes

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination)     {
        vector<vector<int>>dir={{0,1},{0,-1},{1,0},{-1,0}};
        queue<vector<int>>m;
        m.push(start);
        while(!m.empty())
        {
            vector<int>k=m.front();
            m.pop();
            if(k[0]==destination[0] && k[1]==destination[1])
            {
                return true;
            }
            maze[k[0]][k[1]]=2;
            for(int i=0;i<dir.size();i++)
            {
                int row=k[0];
                int col=k[1];
                while(row>=0 && row<maze.size()&& col>=0 && col<maze[0].size()&&(maze[row][col]==0 || maze[row][col]==2))
                {
                    row+=dir[i][0];
                    col+=dir[i][1];
                }
                row-=dir[i][0];
                col-=dir[i][1];
                if(maze[row][col]!=2)
                {
                    m.push({row,col});
                }
            }
        }
        return false;
    }
    
};