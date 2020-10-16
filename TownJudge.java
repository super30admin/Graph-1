/*
 * #997. Find the Town Judge
 * 
 * In a town, there are N people labeled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1. The town judge trusts nobody -> No outgoing edges
2. Everybody (except for the town judge) trusts the town judge -> (N-1) incoming edges
3. There is exactly one person that satisfies properties 1 and 2 -> Only one town judge

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labeled a trusts the person labeled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Constraints:

1. 1 <= N <= 1000
2. 0 <= trust.length <= 10^4
3. trust[i].length == 2
4. trust[i] are all different
5. trust[i][0] != trust[i][1]
6. 1 <= trust[i][0], trust[i][1] <= N

 */

/*
 * Time Complexity: O (N-1) + O (E) -> O (E) - To traverse through each pair(describing incoming, outgoing edges) in trust array
 * 									 O (N-1) - To traverse through 'relationship' array for finding town judge -> This is small array, negligible
 * 									 So, TC would be just O (E)
 * 
 * Space Complexity: O (N+1) = O (N) -> An array to keep track of incoming and outgoing edges
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.graph1;

public class TownJudge {
	public int findJudge(int N, int[][] trust) {
        
		// #1. Base condition
        if(N == 0){
           return -1;
        }
        
        // #2. Create an array to keep track of incoming and outgoing edges for each person(visualize as a graph node)
        int[] relationship = new int[N+1]; // Creating array of size 'N+1' for simplicity of indices -> [0, 1, 2] indices for 1st example
        
        // #3. Traverse through each pair in given 'trust' array
        for(int[] pair : trust){
            // trust = [[1,2]], we know that 1(a) has outgoing edge and 2(b) has incoming edge as mentioned in the question, a trusts b
            
            // outgoing edge -> Decrement in 'relationship' array
            relationship[pair[0]]--;
            
            // Incoming edge -> Increment in 'relationship' array
            relationship[pair[1]]++;
        }
        
        // #4. Traverse the array from 1st index(N = 1 to N) and check for (N-1) incoming edges(+ve value) at any point
        for(int i = 1; i < relationship.length; i++){
            if(relationship[i] == N-1){
                return i; // return label of town judge
            }
        }
        
        return -1; // town judge not found
        
    }
    
}
