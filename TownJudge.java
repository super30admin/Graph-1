// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Worked but bad approach


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust==null || trust.length==0) return 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] item: trust){
            if(map.containsKey(item[1])){
                map.put(item[1],map.get(item[1])+1);
            }
            else{
                map.put(item[1],1);
            }
        }
        // List<Integer> possible = new ArrayList<>();
        int max = N-1;
        int result=-1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==max){
                result=entry.getKey();
                break;
                
            }
        }
        for(int[] item : trust){
            if(item[0]==result) return -1;
        }
        return result;
    }
}