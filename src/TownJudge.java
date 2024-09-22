// Check for trustScores and put it in a map. 
//Whenever, a person trusts someone, decrease his score by 1
// Whenever a person is trusted by someone, increase his score by 1
//  TC: O(m+n) m = length of array trust
// SC: O(n)
class TownJudge {
    public int findJudge(int n, int[][] trust) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
            map.put(i,0);
        }
        for(int[] t : trust) {
            map.put(t[0],map.get(t[0])-1);
            map.put(t[1],map.get(t[1])+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue() == n-1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}