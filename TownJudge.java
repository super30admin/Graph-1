public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        if(trust==null) return -1;
        int []temp=new int[n];
        for(int arr[]:trust){
            temp[arr[0]-1]--;
            temp[arr[1]-1]++;
        }
       
   
        for(int i=0;i<temp.length;i++){
            if(temp[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String ...args){
        Solution obj=new Solution();
        int [][] trust={{1,3},{2,3},{3,1}};
        System.out.println(obj.findJudge(4, trust));
    }
}