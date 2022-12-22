//TC: O(n)
//SC: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[] = new int[n + 1]; // Define an array of length n+1
        
        for(int i = 0; i < trust.length; i++){ // loop through the 'trust' array
            arr[trust[i][0]]--; // if a given person trust someone then decrement the count of his index
            arr[trust[i][1]]++; // increment the count of the index whom he trusts
            
        }
        // In last, check the 'arr' array that if there is any index having count equals to n-1
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == n - 1) return i; // person doesnt trust anybody but everyone else trust him. Return their index
        }
        return -1;
    }
}