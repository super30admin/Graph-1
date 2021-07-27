// Time Complexity : O(mn)
// Space Complexity : O(mn)
class Solution {
    HashMap<Integer,HashSet<Integer>> map;
    public int findJudge(int N, int[][] trust) {
        map =  new HashMap<>();
        
       for(int[] rel:trust)
       {
           if(!map.containsKey(rel[0]))
           {
               map.put(rel[0],new HashSet<>());
           }
            map.get(rel[0]).add(rel[1]);
          
       }
        int judge =1;
        for(int i = 1;i <=N;i++)
        {
            if(i !=judge && trusts(judge,i))
                judge = i;
        }
        for(int i = 1;i <=N;i++)
        {
            if(i == judge) continue;
            if(trusts(judge,i) || !trusts(i,judge)) return -1;
        }
        return judge;
    }
    
    private boolean trusts(int a, int b)
    {
        if(map.containsKey(a) && map.get(a).contains(b)) return true;
        else return false;
    }
}