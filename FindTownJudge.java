//Approach - use an additional trustScore array
// if a trusts b , trustScore++ to b and trustScore-- to a
//finally people with score (n-1) will be the judge
//Time Complexity - O(E) - number of edges - number of trust relationships
//Space Complexity - O(N+1) = N is the number of perople;

class Solution {
  public int findJudge(int N, int[][] trust) {

    if((trust == null || trust.length == 0 || trust[0].length == 0) && N==1){
      return N;
    }

    int[] trustScore = new int[N+1];

    for(int[] element: trust){
      trustScore[element[1]]++;
      trustScore[element[0]]--;
    }

    for(int i=1; i<=N; i++){
      if(trustScore[i] == (N-1)){
        return i;
      }
    }

    return -1;
  }
}
