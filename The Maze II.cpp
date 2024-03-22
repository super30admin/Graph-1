/*
Time: O(m*n*4) 
Space: O(m*n*4)

Use 4 directional BSF, where state of BSF is {row, column, direction}
Find levels for all possible row-column-direction combination
For the destination row-column, for each direction, check if the ball can keep on rolling (don't take the level in that case)
or gets stuck (hits wall, take that level) 
*/

class Solution {
public:
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    int shortestDistance(vector<vector<int>> &maze, vector<int> &start, vector<int> &dest) {
        int r = maze.size(), c = maze[0].size();

        const int inf = 100000009;
        vector<vector<vector<int>>> level(r, vector<vector<int>>(c, vector<int>(4, inf)));

        queue<vector<int>> q;
        for(int i=0;i<4;i++){
            level[start[0]][start[1]][i] = 0;
            q.push({start[0],start[1],i});

            printf("%d-%d %d = %d\n",start[0],start[1],i,level[start[0]][start[1]][i]);
        }

        vector<vector<int>> dir = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.empty()){
            auto u = q.front();
            q.pop();

            int curr_r = u[0], curr_c = u[1], d = u[2];
            //if(curr_r == dest[0] && curr_c == dest[1])  return level[];

            printf("%d-%d %d = %d\n",curr_r,curr_c,d,level[curr_r][curr_c][d]);

            int nxt_r = curr_r + dir[d][0];
            int nxt_c = curr_c + dir[d][1];

            //not hit a wall
            if(nxt_r >= 0 && nxt_r < r && nxt_c >=0 && nxt_c < c && maze[nxt_r][nxt_c] == 0){
                if(level[curr_r][curr_c][d] + 1 < level[nxt_r][nxt_c][d]){
                    level[nxt_r][nxt_c][d] = level[curr_r][curr_c][d] + 1;
                    q.push({nxt_r,nxt_c,d});
                }
            } //hit a wall
            else{
                for(int i=0;i<4;i++){
                    nxt_r = curr_r + dir[i][0];
                    nxt_c = curr_c + dir[i][1];

                    //not hit a wall
                    if(nxt_r >= 0 && nxt_r < r && nxt_c >=0 && nxt_c < c && maze[nxt_r][nxt_c] == 0){
                        if(level[curr_r][curr_c][d] + 1 < level[nxt_r][nxt_c][i]){
                            level[nxt_r][nxt_c][i] = level[curr_r][curr_c][d] + 1;
                            q.push({nxt_r,nxt_c,i});
                        }
                    }
                }
            }
        }

        int ans = inf;
        for(int i=0;i<4;i++){
            int nxt_r = dest[0] + dir[i][0], nxt_c = dest[1] + dir[i][1];

            //if the ball continues rolling in that direction, it doesn't stay indestination!
            if(nxt_r >= 0 && nxt_r < r && nxt_c >=0 && nxt_c < c && maze[nxt_r][nxt_c] == 0)  continue;

            ans = min(ans, level[dest[0]][dest[1]][i]);
        }

        return ans == inf ? -1 : ans;
    }
};
