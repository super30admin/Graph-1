/*
brute force way
I would be calculating the indegree and outdegree for each person and then checking whether or not any of them meet the criteria of the town judge.
To meet criteria of town judge, we need indegree of person to be n-1 and outdegree should be 0
*/

class Solution {
    public int findJudge(int N, int[][] trust) {
            if(trust.length < N-1) return -1;
            //make 2 arrays : for every pair increment 1 
            //in the trusted by as well as peopleTrusted for that member
            int[] indegree = new int[N+1];
            int[] outdegree = new int[N+1];
            for (int[] person : trust) {
                outdegree[person[0]]++;
                indegree[person[1]]++;
            }
            //finally you have return that member who is trusted by N-1 members
            //and who trust 0 members.
            for (int i = 1; i <= N; i++)
                if (indegree[i] == N-1 && outdegree[i] == 0) 
                    return i;
            return -1;
    }
}


/*
optimized solution

1. We can instead build a single Array with the result of indegree - outdegree for each person. 
2. In other words, I would be incrementing 1 to their "score" for each person they are trusted by, 
    and decrementing 1 from their "score" for each person they trust. 
3. Therefore, for a person to maximize their "score", they should be trusted by n-1 people, and trust as no one
Time complexity-  O(E) where E is the no of edges, trust relationship
space complexity - O(N) We're still allocating an array of length N.
*/
class Solution {
    public int findJudge(int N, int[][] trust) {
            if(trust.length < N-1) return -1;
            //make 2 arrays : for every pair increment 1 
            //in the trusted by as well as peopleTrusted for that member
            int[] trustArray = new int[N+1];
            for (int[] person : trust) {
                trustArray[person[0]]--;
                trustArray[person[1]]++;
            }
            //finally you have return that member who is trusted by N-1 members
            //and who trust 0 members.
            for (int i = 1; i <= N; i++)
                if (trustArray[i] == N-1) 
                    return i;
            return -1;
    }
}
