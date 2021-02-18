// Time Complexity : The time complexity is O(N+n) where n is the length of the trust array
// Space Complexity : The space complexity if O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int N, int[][] trust) {

        int[] people = new int[N+1];

        // count the dependencies
        for(int[] each:trust){
            people[each[1]]++;
            people[each[0]]--;
        }

        for(int i=1;i<=N;i++){

            // To be the judge, number of dependencies should be N-1
            if(people[i] == N-1){
                return i;
            }
        }

        return -1;
    }
}