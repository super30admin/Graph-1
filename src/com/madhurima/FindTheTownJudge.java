//Time complexity: O(n) for going over trust array
//Space Complexity: O(n) for indegrees array
//Did the code run successfully in LeetCode = yes

package com.madhurima;

public class FindTheTownJudge {
}

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0){
            return -1;
        }

        int[] indegrees = new int[n];

        for(int[] t: trust){
            int outgoing = t[0];
            int incoming = t[1];

            indegrees[outgoing-1]--;
            indegrees[incoming-1]++;

        }

        for(int i = 0; i< n; i++){
            if(indegrees[i] == n-1){
                return i+1;
            }
        }

        return -1;

    }
}
