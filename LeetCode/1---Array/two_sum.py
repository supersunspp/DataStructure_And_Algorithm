def twoSum(self, nums, target):
    i = 0
    for e in nums:
        remainValue = target - e
        if remainValue in nums[i+1:]:
            return [nums.index(e),nums[nums.index(e)+1:].index(remainValue)+nums.index(e)+1]
            break
        i = i + 1
