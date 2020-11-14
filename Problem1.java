// Time Complexity: O(E + V)
// Space Complexity: O(V)
// Passed Leetcode

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if (trust.length == 0)
            return N > 1?-1:1;
        HashMap<Integer, int[]> map = new HashMap<>();
        
        for (int i = 0; i < trust.length; i++) {
            
            int s = trust[i][0];
            int t = trust[i][1];
            
            if (!map.containsKey(s))
                map.put(s, new int[2]);
            map.get(s)[0]++;
            
             if (!map.containsKey(t))
                map.put(t, new int[2]);
            map.get(t)[1]++;
            
        }
        

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] vals = entry.getValue();
            if (vals[0] == 0 && vals[1] == N - 1)
                return entry.getKey();
        }
        return -1;
        
    }
}