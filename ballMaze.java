// Time Complexity : O(V): where V is the total number of nodes which is M*N. Generic template for graph algo is O(V+E). Here, edges (E) is constant for eah node which is 4.
// Space Complexity : O(V) which is O(M*N) for boolean array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//can use both bfs/dfs here. HAve used BFS here
//main change is how physics works in this problem.
//see the attached file for description

class Solution {

    
    //arrays to traverse the matrix
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        //base check
        if(maze == null) return false; //ask interviewer
        
        //initialize array for visited
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        //initialize the queue
        Queue<Point> q = new LinkedList<>();
        
        //initialize the start node as visited and put it inside the queue
        visited[start[0]][start[1]] = true;
        q.add(new Point(start[0], start[1]));
        
        while(!q.isEmpty()){
            
            //pop element from q to process
            Point current = q.poll();
            
            //if the popped element is 
            if(current.x == destination[0] && current.y == destination[1]){
                return true;
            }
        
            //else process the node
        //time to traverse the matrix
        for(int k=0; k<4; k++){
            int x = current.x + dx[k];
            int y = current.y + dy[k];
            
        //we keep on moving until we hit a wall (1 or matrix edge)
        while(isValid(maze, x, y) && maze[x][y] != 1){
                x += dx[k];
                y += dy[k];
            }
            
            //since we increment our x by every valid step, we need to decrement 1 step when we hit a wall
            x -= dx[k];
            y -= dy[k];
            
            //check is not visited then mark it visit and then add to queue
            if(!visited[x][y]){
                visited[x][y] = true;
                q.add(new Point(x,y));
            }
        }
         
        }

       return false; 
        
    }
    
    private boolean isValid(int[][] maze, int x, int y){
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}

class Point{
    int x, y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;  
    }
    
}