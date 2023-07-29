#Time complexity is O(V+E)
#Space complexity is O(V) where V is the unique no of people
#Code ran successfully on leet code
#No issues faced while coding
class Solution(object):
    def findJudge(self, n, trust):
        """
        :type n: int
        :type trust: List[List[int]]
        :rtype: int
        """
        #creating an array of size n
        arr=[0 for i in range(n)]
        #We will be iterating through each value in the trust array
        for j in trust:
            #We will reducing the value of person who is going to trust
            arr[j[0]-1]-=1
            #We will be increasing the value of the person whose is being trusted
            arr[j[1]-1]+=1
        #We will iterate through arr and we will find the person for whom the valaue is equal to n-1
        for k in range(0,n):
            if(arr[k]==n-1):
                return k+1
        #If there is no one judge, we will return -1
        return -1