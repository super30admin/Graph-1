producing wrong result, cant find the error

class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        vector<vector<bool>>visited(maze.size(),vector<bool>(maze[0].size()));
        return dfs(maze,start,destination,visited);
    }
    bool dfs(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination, vector<vector<bool>>& visited)
    {
        if(visited[start[0]][start[1]])
            return false;
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        visited[start[0]][start[1]]=true;
        int r=start[1]+1;
        int l=start[1]-1;
        int u=start[0]-1;
        int d=start[0]+1;
        while(r<maze[0].size() && maze[start[0]][r]==0)
            r++;
        start={start[0],r-1};
        if(dfs(maze,start,destination,visited))
            return true;
        while(l>=0 && maze[start[0]][l]==0)
            l--;
        start={start[0],l+1};
        if(dfs(maze,start,destination,visited))
            return true;
        while(u>=0 && maze[u][start[1]]==0)
            u--;
        start={u+1,start[1]};
        if(dfs(maze,start,destination,visited))
            return true;
        while(d<maze.size() && maze[d][start[1]]==0)
            d++;
        start={d-1,start[1]};
        if(dfs(maze,start,destination,visited))
            return true;
        return false;
    }
};