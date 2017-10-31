
# Search Insert Position

## 题目
　　Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if</br>
it were inserted in order.</br>
　　You may assume no duplicates in the array.</br>
　　Here are few examples.</br>
　　[1,3,5,6], 5 → 2</br>
　　[1,3,5,6], 2 → 1</br>
## 思路
　　首先对首尾两个数字进行特殊处理，然后使用二分法进行处理。二分法加快了程序运行速度</br>
　　