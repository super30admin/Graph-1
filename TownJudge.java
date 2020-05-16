// Time Complexity : O(n) n : trust.length
// Space Complexity : O(N) N : number of people
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class TownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N];

        for(int i = 0; i < trust.length; i++){
            count[trust[i][1] - 1]++;
        }

        int judge = -1;

        for(int i = 0; i < N; i++){
//            System.out.println(""+count[i]);
            if(count[i] == N-1){
                judge = i+1;
            }
        }

        for(int i = 0; i < trust.length; i++){
            if(trust[i][0] == judge){
                return -1;
            }
        }

        return judge;
    }
}
