class FindJudge {
    //Time: O(v+e)
    //space: O(v) - extra space for indegree array
    //Did it run successfully on leetcode: yes
    public int findJudge(int n, int[][] trust) {
       
        //stores count of trust for each element
        int[] in = new int[n];
        for(int i=0; i<trust.length; i++){//O(e)
            //get current trust
            int[] curr = trust[i];
            //if current person trusts someone decrease inDegree
            in[curr[0]-1]--;
            //if this person trusted by current person, increase inDegree
            in[curr[1]-1]++;
        }
        //looping through all the person
        for(int i=0; i<n; i++){//O(v)
            //if current person is trusted by everyone
            if(in[i]==n-1) return i+1;
        }
        
        return -1;
    }
}