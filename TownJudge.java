// Time Complexity : 0(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class TownJudge {
    public int findJudge(int N, int[][] trust) {
        //maintain count array
        int[] count = new int[N+1];

        //for every incoming link increase count
        //for every outgoing link decrease count
        for(int i=0;i<trust.length;i++){
            count[trust[i][0]]--;
            count[trust[i][1]]++;
        }

        //whenever total incoming count matches N-1 return index
        for(int i=1;i<count.length;i++){
            if(count[i] == N-1){
                return i;
            }
        }

        return -1;
    }
}