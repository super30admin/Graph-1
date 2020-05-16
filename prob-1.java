//TC:O(N)
//SC:O(N)


class Solution {
    public int findJudge(int N, int[][] trust) {
        
       if(N==1) return 1;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<trust.length;i++)
            set.add(trust[i][0]);
        
        for(int i=0;i<trust.length;i++)
         {
             map.put(trust[i][1],map.getOrDefault(trust[i][1],0)+1); 
         }
        
        for(int k : map.keySet())
        if((map.get(k)==N-1) && (!(set.contains(k))) )
                 return k;
        
        return -1;
    }
}