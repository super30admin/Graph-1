import java.util.Scanner;

public class FindTownJudge {

        // ONE ARRAY OF NET DEGREES - TIME O(V + E) AND SPACE O(V) = O(N)

        public int findJudge(int n, int[][] trust) {

            // vertex array to maintain net degree of each vertex
            int[] vertex = new int[n+1];      // O(N) space

            // build vertex degree array by iterating over each edge array of trust
            for(int[] edge: trust) {          // O(E)

                // reduce degree if a vertex has outgoing edge
                vertex[edge[0]]--;

                // increase degree if a vertex has incoming edge
                vertex[edge[1]]++;
            }

            // iterate over vertex array if there is the judge
            for(int i = 1; i <= n; i++) {       // O(V)

                // if degree is one less than number of people, that person has not trusted anyone and gained trust of all others qualifying to be the judge
                if( vertex[i] == n-1) {

                    //  output the index of person = label of person
                    return i;
                }
            }
            // if no judge is present
            return -1;
        }

        public static void main(String[] args) {

            FindTownJudge obj = new FindTownJudge();

            Scanner scanner = new Scanner(System.in);

            System.out.println("number of people n: ");
            int n = scanner.nextInt();

            System.out.println("number of trust edges: ");
            int e = scanner.nextInt();

            int[][] trust = new int[e][2];

            for(int i = 0; i < e; i++) {

                System.out.println("trust edge " + (i+1) + " : ");

                trust[i][0] = scanner.nextInt();

                trust[i][1] = scanner.nextInt();
            }

            int answer = obj.findJudge(n, trust);

            System.out.println("Town Judge is " + answer);
        }

}

/*
TIME COMPLEXITY = O(V + E)
SPACE COMPLEXITY = O(V) = O(N)
*/

