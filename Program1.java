//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] indegrees = new int[N];
        boolean isJudge=false;
        int judgeIndex=-1;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<trust.length;i++){
            indegrees[trust[i][1]-1]++;
            if(!map.containsKey(trust[i][0])){
                map.put(trust[i][0], new ArrayList<>());
            }
            map.get(trust[i][0]).add(trust[i][1]);
        }
        
        for(int i=0; i<indegrees.length;i++){
            if(indegrees[i]==indegrees.length-1){
                isJudge=true;
                judgeIndex=i;
                break;
            }
        }
        
        if(isJudge && map.get(judgeIndex+1)==null){
            return judgeIndex+1;
        }
        
        
        return -1;
        
        
    }
}