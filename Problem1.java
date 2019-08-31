//Time Complexity : O(N+M) N-> number of people M-> input array size
//Space Complexity : O(N)
// Worked on LeetCode : Yes

//Approach:
//1 . Have an array of length N.For each array[a,b] in the given 2d input array , decrement result[a-1] by 1 and 
//    increment result[b-1] by 1. Do this for all arrays[a,b] in input.
//2 . Now if a judge exists , then all others must have trusted him . So check for value of N-1 in array in newly created array
//    and return its index+1 . Else return -1 as judge doesn't exist i.e the person might have trusted other person.
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] result = new int[N];
        for(int[] x:trust){
            result[x[0]-1] --;
            result[x[1]-1] ++;
        }
        for(int i = 0;i<N;i++)
            if(result[i] == N-1) return i+1;
        return -1;
    }
}
