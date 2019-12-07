package demo;

import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O (mn)
//Space Complexity: O(mn ) visited matrix + queue
//Leetcode: yes

class Solution {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {

		int n = maze.length;
		int m = maze[0].length;

		boolean[][] visited = new boolean[n][m];

		Queue<int[]> q = new LinkedList<>();

		q.add(start);
		while(!q.isEmpty()){

			int[] front = q.poll();
			//initializing with queue element that is being processed
			int starti = front[0];
			int startj = front[1];
			//if destination reached
			if(starti == destination[0] && startj == destination[1]){
				return true;
			}

			if(visited[starti][startj]){//next iteration
				continue;
			}

			visited[starti][startj] = true;

			int tempi = starti;
			int tempj = startj;
			//down
			while(valid(tempi  + 1 ,tempj , maze , n,m)){
				tempi += 1;
			}
			q.add(new int[] {tempi,tempj});

			//up
			tempi = starti;
			tempj = startj;
			while(valid(tempi  - 1 ,tempj , maze , n,m)){
				tempi -= 1;
			}
			q.add(new int[] {tempi,tempj});

			//right
			tempi = starti;
			tempj = startj;
			while(valid(tempi ,tempj + 1 , maze , n,m)){
				tempj += 1;
			}
			q.add(new int[] {tempi,tempj});

			//left
			tempi = starti;
			tempj = startj;
			while(valid(tempi ,tempj -1, maze , n,m)){
				tempj -= 1;
			}
			q.add(new int[] {tempi,tempj});
		}

		return false;

	}
	//to check if out of bounds or if there is a wall maze[i][j] == 1
	private boolean valid(int i,int j , int[][] maze , int n , int m){
		if(i < 0 || i >= n || j < 0 || j >= m || maze[i][j] == 1){
			return false;
		}
		return true;
	}

}