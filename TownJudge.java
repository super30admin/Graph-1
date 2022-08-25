
// TimeComplexity : O(m+n) , m : trust array length ;
// space complexity : o(n)
public class TownJudge {
    public int findJudge(int n, int[][] trust) {
    
        int[] inout=new int[n];
        
        for(int[] t:trust){
            inout[t[1]-1]++;
            inout[t[0]-1]--;            
        }
        
        for(int i=0;i<n;i++){
            if(inout[i]==n-1) return i+1;
            
        }
        
        return -1;
        
    }
}
