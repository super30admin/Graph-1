/*
  Time: O(e) e = number of relations in graph
  Space: O(n) n = relation info for wach person.
  Run on LeetCode = yes 
*/
class Solution {
    public int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> tVal = new HashMap<>();

        for(int i = 1; i <= N; i++){
            tVal.put(i, 0);
        }

        for(int tr[]: trust){
            tVal.put(tr[0], tVal.get(tr[0])-1);
            tVal.put(tr[1], tVal.get(tr[1])+1);
        }

        for(int i : tVal.keySet()){
            if(tVal.get(i) == N-1)
                return i;
        }
        return -1;
    }
}
