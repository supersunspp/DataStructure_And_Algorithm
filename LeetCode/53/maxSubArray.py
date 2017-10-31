def maxSubArray(nums):
    b = []
    if len(nums)==0:
        return 0

    b.append(nums[0])
    mam = b[0]

    for i in range(1,len(nums)):
        b.append(max(nums[i],b[i-1]+nums[i]))
        if mam<b[i]:
            mam=b[i]

    return max(b)
