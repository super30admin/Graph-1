// Time Complexity : O(n) where n is the number of people
// Space Complexity : O(n) where n is the indegree array length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: As it is given that Town judge trusts no body => outdegree is 0 and everyone trusts
the twon judge => there is a directed edge towards the town judge from each and every node (N-1) as we model the problem into a graph. Hence, we 
count the indegree for each of the nodes and the node with indegree = N-1 is the town judge as we infer from the previous statement.
*/
// INDEGREE APPROACH
class Solution {
    public int findJudge(int N, int[][] trust) {
 //       if(trust == null || trust.length == 0){return -1;}
        int[] indegree =  new int[N];                                                   // Count the indegree of each of the nodes
        for(int[] i : trust){
            indegree[i[1]-1]++;                                                             // Increment if there is an edge to this node
            indegree[i[0]-1]--;                                                            // Decrement since it detects an outdegree and town judge has no outdegree
        }
        for(int i = 0; i < N; i++){
            if(indegree[i] == N-1){                                                     // If the count == N-1 (indegree) => this is the Town Judge
                return i+1;
            }
        }
        return -1;                                                                              // not found
    }
}
// HASHMAP APPROACH
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null || trust.length == 0){return N;}
        HashMap<Integer, Integer> store = new HashMap<>();                                                  // Store the indegree count in hashmap
        HashSet<Integer> keys = new HashSet<Integer>();                                                     
        for(int i = 0; i < trust.length;i++){
                store.put(trust[i][1], store.getOrDefault(trust[i][1], 0)+1);                                   // Store the trust count
                keys.add(trust[i][0]);                                                                      // Add the number of people in the town to hashset
        }
        System.out.println(store);
        for(int i: store.keySet()){
            if(store.get(i) == N-1 && !keys.contains(i)){                                                       // Check if the set doesn't contain the town judge since it has no outdegree
                return i;
            }
        }
        return -1;
    }
}