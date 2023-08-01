package Graph_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Here we do a BFS from the start point (the BFS in each direction stops only
 * when there is a wall). If we ever reach the destination during BFS then
 * return true.
 * 
 * Time Complexity : O(m*n)- where where m is the no of rows and n is the no of
 * cols
 * 
 * Space Complexity : O(m*n)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
	
		private int dirs[][]= {{1,0},{-1,0},{0,-1},{0,1}};
	
	    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
	    	
	    	Queue<int []> q= new LinkedList<>();
	    	q.add(start);
	    	
	    	while(!q.isEmpty()) {
	    			
	    		int [] coordinates=q.poll();
	    		int temp_cr=coordinates[0];
	    		int temp_cc=coordinates[1];
		    	for(int i=0;i<dirs.length;i++) {
		    		int cr= temp_cr;
		    		int cc=temp_cc;
		    		//moving left
		    		if(dirs[i][0]==0 && dirs[i][1]==-1) {

		    			while(cc>=0 && (maze[cr][cc]==0 || maze[cr][cc]==2)) {
			    			cr+=dirs[i][0];
			    			cc+=dirs[i][1];
			    		}
			    		cc++;
			    		
		    		}
		    		//moving right
		    		else if(dirs[i][0]==0 && dirs[i][1]==1) {
		    			while(cc<maze[0].length && (maze[cr][cc]==0 || maze[cr][cc]==2)) {
			    			cr+=dirs[i][0];
			    			cc+=dirs[i][1];
			    		}
			    		cc--;
			    		
		    		}
    				

		    		//moving down
		    		else if(dirs[i][0]==1 && dirs[i][1]==0) {
		    			while(cr<maze.length && (maze[cr][cc]==0 || maze[cr][cc]==2)) {
			    			cr+=dirs[i][0];
			    			cc+=dirs[i][1];
			    		}
			    		cr--;
			    		
		    		}

		    		//moving up
		    		else if(dirs[i][0]==-1 && dirs[i][1]==0) {
		    			while(cr>=0 && (maze[cr][cc]==0 || maze[cr][cc]==2)) {


			    			cr+=dirs[i][0];
			    			cc+=dirs[i][1];
			    			System.out.println(cr);
			    			System.out.println(cc);
			    		}
			    			cr++;
		    		}
		    		

		    		if(cr==temp_cr && cc==temp_cc)
		    			continue;
		    		if(cr>=0 && cr<maze.length && cc>=0 && cc<maze[0].length) {
		    			if(maze[cr][cc]==2)
		    				continue;
		    			else
		    				maze[cr][cc]=2;
		    			
		    		}
		    		q.add(new int[] {cr,cc});

		    			
		    		if(cr==destination[0] && cc==destination[1])
		    				return true;
		    	}

	    		
	    	}
	    	
	    	return false;
	    	
	    	
	    }
	    
	    public static void main(String[] args) {
	    	Problem2 p2=new Problem2();
	    	int [][]maze=  {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
	    	int[] start= {0,4};
	    	int destination[]= {4,4};
	    	System.out.println(p2.hasPath(maze, start, destination));
	    }
}
