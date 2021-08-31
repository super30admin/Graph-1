//TC: O(n+e) where n is the number of people, e is the number of trusts between people in trust array.

//SC: O(n) where n is the number of people.

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust==null) return 0;
        if(n==1) return 1;
        int[] deg=new int[n];
        for(int[] arr:trust){
            deg[arr[0]-1]--;
            deg[arr[1]-1]++;
        }
        for(int i=0;i<deg.length;i++){
            if(deg[i]==n-1)
                return i+1;
        }
        return -1;
    }
}