// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Failed one testcase


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
        int max = Integer.MIN_VALUE;
        int result=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                result = entry.getKey();
                
            }
        }
        for(int[] item : trust){
            if(item[0]==result) return -1;
        }
        return result;
    }
}