// ## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function (n, trust) {
    if (n === 0 || trust === null)
        return -1;
    if (trust.length === 0 && n === 1)
        return n;
    let indegree = new Array(n + 1);
    indegree.fill(0);
    // Create an array to monitor the trust for each person.
    // Add 1 if a person is trusted, -1 if they trust someone
    for (let i = 0; i < trust.length; i++) {
        indegree[trust[i][1]]++;
        indegree[trust[i][0]]--;
    }
    // If the number is same as n-1, we found the town judge
    for (let i = 0; i < indegree.length; i++) {
        if (indegree[i] === n - 1)
            return i;
    }
    return -1;
};