

// Time - O(E)
// Space - O(N)




class Solution {
    public int findJudge(int n, int[][] trust) {

        if(trust.length < n - 1) return -1; // if there are less then n - 1 edges

        int [] trustScores = new int[n+1];

        for(int [] relation: trust) { // iterate through trust array and find out incoming and outgoing edges for each person

            trustScores[relation[0]]--; // decrement if outgoing edge
            trustScores[relation[1]]++; // increment if incoming edge

        }

        for(int i = 1; i <= n; i++) { // iterate through each person to find the town judge

            if(trustScores[i] == n-1){ // if the person has n-1 incoming edges and 0 outgoing edges return that person as a town judge
                return i;
            }

        }

        return -1;

    }
}
