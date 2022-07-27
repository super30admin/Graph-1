// Time Complexity : O(V+E) where V are vertices and E are edges
// Space Complexity : O(1)

/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(n, trust) {
    let trustArray = new Array(n+1).fill(0);
    if(n===1) return 1;
    for(let t of trust) {
        trustArray[t[0]]--;
        trustArray[t[1]]++;
    }
    for(let i = 0; i < trustArray.length; i++) {
        if(trustArray[i] === n-1) return i;
    }
    return -1;
};