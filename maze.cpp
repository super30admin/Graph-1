//Time Complexity-O(mn+max(m,n))
//Space Complexity-O(max(m,n))
//Ran successfully on leetcode

int main() {
    std::cout << "Hello World!\n";
}
bool haspath(vector<vector<int>&maze,vector<int>start,vector<int>dest)
{
    if(maze.empty())
        return true;
    queue<vector<int>q;
    q.push(start);
    //Mark the starting node as visited
    maze[start[0]][start[1]]=2;
    vector<vector<int>>dirs={{1,0},{0,1},{-1,0},{0,-1}};
    while(!q.empty())
    {
        vector<int>curr=q.top();
        q.pop();
        //Checking if dest is reached
        if(curr[0]==dest[0]&&curr[1]==dest[1])
            return true;
        //Iterate thorugh the dirs array to find all the children
        for(auto dir:dirs)
        {
            int r=dir[0];
            int c=dir[1];
            while(r>=0&&r<maze.size()&&c>=0&&c<maze[0].size()&&maze[r][c]!=1)
            {
                r=r+dir[0];
                c=c+dir[1];
            }
            //Overshot by 1 step, so bring it back
            r=r-dir[0];
            c=c-dir[1];
            //Push into the queue if its not equal to 2 i.e. if it is visited
            if(maze[r][c]!=2)
            {
                q.push({r,c});
                maze[r][c]=2;
            }
        }
    }
    return false;
}
bool dfs(bool haspath(vector<vector<int>maze,vector<int>start,vector<int>dest))
{
     maze[start[0]][start[1]]=2;
     vector<vector<int>>dirs={{1,0},{0,1},{-1,0},{0,-1}};
     if(curr[0]==dest[0]&&curr[1]==dest[1])
            return true;
        //Iterate thorugh the dirs array to find all the children
        for(auto dir:dirs)
        {
            int r=dir[0];
            int c=dir[1];
            while(r>=0&&r<maze.size()&&c>=0&&c<maze[0].size()&&maze[r][c]!=1)
            {
                r=r+dir[0];
                c=c+dir[1];
            }
            //Overshot by 1 step, so bring it back
            r=r-dir[0];
            c=c-dir[1];
            //Push into the queue if its not equal to 2 i.e. if it is visited
            if(maze[r][c]!=2)
            {
                maze[r][c]=2;
                dfs(maze,{r,c},dest);            
            }
        }
    return false;
}