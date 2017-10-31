
# Merge Sorted Array

## 题目
　　Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.</br>
## 思路
　　从所给两个数组的末尾开始比较，存储位置从第一个数组的m+n-1除开始，依次比较，哪个大，就把哪个数组中的数字</br>
放入存储位置，并把存储位置减1。若比较完毕，nums2数组还有剩余，单独处理</br>
　