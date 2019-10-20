
/* Problem Statement: 
Verified on LeetCode
139. Word Break
Medium

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false



 * Best Solution : DYNAMIC PROGRAMMING, 
 * Time Complexity : O(n^2) where n is size of string 
 * Space Complexity : O(n) for dp array 
 */

 class Solution {
public:
    /* Time Complexity :O (n^2), Space complexity : O(n)*/
    bool wordBreak(string s, vector<string>& wordDict) {
        bool final_ans = false;
        int idx, idx2;
        int slen = s.length();
        string temp;
        
        /* Check length of string, if its zero return from here */
        if (!slen) {
            return final_ans;
        }
        /* Create dp array where dp[i] represents whether an element exists of the substring form from 0th to ith index */
        bool dp[slen + 1];
        
        /* initialize dp with false */
        for (idx = 0; idx <= slen; idx++) {
            dp[idx] = false;
        }
        /* first position is true */
        dp[0] = true;
        
        /* starting from each char in the string s,*/
        for (idx = 1; idx <= slen; idx++) {    
            /* move till the end of the string in the dp array */
            for (idx2 = idx; idx2<=slen; idx2++) {
                temp = s.substr(idx-1, idx2-idx+1);
                /* If the dp before this point is true, and the new substring being formed from this is also found in dictionary, then add true at this point */
                if (dp[idx-1] == true && find(wordDict.begin(), wordDict.end(), temp) != wordDict.end()) {
                    dp[idx2] = true;
                }         
            }
        }
#if 0

        /* Method 2 of iteration: here we move in the following manner
         s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        *   c
        *   ca -> ca, a
        *   cat : match, break
        *   cats : match, break
        *   catsa -> atsa, tsa, sa, a
        *   catsan -> atsan, tsan, san, an, a
        *   catsand -> atsand, tsand, sand : true as upto cat is also true, break from here 
        *   catsando -> ... no extra match 
        *   catsandog -> ... dog match but at n char no match, so final answer no match ie false 
        */
        for (idx = 1; idx <= slen; idx++) {
            for (idx2 = 0; idx2 < idx; idx2++) {
                if (dp[idx2] == true && find(wordDict.begin(), wordDict.end(), s.substr(idx2,idx-idx2)) != wordDict.end()) {
                    dp[idx] = true;
                    break;
                }
            }
        }
#endif
        /* if the last element is true in the dp array, that means we have reached the end of string after matching it in the dictionary */
        return dp[slen];
    }
};
