// Time Complexity : O(M)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes. 
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class TownJudge {
    public int findJudge(int N, int[][] trust) {
        if(null == trust || 0 == trust.length){return N;}
        Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] t : trust){
            set.add(t[0]);
            if(!map.containsKey(t[1])){
                map.put(t[1],new ArrayList<>());
            }
            map.get(t[1]).add(t[0]);
        }
        int result = -1;
        boolean foundJudge = false;
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            if(list.size() == set.size() && !set.contains(key)){
                result = key;
                if(foundJudge){return -1;}
                foundJudge = true;
            }
        }
    return result;
    }
}