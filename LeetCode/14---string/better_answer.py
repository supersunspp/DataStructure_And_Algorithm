import numpy as np
import collections

def findLHS(nums):
    d = collections.defaultdict(int)
    for num in nums:
        d[num] += 1
    res = 0
    for key in d.keys():
        if d[key-1] and d[key]:
            res = max(res, d[key-1]+d[key])
        if d[key] and d[key+1]:
            res = max(res, d[key]+d[key+1])
    return res

a = [2,2,2,2,2,2,2,3,1,0,0,0,3,1,-1,0,1,1,0,0,1,1,2,2,2,0,1,2,2,3,2]

print findLHS(a)
