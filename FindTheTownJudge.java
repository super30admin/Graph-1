package Dec20;

class FindTheTownJudge {
	
	/*
	 * Time complexity: O(n) because we are iterating through the given trust array of size n.
	 * Space complexity: O(n) where n is no.of nodes in the array
	 * 
	 * Approach: 
	 * Degrees array where every element in the array is a representative for degree for every person.
	 */
	
    public int findJudge(int N, int[][] trust) {
        
        //degrees array to hold incoming and outgoing edges from every node where edge is trust and node is people.
        int[] degrees = new int[N];
        for (int[] t: trust) {
            // for every pair present in trust array:
            // increase trust of destination by 1
            // and decrease trust of source by 1 
            degrees[t[0] - 1]--;
            degrees[t[1] - 1]++;
        }
        for (int i = 0; i < N ;i++) {
            if (degrees[i] == N-1) {
                return i+1;
            }
        }
        return -1;
    }
}