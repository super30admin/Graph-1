class Solution(object):
    def findJudge(self, n, trust):
        """
        Time Complexity - O(n + t), t --> number of trust relationships in the input.
        Space Complexity - O(n), n --> number of people in the town. 

        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        # Step 1: Initialize an array to keep track of the number of people trusting and being trusted (indegrees).
        # The array will have n elements, each representing the number of times a person is trusted (positive) or
        # trusting others (negative). The index of the array corresponds to the person (index + 1).
        indegrees = [0] * n

        # Step 2: Check if the trust list is empty (None).
        if trust is None or len(trust) == 0:
            # If there are no trust relationships and n=1, return the only person in the town (index 1) as the judge.
            if n == 1:
                return 1
            else:
                return -1

        # Step 3: Iterate through the trust list and update the indegrees array accordingly.
        for tr in trust:
            # Since the person tr[0] trusts someone, decrease their trust count.
            indegrees[tr[0] - 1] -= 1

            # Since the person tr[1] is trusted by someone, increase their trust count.
            indegrees[tr[1] - 1] += 1

        # Step 4: Iterate through the indegrees array to find the person who is trusted by (n-1) people (the judge).
        for i in range(n):
            if indegrees[i] == n - 1:
                # Return the judge's index (index + 1).
                return i + 1

        # Step 5: If no judge is found (n-1 trusts for anyone), return -1.
        return -1
