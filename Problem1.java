//TC - O(m+n) m to iterate over 2d array. N to iterate over the array to find the result.
//SC - O(n)
// Use an indegree array to store edges of each verted. If its from - reduce 1,
//if its to - reduce 1. Result would be the value in the array would be equal to n-1

class Problem1 {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        int[] arrayIndex = new int[n+1];
        int result = -1;
        for(int[] data : trust){
            arrayIndex[data[0]]--;
            arrayIndex[data[1]]++;
        }
        for(int i=0 ;i<n+1; i++){
            if(arrayIndex[i] == n-1){
                result = i;
                break;
            }
        }
        return result;
    }
}