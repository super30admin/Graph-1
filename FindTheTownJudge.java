// Time Complexity : O(N+T) N-> No. of people, T -> Trust connection length
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: This problem can be modeled as a directed graph problem.
// Connection from person 1 to person 2 shows the trust relationship.
// For a person to be judge, incoming links should be N-1 and outgoing links should be 0.
// To keep track of incoming and outgoing links, I'll capture the sum of these two in an auxiliary array. If for any person this sum id N-1, then that person is judge.

class Solution {
    public int findJudge(int N, int[][] trust) {
        // edge case
        if(trust == null || trust.length == 0) return N;
        // auxiliary array to keep track of incoming and outgoing connections
        int[] people = new int[N+1]; // each array index signifies the person number
        for(int i = 0; i < trust.length; i++) {
            people[trust[i][0]]--; // decrement outgoing link count
            people[trust[i][1]]++; // increment incoming link count
        }
        
        for(int i = 0; i < people.length; i++) {
            if(people[i] == N-1) {
                return i;
            }
        }
        return -1;
    }
}

