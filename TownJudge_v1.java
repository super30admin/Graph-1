/**

LeetCode Submitted : YES
Space Complexity : O(N*M)
Time Complexity : O(N*M)

The idea is to use hashmap to store relationships between people. The optimal solution may involve finding the sink node in a graph.
**/

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust == null || trust.length < 1)
            return 1;
        
        Map<Integer,List<Integer>> relation =  new HashMap<Integer,List<Integer>>();
        Set<Integer> villagers = new HashSet<>();
        
        for(int[] t : trust){
            if(!relation.containsKey(t[1])){
                List<Integer> l = new ArrayList<>();
                l.add(t[0]);
                relation.put(t[1],l);
            }else{
                List<Integer> l = relation.get(t[1]);
                l.add(t[0]);
                relation.put(t[1],l);
            }
            villagers.add(t[0]);
        }
        int flag = -1;
        for (Map.Entry<Integer,List<Integer>> r : relation.entrySet()) {
            List<Integer> nodes = r.getValue();
            int count = 0;
            int townJudge = r.getKey();
            
            for(Integer n : nodes){
                if(villagers.contains(n)){
                    count ++;
                }else{
                    break;
                }
            }
            if(count == villagers.size() && !villagers.contains(townJudge)){
               if(flag == -1)
                   flag = townJudge;
               else
                   return -1;
            }
                
        }
        
        if(flag != -1)
            return flag;
        
        return -1;
    }
}
