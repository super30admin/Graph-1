class Solution {
    public int findJudge(int n, int[][] trust) {

       int[] array = new int [n+1];
       int[] trustArray = new int [n+1];

        for (int[] arr: trust){
            array[arr[0]]++;
            trustArray[arr[1]]++;
        }

        for (int i =1; i<=n;i++){
            if (array[i] == 0){
                // i is the potential judge
                if (trustArray[i] == n-1)
                return i;
            }
        }
        return -1;
    }

