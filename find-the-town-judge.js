// Time Complexity : O(M) where M is the length of the trust array
// Space Complexity : O(N) where N is the number of people
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number} N
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(N, trust) {
    if (!N || !trust) return -1;
    
    let degrees = new Array(N).fill(0);
    // Add 1 for someone trusting
    // Subtract 1 for trusting someone
    for (const truster of trust) {
        degrees[truster[0] - 1]--;
        degrees[truster[1] - 1]++;
    }
    // The only person who can have N - 1 people trusting is the
    // judge
    for (const [index, truster] of degrees.entries()) {
        if (truster == N - 1) return index + 1;
    }
    return -1;
};
