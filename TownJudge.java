// TC: O(n*m) where n is trust elements and m is the number of unique people 
// SC: O(m) where m is the number of unique people 

public class TownJudge {
    public int findJudge(int N, int[][] trust) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> m = new ArrayList<>();
        for(int i=0; i<trust.length; i++){
            if(!map.containsKey(trust[i][0])){
                map.put(trust[i][0], m);
            }
        }
        
        System.out.println("Keys updated: "+map);
        
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<trust.length; i++){
                if(trust[i][0] == entry.getKey()){
                    l.add(trust[i][1]);
                }
            }
            map.put(entry.getKey(), l);
        }
        
        System.out.println("Values updated: "+map);
        int op = -1;
        List<Integer> val = new ArrayList<>();
        if(map.containsKey(N)){
            val = map.get(N);
            for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
                val.retainAll(entry.getValue());
            }
        }
        else{
            val.add(N);
            for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
                val.retainAll(entry.getValue());
            }               
        }
        
        if(val.size() == 1)
            op = val.get(0);
        System.out.println("Final Values: "+val);
        
        return op;
    }
}