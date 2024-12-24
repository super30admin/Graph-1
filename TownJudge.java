// Time Complexity: O(E + V) where E and V are the vertices and edges of graph
// Space complexity: O(V) where V is the vertices of the graph
public class TownJudge {
    public int findJudge(int n, int [][] trust){
        int [] inDegrees = new int[n +1];

        for (int [] tr : trust){
            inDegrees[tr[0]]--; // decrement the array for people who trust
            inDegrees[tr[1]]++; // increment the array for who is trusted
        }

        // find the judge
        for( int i =1; i <= n; i++){
            if(inDegrees[i] == n - 1){
                return i;
            }
        }

        return -1;

    }

    public static void main (String [] args){
        TownJudge solution = new TownJudge();
        int [][] trust1 = {{1,3}, {2,3}};
        int n1 = 3;
        System.out.println(solution.findJudge(n1, trust1));

        // Test case 2
        int n2 = 3;
        int[][] trust2 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println("Test Case 2 Judge: " + solution.findJudge(n2, trust2)); // Output: -1

        // Test case 3
        int n3 = 2;
        int[][] trust3 = {{1, 2}};
        System.out.println("Test Case 3 Judge: " + solution.findJudge(n3, trust3)); // Output: 2

        // Test case 4
        int n4 = 1;
        int[][] trust4 = {};
        System.out.println("Test Case 4 Judge: " + solution.findJudge(n4, trust4)); // Output: 1
    }

}
