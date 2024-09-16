
// Time Complexity - O(n)
// Space - O(n)
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null || trust.length == 0)
            return 1;
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, Integer> outdegree = new HashMap<>();
        
        for(int[] t : trust){
            indegree.put(t[1], indegree.getOrDefault(t[1], 0) + 1);
            outdegree.put(t[0], t[1]);
        }
        
        for(Integer key: indegree.keySet()){
            if(indegree.get(key) == N - 1 && !outdegree.containsKey(key) ){
                return key;
            }
        }
        
        return -1;
    }
}