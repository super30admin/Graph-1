// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class FindTheTownJudge {

    class Solution {
        public int findJudge(int N, int[][] trust) {
            if(N == 1 ) return N;// edge case for when there is only one person in the town

            int[] count = new int[N + 1];//create an array to keep track of number of trust a person has

            //iterate over trust and increment or decrement bases on wheter a person is trusted or not
            for (int[] t:trust) {
                count[t[0]]--;
                count[t[1]]++;
            }

            //loop over count array and find index with highest trust from all others
            for (int i = 0; i <= N; i++) {
                if(count[i] == N-1) return i;
            }

            return -1;//no one found
        }
    }
}
