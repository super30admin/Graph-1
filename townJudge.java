//Time Complexity:O(n) where n is the size of the trust array.
//Space Complexity:O(n)
//Approach- Creating two new arrays to hold the number of people who trust(t) and another list that holds the number of people who trusts them. If a particular index in t array is 0 and its value is equal to N-1, then that particular index represents the town judge, because a town judge never trusts anyone and they are trusted by everyone except themselves.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length==0){
            return N==1?1:-1;
        }
        int[] t=new int[N];
        int[] trusted=new int[N];
        for(int i=0;i<trust.length;i++){
            int a=trust[i][0];
            int b=trust[i][1];
            t[a-1]++;
            trusted[b-1]++;
        }
        for(int i=0;i<N;i++){
            if(t[i]==0&&trusted[i]==N-1){
                return i+1;
            }
        }
        return -1;
    }
}