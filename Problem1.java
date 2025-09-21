
//Time Complexity: O(n)
//Space Complexity: O(n)    

//when we visualize it is a graph problem and the judge will have n-1 indegree and 0 outdegree
//so we can use an array to keep track of the trust count for each person
//if a person trusts someone we decrement their count and if they are trusted by someone we increment their count
//at the end we check if any person has a count of n-1, if yes we return that person's label
//otherwise we return -1

class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[]=new int[n+1];

        for(int i=0;i<trust.length;i++){
            arr[trust[i][0]]--;
            arr[trust[i][1]]++;
        }
        for(int i=1;i<=n;i++){
            if(arr[i]==n-1)
                return i;
        }
        return -1;
    }
}