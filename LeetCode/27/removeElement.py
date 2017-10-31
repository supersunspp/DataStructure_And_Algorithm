def removeElement(nums, val):
    if not nums:
        return 0

    newTail = 0

    for e in nums:
        if e != val:
            nums[newTail] = e
            newTail += 1

    return newTail
