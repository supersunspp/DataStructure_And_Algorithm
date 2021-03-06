## 数组中最小的k个数
输入n个整数，找出其中最小的k个数。
## 思路
方法一：快排思想</br>
利用快速排序中的获取分割（中轴）点位置函数getPartitiion。</br>
基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边，比第k个数字大的所有数字都位于数组</br>
的右边。调整之后，位于数组左边的k个数字就是最小的k个数字（这k个数字不一定是排序的）。O(N)</br>
方法二：堆排序</br>
利用堆排序，O(N logK)，适合处理海量数据</br>
(1) 遍历输入数组，将前k个数插入到推中；</br>
(2) 继续从输入数组中读入元素做为待插入整数，并将它与堆中最大值比较：如果待插入的值比当前已有的最大值小，则</br>
用这个数替换当前已有的最大值；如果待插入的值比当前已有的最大值还大，则抛弃这个数，继续读下一个数。</br>
这样动态维护堆中这k个数，以保证它只储存输入数组中的前k个最小的数，最后输出堆即可。</br>