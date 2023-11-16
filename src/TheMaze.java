// ******************** DFS approach ********************

// // Time Complexity:  O(m*n)
// // Space Complexity: O(m*n)


class Solution {

    Queue<int[]> queue;
    int[][] dir = new int[][] {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    int m, n;
  
    public static void main(String[] args) {
        int[][] maze = new int[][] {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        int[] start = new int[] {0, 4};
        int[] destination = new int[] {4, 4};
        Solution obj = new Solution();
        System.out.println(obj.hasPath(maze, start, destination));
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        m = maze.length;
        n = maze[0].length;
        
        return dfs(maze, start[0], start[1], destination);
        
    }
    
    private boolean dfs(int[][] maze, int i, int j, int[] destination) {
        
        if(i == destination[0] && j == destination[1]) return true;                 // if found destination
        maze[i][j] = 2;                                                             // make node visited
        
        for(int[] d : dir) {
            
            int x = i;
            int y = j;
            
            while(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1) {                    // if possible continue
                x += d[0];
                y += d[1];
            }    
            x -= d[0];
            y -= d[1];
            
            if(maze[x][y]!=2 && dfs(maze, x, y, destination)) return true;          // check dfs for obstacle and if node not visited and found destination, then that is the answer
        }
        
        return false;
        
    }
    
}







// // ******************** BFS : Modifying existing array ********************


// // // Time Complexity:  O(m*n)
// // // Space Complexity: O(m*n)


// class Solution {

//     Queue<int[]> queue;
//     int[][] dir = new int[][] {
//       {0, 1}, {1, 0}, {0, -1}, {-1, 0}
//     };
  
//     public static void main(String[] args) {
//         int[][] maze = new int[][] {
//             {0, 0, 1, 0, 0},
//             {0, 0, 0, 0, 0},
//             {0, 0, 0, 1, 0},
//             {1, 1, 0, 1, 1},
//             {0, 0, 0, 0, 0}
//         };
//         int[] start = new int[] {0, 4};
//         int[] destination = new int[] {4, 4};
//         Solution obj = new Solution();
//         System.out.println(obj.hasPath(maze, start, destination));
//     }
    
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {

//         int m = maze.length;
//         int n = maze[0].length;
//         queue = new LinkedList<>();
        
//         queue.add(new int[] {start[0], start[1]});
//         maze[start[0]][start[1]] = 2;

//         while(!queue.isEmpty()) {
//             int[] pair = queue.poll();
//             for(int[] d : dir) {
//                 int i = pair[0];
//                 int j = pair[1];
//                 while(i>=0 && i<m && j>=0 && j<n && maze[i][j]!=1) {
//                     i += d[0];
//                     j += d[1];
//                 }
//                 i -= d[0];
//                 j -= d[1];

//                 if(maze[i][j] != 2) {
//                     if(i == destination[0] && j == destination[1]) {
//                         return true;
//                     }
//                     queue.add(new int[] {i, j});
//                     maze[i][j] = 2;
//                 }
//             }
//         }
//         return false;
//     }
// }








// // ******************** BFS : With visited array ********************


// // // Time Complexity:  O(m*n)
// // // Space Complexity: O(m*n)


// class Solution {

//     Queue<int[]> queue;
//     int[][] dir = new int[][] {
//       {0, 1}, {1, 0}, {0, -1}, {-1, 0}
//     };
//     boolean[][] visited;
  
//     public static void main(String[] args) {
//         int[][] maze = new int[][] {
//             {0, 0, 1, 0, 0},
//             {0, 0, 0, 0, 0},
//             {0, 0, 0, 1, 0},
//             {1, 1, 0, 1, 1},
//             {0, 0, 0, 0, 0}
//         };
//         int[] start = new int[] {0, 4};
//         int[] destination = new int[] {3, 2};
//         Solution obj = new Solution();
//         System.out.println(obj.hasPath(maze, start, destination));
//     }
    
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {

//         int m = maze.length;
//         int n = maze[0].length;
//         visited = new boolean[m][n];
//         queue = new LinkedList<>();
        
//         queue.add(new int[] {start[0], start[1]});
//         visited[start[0]][start[1]] = true;

//         while(!queue.isEmpty()) {
//             int[] pair = queue.poll();
//             for(int[] d : dir) {
//                 int i = pair[0];
//                 int j = pair[1];
//                 while(i>=0 && i<m && j>=0 && j<n && maze[i][j]==0) {
//                     i += d[0];
//                     j += d[1];
//                 }
//                 i -= d[0];
//                 j -= d[1];

//                 if(visited[i][j] != true) {
//                     if(i == destination[0] && j == destination[1]) {
//                         return true;
//                     }
//                     queue.add(new int[] {i, j});
//                     visited[i][j] = true;
//                 }
//             }
//         }
//         return false;
//     }
// }
