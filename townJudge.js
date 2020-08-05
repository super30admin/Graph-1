/**
 * @param {number} N
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(N, trust) {
    //base
    if(trust == null) return -1;
    let indegrees = new Array(N).fill(0);
    for(let t of trust){
        //decrease the corresponding indegree value of the node of the trustee node
        indegrees[t[0]-1]--;
        //increase the corresponding indegree value of the node of the trusted node
        indegrees[t[1]-1]++;
    }
    
    for(let i = 0; i< indegrees.length; i++){
        if(indegrees[i] == N-1){
            return i+1;
        }
    }
    
    return -1;
    
};

//timeComplexity : O(E(edges)-no of entries in the trust array) + O(N)
//space complexity : O(N)