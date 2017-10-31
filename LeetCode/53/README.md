
# Maximum Subarray

## 题目
　　Find the contiguous subarray within an array (containing at least one number) which has the largest sum. </br>
　　For example, given the array [-2,1,-3,4,-1,2,1,-5,4],</br>
　　the contiguous subarray [4,-1,2,1] has the largest sum = 6.</br>
## 思路
　　此题应使用动态规划的方法进行解决，首先建立状态方程。</br>
　　设b[j]表示第j处，以a[j]结尾的子序列的最大和</br>
　　则b[j] = max(a[j]+b[j-1],a[j]),最后返回b中的最大值即可</br>