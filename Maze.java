public class Main {
    
    public static boolean pathFinder(char[][] grid, int[] source, int[] dest) {
        //edge
        if(grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return false;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> support = new LinkedList<>(); 
        //insert source into q, mark source as visited
        support.offer(source);
        visited[source[0]][source[1]] = true;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!support.isEmpty())
        {
            int[] front = support.poll();
            //dest found
            if(front[0] == dest[0] && front[1] == dest[1])
            {
                return true;
            }
            
            for(int[] direction : dirs)
            {
                int row = direction[0] + front[0];
                int col = direction[1] + front[1];
                //for each neighbour direction, ball rolls till a wall is hit
                while(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != '1')
                {
                    row += direction[0];
                    col += direction[1];
                }
                //lopp breaks when wall is hit, so row and col are rolled one step back
                row -= direction[0];
                col -= direction[1];
                
                //mark cell as visited and process in the next level
                if(!visited[row][col])
                {
                    visited[row][col] = true;
                    support.offer(new int[]{row, col});
                }   
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] grid = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] source = {0, 4};
        //int[] dest = {3, 4}; true
        int[] dest = {2, 2}; //false
        System.out.println(pathFinder(grid, source, dest));
    }
}
