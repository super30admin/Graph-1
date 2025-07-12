// Time complexity -O(n)
// space complexity - O(n)
// Solved on leetcod e- yes
// Faced any issues - No
// maintaining an array with size n. the judge must have n-1 indegrees and 0 outdegrees
// hence checking it over the loop
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] result = new int[n];
        for(int[] i:trust) {
            int a = i[0];
            int b = i[1];

            result[b-1] +=1;
            result[a-1] -=1;
        }

        for(int i=0;i<n;i++) {
            if(result[i] == n-1) return i+1;
        }
        return -1;
    }
}
