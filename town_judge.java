//Time - O(n)
//Space - O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if((trust.length==0 || trust==null) && n>1)
            return -1;
        HashMap<Integer,HashSet<Integer>> hm = new HashMap();
        for(int[] t: trust){
            if(!hm.containsKey(t[0])){
                hm.put(t[0], new HashSet<>()); 
            }
               
            HashSet h = hm.get(t[0]);
            h.add(t[1]);
            hm.put(t[0], h);
            
        }
        int possible = -1;
        for(int i=1;i<=n;i++){
            if(!hm.containsKey(i))
                possible = i;
        }
        
        for(int key : hm.keySet()){
            if(!hm.get(key).contains(possible))
                return -1;
        }
        return possible;
    }
}
