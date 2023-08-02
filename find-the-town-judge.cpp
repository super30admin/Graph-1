// Time Complexity : O(n+t)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <vector>

using namespace std;

class Solution {
public:
    int findJudge(int N, std::vector<std::vector<int>>& trust) {
        if (trust.empty()) {
            return N == 1 ? 1 : -1;
        }

        std::vector<int> t(N, 0);
        std::vector<int> trusted(N, 0);

        for (const auto& pair : trust) {
            int a = pair[0];
            int b = pair[1];
            t[a - 1]++;
            trusted[b - 1]++;
        }

        for (int i = 0; i < N; i++) {
            if (t[i] == 0 && trusted[i] == N - 1) {
                return i + 1;
            }
        }

        return -1;
    }
};
