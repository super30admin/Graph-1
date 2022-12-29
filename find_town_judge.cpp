//Time Complexity O(N)
//Space Complexity O(N)

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
         
        int size = trust.size() ; 
        int arr[n] ;
        for(int i = 0 ; i < n ; i ++){
            arr[i] = 0 ; 
        } 
        for(int i = 0 ; i < size ; i ++){
            int outgoing = trust[i][0] ; 
            int incoming = trust[i][1] ; 
            arr[outgoing - 1] -- ;
            arr[incoming - 1] ++ ;  
        }
        // // for(t : trust){
        // //     int outgoing = t[0] ; 
        // //     int incoming = t[1] ; 
        // //     arr[outgoing - 1]-- ; 
        // //     arr[incoming - 1] ++ ; 
        // // }

        for(int i = 0 ; i < n ; i ++){
            if(arr[i] == n -1){
                return i + 1 ; 
            }
        }

        return -1 ; 
    }
};
