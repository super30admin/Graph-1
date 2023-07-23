# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)


/*
time complexity - O(n)
Space comnplexity - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No
Code-
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        
        int indeg[n];
        for(int i=0;i<n;i++){
indeg[i]=0;
        }

        for(int i=0;i<trust.size();i++){
            indeg[trust[i][0]-1]--;
             indeg[trust[i][1]-1]++;
        }

          for(int i=0;i<n;i++){
if(indeg[i]==n-1){
    return i+1;
}
          }


        return -1;
    }
};

*/
## Problem2 The Maze (https://leetcode.com/problems/the-maze/)


/*
time complexity - O(m*n)
Space comnplexity - O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No
class Solution {
public:

bool isValid(int x,int y,vector<vector<int>>& maze){

    if(x>=0 && y>=0 && x<maze.size() && y<maze[0].size()){
        return true;
    }
    return false;
}
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        
        queue<pair<int,int>> myqueue;
        myqueue.push(make_pair(start[0],start[1]));
        int dirs[4][2] = {{0,-1},{-1,0},{0,1},{1,0}};
 maze[start[0]][start[1]]=2;
    while(!myqueue.empty()) {
pair<int,int> mypair = myqueue.front();
for(int i=0;i<4;i++){
    int x_element = mypair.first;
    int y_element = mypair.second;
while(isValid(x_element+dirs[i][0],y_element+dirs[i][1],maze) && maze[x_element+dirs[i][0]][y_element+dirs[i][1]]!=1 ){
x_element+=dirs[i][0];
y_element+=dirs[i][1];
}

if(x_element==destination[0] && y_element==destination[1]){
    return true;
}

if(maze[x_element][y_element]!=2){
    myqueue.push(make_pair(x_element,y_element));
    maze[x_element][y_element]=2;
}

}

myqueue.pop();
    }   

    return false;
    }
};
*/