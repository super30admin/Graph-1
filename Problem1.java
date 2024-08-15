class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int[] x : trust){
                if(hm.containsKey(x[1])){
                    hm.put(x[1],hm.get(x[1])+1);
                }
                else{
                    hm.put(x[1],1);
                }

                if(hm.containsKey(x[0])){
                    hm.put(x[0],hm.get(x[0])-1);
                }
                else{
                    hm.put(x[0],-1);
                }

        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value==n-1){
                return key;
            }
        }

        return -1;

        
    }
}