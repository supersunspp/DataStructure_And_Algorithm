import numpy as np

def findLHS(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    i= 0
    length = 0
    longest_armonious = []
    while i<(len(nums)-1):
        num_list = []
        num_list_left = []
        num_list_right = []
        num_list_left.append(nums[i])
        num_list_right.append(nums[i])
        j = i + 1
        while j<len(nums):
            if (nums[i] - nums[j])==1 or (nums[i] - nums[j])==0:
                num_list_left.append(nums[j])
            if (nums[i] - nums[j])==-1 or (nums[i] - nums[j])==0:
                num_list_right.append(nums[j])
            j = j + 1
        if len(num_list_left) > len(num_list_right):
            num_list = num_list_left
        else:
            num_list = num_list_right
        if len(num_list)>length:
            temp = np.array(num_list)
            if (temp.max()-temp.min()) == 1:
                longest_armonious = num_list
                length = len(num_list)
        i = i + 1
    return len(longest_armonious)

a = [2,2,2,2,2,2,2,3,1,0,0,0,3,1,-1,0,1,1,0,0,1,1,2,2,2,0,1,2,2,3,2]

print findLHS(a)
