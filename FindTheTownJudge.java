/**
 * Time complexity : O(n)
 * Space Complexiy : O(n) 
 */
public class FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {


        int[] trustArr = new int[N];

        for(int[] arr : trust)
        {
            trustArr[arr[0]-1]--;
            trustArr[arr[1]-1]++;
        }

        for(int i = 0 ; i < trustArr.length ; i ++)
        {
            if(trustArr[i] == N-1)
            {
                return i+1;
            }
        }

        return -1;
    }
}