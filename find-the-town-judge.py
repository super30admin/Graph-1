# tc O(V+E), sc O(V).
if len(trust) < n-1:
    return -1
degrees = [0]*n

for u, v in trust:
    degrees[v-1] += 1
    degrees[u-1] -= 1

for idx in range(n):
    if degrees[idx] == n-1:
        return idx+1

return -1