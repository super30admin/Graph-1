Class Solution{
    public bool haspath(vector<vector<int>> maze, vector<int> start, vector<int> destination){
        int row = maze.size();
        int column = maze[0].size();

        // initialize queue for bfs
        queue<vector> bfs;
        bfs.push(start) ; 
        maze[start[0], start[1]] = 2;// mark as visited

        vector<vector<int>> dirs{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up , down , left , right

        while(!bfs.empty()){
            vect<current> = bfs.pop() ; 
            for (int i = 0; i < dirs.size(); i++)
            {
                int r = current[0] ; 
                int c = current[1] ; 
                while (r >= 0 && r < row && c >= 0 && c < column && maze[r][c] != 1)
                {
                    int r = r + dirs[i][0] ; 
                    int c = c + dirs[i][1] ; 
                }

                r = r - dirs[i][0] ; 
                c = c - dirs[i][1] ; 
                if(maze[r][c] != 2){
                    if(r == destination[0] && c == destination[1]){
                        return true ; 
                    }

                    maze[r][c] == 2 ; 
                    vect<int> temp {r,c} ; 
                    bfs.push(temp) ; 
                }
                
            }

        }

        return false ; 
    }
};
