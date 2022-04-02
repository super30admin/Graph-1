/*
Time Complexity: O(Number of Edges in the given trust)
Space Complexity: O(N), N is the size of the indegree and outdegree array
Run on leetcode: yes
any difficulties: no

Approach:
1. Calculating In-degree and out degree of the given graph, for a person to be a judge, his indegree must be n-1 and out degree
must be 0
 */
public class FindTheTownJudge {
    public static int findJudge(int[][]trust, int n){
        if(trust.length<n-1){
            return -1;
        }
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int[] relation: trust){
            int a = relation[0];
            int b = relation[1];

            indegree[b]++;
            outdegree[a]++;
        }
        // Iterating over the given n in order to check indegree and outdegree of every person
        // when indegree is equal to n-1 and outdegree is equal to zero than returning the judge
        for(int i = 1; i<=n; i++){
            if(indegree[i] == n-1 && outdegree[i] == 0){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[][] trust = {{1,3},{2,3},{3,1}};
        int[][] trust1 = {{1,3},{2,3}};

        System.out.println("Town Judge: "+findJudge(trust, 3));
        System.out.println("Town Judge: "+findJudge(trust1, 3));
    }
}
