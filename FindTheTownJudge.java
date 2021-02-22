// Time Complexity : O(N + t), t = rows in the trust matrix
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create an array of length N, so that each person is represented by the index+1 of the array. Compute the incoming and the outgoing trust by adding and subtracting 1, for each person. A judge will be a person who has trust from all people and when he has doesn't trust any other person i.e. value is N-1.

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if(N == 1) return 1;
        
        int[] arr = new int[N];

        for(int i = 0; i < trust.length; i++){
            arr[trust[i][0] - 1] = arr[trust[i][0] - 1] - 1;
            arr[trust[i][1] - 1] = arr[trust[i][1] - 1] + 1;
        }
        
        for(int i = 0; i < N; i++){
            if(arr[i] == N-1){
                return i + 1;
            }
        }
        
        return -1;
    }
}
