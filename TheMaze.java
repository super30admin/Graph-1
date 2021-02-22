// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Perform DFS to traverse to the extreme neighbors of the current value, which doesnt include the wall. Put such neighbors in the Queue and mark that position as visited, until the end position is found.
 
public class TheMaze {
    public static void main(String [] args){

        int[] start = new int[]{0,4};
        int[] end = new int[]{3,2};
        
        int[][] nums = new int[][]{
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,1,0},
            {1,1,0,1,1},
            {0,0,0,0,0}};
        
        System.out.println(theMaze(nums, start, end));
    }

    public static boolean theMaze(int[][] nums, int[] start, int[] end) {

        Queue<int []> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        int m = nums.length;
        int n = nums[0].length;

        q.add(new int[]{start[0], start[1]});
        nums[start[0]][start[1]] = 2;

        while(!q.isEmpty()){

            int[] index = q.poll();
            int row = index[0];
            int col = index[1];

            for(int i = 0; i < 4; i++){
                int r = row;
                int c = col;

                while(r >= 0 && r < m && c >= 0 && c < n && nums[r][c] != 1){
                    r = r + dirs[i][0];
                    c = c + dirs[i][1];
                }
                
                r = r - dirs[i][0];
                c = c - dirs[i][1];

                if(nums[r][c] != 2){
                    q.add(new int[]{r, c});
                    nums[r][c] = 2;

                    if(r == end[0] && c == end[1])
                        return true;
                }
            }

        }

        return false;
    }
}
