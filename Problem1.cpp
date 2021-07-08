
/* Problem Statement: 
Verified on LeetCode
997. Find the Town Judge
Easy

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

 

Note:

    1 <= N <= 1000
    trust.length <= 10000
    trust[i] are all different
    trust[i][0] != trust[i][1]
    1 <= trust[i][0], trust[i][1] <= N




 * Solution 1 : using Indegree and Outdegree concept (combined data )
 * Time Complexity : O(n) where n is edge list length specifying x1->x2 relationship 
 * Space Complexity : O(N) for  N = total number of person

* Solution 2 : using Hashmap and Hashset
 * Time Complexity : O(n) where n is edge list length specifying x1->x2 relationship 
 * Space Complexity : O(N) for  N = total number of person
 */

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        /* Specify length of the trust edge list size */
        int t_size = trust.size();
        int town_judge = -1;
        int idx = 0, idx1 = 0;
        
        /* If trust size is 0 there are 2 cases, if no person is there, return -1 else return N */
        if (t_size == 0) {
            if (N == 0)
                return town_judge;
            else {
                return N;                
            }

        }
        /* Store degree of each person where 0th index is not used as person starts with index 1 */
        int degree[N+1];
        
        /* initialize with 0 */
        for (idx = 0; idx < N+1; idx++) {
            degree[idx] = 0;
        }
        /* For each trust pair, get the indegree and outdegree info, if indegree to a person, then add it else subtract it */
        for (idx = 0; idx < t_size; idx++) {
            degree[trust[idx][0]]--; /* outdegree subtract */
            degree[trust[idx][1]]++; /* indegree add */
        }
        /* At the end if a person has final degree value as N - 1, that means there are only indegrees and no outdegrees */
        for (idx = 1; idx < N+1; idx++) {
            if (degree[idx] == N-1) {
                return idx;
            }
        }
        /* If still no town judge is found, return -1 ie default vlaue of town judge */
        return town_judge;
    }

    int findJudge_ver2(int N, vector<vector<int>>& trust) {
        int t_size = trust.size();
        int town_judge = -1;
        int idx = 0, idx1 = 0;
        
        if (t_size == 0) {
            if (N == 0)
                return town_judge;
            else {
                return N;                
            }

        }
        /* store potential judges with their indegree count */
        unordered_map<int,int> potential_judges;
        /* trust list which should be unique so taking hash set */
        unordered_set<int> trust_unique_list;
        
        
        for (idx = 0; idx < t_size; idx++) {
            /* Count indegree for that potential judge */
            if ((potential_judges.find(trust[idx][1])) != potential_judges.end()) {
                potential_judges[trust[idx][1]] = potential_judges[trust[idx][1]] + 1;
            } else {
                potential_judges[trust[idx][1]] = 1;
            }
            trust_unique_list.insert(trust[idx][0]);
        }

        /* iterate over the potential judges and if not found in trust list, check if its indegree is N-1 then give that answer */
        unordered_map<int,int>::iterator iter;      
        for (iter = potential_judges.begin(); iter != potential_judges.end(); iter++) {
            if (trust_unique_list.find(iter->first) == trust_unique_list.end() && (iter->second == N - 1)) {
                return iter->first;
            }
        }        
        return town_judge;
    }
};
