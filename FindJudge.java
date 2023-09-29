//TC = O(E) //E = number of edges.
//SC = O(N) //N = number of nodes.
class FindJudge{
    public int findJudge(int n, int[][] trust) {
        int[] ingress = new int[n];
        for(int[] tr: trust){
            ingress[tr[0]-1]--;
            ingress[tr[1]-1]++;
        }
        for(int i=0; i<n; i++){
            if(ingress[i]==n-1){
                return i-1;
            }
        }
        return -1;
    }
}