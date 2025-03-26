class Solution{
  public int findJudge(int n, int[][] trust){
    if(trust == null || trust.length == 0) return -1;
    int[] indegree = new int[n + 1];
    int judge = 0;
    for(int[] t : trust){
      indegree[t[1]]++;
    }
    for(int i = 1; i < n + 1; i++){
      if(indegree[i] == n - 1) return i;
    }
    return -1;
  }
}
