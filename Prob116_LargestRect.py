#Time Complexity :o(n)
# Space Complexity :o(1)
# Did this code successfully run on hackerank : yes
#Any problem you faced while coding this : no

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'largestRectangle' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY h as parameter.
#

def largestRectangle(h):
    # Write your code here
    h += [0]
    s = []
    LRec = 0
    for i in range(0, len(h)):
        j = i
        while len(s) > 0 and s[-1][0] >= h[i]:
            val, j = s.pop()
            LRec = max(LRec, (i - j) * val)
        s.append([h[i], j])
    return LRec


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    h = list(map(int, input().rstrip().split()))

    result = largestRectangle(h)

    fptr.write(str(result) + '\n')

    fptr.close()
