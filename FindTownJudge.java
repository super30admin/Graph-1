// Time Complexity : O(V+E) V is no of people and E are number of trustlinks
// Space Complexity : O(V) V is no of people
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int [] indegrees = new int[n];
        for(int [] t : trust){
            indegrees[t[0]-1]--;
            indegrees[t[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(indegrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        FindTownJudge ftj = new FindTownJudge();
        System.out.println(ftj.findJudge(3, new int[][]{{1,3},{2,3}}));
    }
}