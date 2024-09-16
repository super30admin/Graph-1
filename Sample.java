// Time comp: O(N)
// Space comp: O(N)

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N==0) return -1;
        if(N==0 && trust.length==0) return -1;
        int[] arr = new int[N+1];
        for(int i=0;i<trust.length;i++){
            arr[trust[i][1]]++;
        }
        int res = -1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==N-1){
                res = i;
            }
        }
        for(int i=0;i<trust.length;i++){
            if(res==trust[i][0]){
                res = -1;
            }
        }
        return res;
    }
}
