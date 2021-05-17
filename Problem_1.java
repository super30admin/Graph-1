//Space Complexity:O(n)
//Time Complexity:O(V+E) v==n and E=trust.length
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        for(int[] i :trust){
            if(i[0]==i[1])return -1;
            arr[i[0]]--;
            arr[i[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(arr[i]==n-1)return i;
        }
        return -1;
    }
}