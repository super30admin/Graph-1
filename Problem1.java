package Graph_1;

import java.util.HashMap;

/**
 * Maintaining indegree-outdegree mapping by incrementing +1 for each indegree
 * and decrementing -1 for each outdegree for a given node. In the end the node
 * that has this mapped value as n-1 is the town judge
 * 
 * Time Complexity : O(n)- where n is the no of candidates given
 * 
 * Space Complexity : O(n), where n is the no of candidates given
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
    public int findJudge(int n, int[][] trust) {
        //candidate to indegree-outdegree mapping
        HashMap<Integer, Integer> map=new HashMap<>();
        if(n==1)
            return 1;
        for(int i=0;i<trust.length;i++){
                if(!map.containsKey(trust[i][1])){
                    map.put(trust[i][1], 0);
                }
                
                map.put(trust[i][1], map.get(trust[i][1])+1);
                    
                if(!map.containsKey(trust[i][0])){
                    map.put(trust[i][0], 0);
                }
                map.put(trust[i][0], map.get(trust[i][0])-1);
                 
                 
        }
        for(Integer key: map.keySet()){
            if(map.get(key)==n-1){
                return key;
            }
        }

        return -1;

    }
}
