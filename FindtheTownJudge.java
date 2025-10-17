/*
* Approach: 
- There are two properties to become a town judge. 
    - town judge trusts nobody
    - everybody trusts town judge
- So we can iterate through the trust list, and decrement the count of the person who is trusting somebody and incremeent the count of someone who is being trusted
- once that is down, if we find at any index the count is equal to total number people - 1, then they can be a town judge
TC: O(v+e) -> v to iterate over all the trust list and e to iterate over the edges 
SC: O(n) -> array to store in and out degrees of each person 
*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n+1];
        //count the in and out degrees
        for(int[] tr: trust){
            indeg[tr[0]]--;
            indeg[tr[1]]++;
        }
        //check if any person is being trust by everyone except themselves
        for(int i = 1; i < n + 1; i++){
            if(indeg[i] == n - 1)
                return i;
        }
        return -1;
    }
}