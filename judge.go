// Time Complexity : O(n + N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create an indegree array of size N
for judge all should trust it, it should not trust anyone
loop over all relations
set indegree of first column-1 index to --
set indegree of second column-1 index to ++

loop over indegrees array if any of them has count = N-1 that is judge else return -1
*/
package main

import "fmt"

func findJudge(N int, trust [][]int) int {
	indeg := make([]int, N)
	for i:=0;i<len(trust);i++ {
		indeg[trust[i][0] - 1]--
		indeg[trust[i][1] - 1]++
	}
	for i:=0;i<N;i++ {
		if indeg[i] == N - 1 {
			return i + 1
		}
	}
	return -1
}

func MainTownJudge() {
	fmt.Println(findJudge(4, [][]int{{1,3},{1,4},{2,3},{2,4},{4,3}}))  //expected 3
}
