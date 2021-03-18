//Time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N==1)
            return 1;
        int[] count_trust=new int[N];
        for(int i=0;i<trust.length;i++){
            count_trust[trust[i][0]-1]--;//negative couunt of indegree
            count_trust[trust[i][1]-1]++;//count of out degree
        }
        
        for(int i=0;i<N;i++){
            if(count_trust[i]==N-1)//only label with N-1 indegree is is the answer
                return i+1;
        }
        return -1;
    }
}
