def findJudge(n, trust):
    if n == 1 and not trust:
        return 1  # Special case: If there's only one person and no trust relationships, they are the judge
    
    trust_balance = [0] * (n + 1)
    
    for a, b in trust:
        trust_balance[a] -= 1  # Person a trusts someone (decrease their trust balance)
        trust_balance[b] += 1  # Person b is trusted by someone (increase their trust balance)
    
    for i in range(1, n + 1):
        if trust_balance[i] == n - 1:
            return i
    
    return -1  # No judge found

#time = O(T + N), where T is the number of trust relationships, and N is the number of people. 
#space = O(N)