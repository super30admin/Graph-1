// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set m,n to length, breadth
have dirs array for 4 directions
create a q of coordinates and add start coordinate and set that location to 2
while q has elements
pop q to curr
if curr == end then return true
for each direction in dirs set x, y to curr and use flag
move x, y in direction till its not a wall or out of bound, if x, y change then set flag
if flag set and x,y location is not 2 in maze then add it to q

return false
*/
package main

import "fmt"

func mazeStop(maze [][]int, startCoordinate, endCoordinate []int) bool {
	if len(maze) == 0 || len(maze[0]) == 0 {
		return false
	}
	m := len(maze)
	n := len(maze[0])
	dirs := [][]int{{-1,0},{0,-1},{1,0},{0,1}} //t, l, b, r
	var q [][]int
	maze[startCoordinate[0]][startCoordinate[1]] = 2
	q = append(q, startCoordinate)
	for len(q) > 0 {
		curr := q[0]
		q = q[1:]
		//base
		if curr[0] == endCoordinate[0] && curr[1] == endCoordinate[1] {
			return true
		}
		//logic
		for _, dir := range dirs {
			x := curr[0]
			y := curr[1]
			flag := false
			for x + dir[0] >= 0 && x +dir[0] < m && y + dir[1] >= 0 && y + dir[1] < n && maze[x+dir[0]][y + dir[1]] != 1 {
				x = x + dir[0]
				y = y + dir[1]
				flag = true
			}
			if flag {
				if maze[x][y] != 2 {
					maze[x][y] = 2
					q = append(q, []int{x, y})
				}
			}
		}

	}
	return false
}

func MainMaze() {
	fmt.Println(mazeStop([][]int{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, []int{0,4}, []int{4,4})) //expected true
}
