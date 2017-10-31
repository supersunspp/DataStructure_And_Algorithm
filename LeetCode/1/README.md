
# Two Sum

## 题目
　　Given an array of integers, return indices of the two numbers such that they add up to a specific target.</br>
　　You may assume that each input would have exactly one solution, and you may not use the same element twice.</br>
　　Example 1: </br>
　　Given nums = [2, 7, 11, 15], target = 9,</br>
　　Because nums[0] + nums[1] = 2 + 7 = 9, </br>
　　return [0, 1].</br>
## 思路
　　从所给数组的第一个元素开始审查，对于每一个元素，用target减去这个元素得到一个值，查看这个值是否在数组的剩余
部分中出现，如出现，则满足要求。</br>