/**
Intuition: 
Treat each person’s score as +1 when someone trusts them, and −1 when they trust someone else.
The town judge trusts nobody and is trusted by everyone else (n−1 times +1), so their final score must be n − 1.
Compute these scores and return the person whose score equals n − 1, otherwise return −1.
T.C: O(V+E)
S.C: O(V)
 */
var findJudge = function (n, trust) {
    let inOrder = new Array(n).fill(0);

    for (let [i, j] of trust) {
        inOrder[i - 1]--;
        inOrder[j - 1]++;
    }

    for (let idx = 0; idx < inOrder.length; idx++) {
        if (inOrder[idx] === n - 1) return idx + 1;
    }

    return -1;
};