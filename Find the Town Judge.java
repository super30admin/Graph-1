//we can use adjacency matrix using hashmap, per person- to how many people it giving trust, the person who is not giving 
//anyone  and is given. y everyone in all other list that is judge tc- v+e sc- v+c

// using indegree array tc- O(v+e) sc- O(v)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];//to handle indexes, numbers are from 1 so using array from 1 to accomodate all values we take n+1

        for(int[] tr : trust){
            indegrees[tr[0]]--;//in indegree array decreamenting value at that value's corresponding index because its giving trust 
            indegrees[tr[1]]++;//receiving trust so increamenting
        }

        for(int i = 1; i < n+1; i++){
            if(indegrees[i] == n-1){//if value matches n-1 people minus judge
                return i;
            }
        }
        return -1;
    }
}