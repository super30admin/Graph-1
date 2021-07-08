// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int n, int[][] trusts) {
        
        if (n == 1) return 1;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int [] trust : trusts){
            
            int a = trust[0];
            int b = trust[1];
            
            List<Integer> array = map.getOrDefault(b, new ArrayList<>());
            array.add(a);
            map.put(b,array);
        }
        
        Integer probableJudge = 0;
        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if (entry.getValue().size() == n-1) {
                probableJudge = entry.getKey();
            }
        }
        
        if (probableJudge == 0)
                return -1;

        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if (entry.getValue().contains(probableJudge)) {
                return -1;
            }
        }
        return probableJudge;
    }
}