class Solution {
public:
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        deque<vector<int>> st; 
        vector<vector<int>> visited(maze.size(), vector<int>(maze[0].size(), false));

        st.push_back(start);

        while(!st.empty()) {
            vector<int> co = st.back(); 
            st.pop_back(); 

            if(co[0] == destination[0] && co[1] == destination[1]) return true; 

            int new_row = co[0];

            //down
            while(new_row < maze.size() && maze[new_row][co[1]] == 0) new_row++;
            new_row--;

            if(!visited[new_row][co[1]]) {
                visited[new_row][co[1]] = true; 
                st.push_back({new_row, co[1]}); 
            }
            
            new_row = co[0];
            //up
            while(new_row >= 0 && maze[new_row][co[1]] == 0) new_row--;
            new_row++; 

            if(!visited[new_row][co[1]]) {
                visited[new_row][co[1]] = true; 
                st.push_back({new_row, co[1]}); 
            }


            int new_col = co[1];
            //right
            while(new_col < maze[0].size() && maze[co[0]][new_col] == 0) new_col++;
            new_col--; 

            if(!visited[co[0]][new_col]) {
                visited[co[0]][new_col] = true; 
                st.push_back({co[0], new_col});      
            }
            
            new_col = co[1];
            //left
            while(new_col >= 0 && maze[co[0]][new_col] == 0) new_col--;
            new_col++; 

            if(!visited[co[0]][new_col]) {
                visited[co[0]][new_col] = true; 
                st.push_back({co[0], new_col});      
            }

        }

        return false;        
    }
};