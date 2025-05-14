/*
 TC: O(E+V), SC: O(V)
 */

public class FindJudge {

        public int findJudge(int n, int[][] trust) {

            int[] inDegrees = new int[n+1];

            for(int[] arr: trust){
                inDegrees[arr[0]]--;
                inDegrees[arr[1]]++;
            }

            for(int i=1; i<=n; i++){
                if(inDegrees[i] == n-1){
                    return i;
                }
            }

            return -1;

        }
}


