import java.util.Arrays;
import java.util.HashSet;

public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) { //O(m+n) T.C, O(n) S.C
        int[] indegrees = new int[n+1];
        for(int[] t : trust) {
            indegrees[t[0]]--; //if someone trusts, reduce their indegree
            indegrees[t[1]]++; //is someone is being trusted, increase their indegree
        } //this will help catch both conditions that the judge is also not trusting anyone else

        for(int i=1; i<indegrees.length; i++) { //iterate over indegrees
            if(indegrees[i] == n-1) //check if any value is equal to the number of people in town - judge
                return i; //if yes, return that person as judge
        }

        return -1;
    }

    public static int findJudgeSet(int n, int[][] trust) { //O(m+n) T.C, O(2n) S.C
        if(trust.length == 0 && n == 1) return n; //if only one person in town, he can be judge
        HashSet<Integer> set = new HashSet<>();
        int[] counts = new int[n+1];

        for(int[] t : trust) {
            set.add(t[0]); //add the trusting people to the set
            counts[t[1]]++; //add the count of the number of times a person is being trusted
        }

        for(int i=0; i<n+1; i++) { //iterate over town people
            if(!set.contains(i)) { //if the person is not in set i.e., not trusts anyone
                if(counts[i] == n-1) return i; //check if all other people trust him
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] trust = {{1,2}, {3,2}, {4,2}, {5,2}, {3,4}, {5,4}, {1,4}};

        System.out.println("The judge from a town of " + n + " people with trust relationships: " +
                Arrays.deepToString(trust) + " is: " + findJudge(n, trust));

        trust[2] = new int[]{4, 5};

        System.out.println("The judge from a town of " + n + " people with trust relationships: " +
                Arrays.deepToString(trust) + " is: " + findJudgeSet(n, trust));
    }
}