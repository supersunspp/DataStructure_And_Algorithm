
# Range Addition II

## 题目
　　Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.</br>
　　Do not allocate extra space for another array, you must do this in place with constant memory.</br>
　　For example：</br>
　　Given input array nums = [1,1,2],</br>
　　Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter</br>
what you leave beyond the new length.</br>
## 思路
　　因为数组是排好序的，只需要比较相邻元素是不是相同即可。所以这里采取的办法是依次比较相邻元素，去除掉相同元素。</br>
　　