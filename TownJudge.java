// Aproach : Instead of creating adjacency list we can create N degrees Array and compute the person giving
// trust (-1) and person receives trust (+1). At last Person who is not giving trust will have the count as n-1
// Time : O(E) + O(V) // edges & vertices
// Space : O(V) // no of vertices
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1]; // 0 person , 1 person ....
        for(int[] tr: trust){
            {
                indegrees[tr[0]]--; // trust giving person to other
                indegrees[tr[1]]++; // trust receieving person
            }
        }
        for(int i=1;i<=n;i++){
            if(indegrees[i] == n-1) return i;
        }
        return -1;
    }
}