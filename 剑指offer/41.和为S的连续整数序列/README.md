## 和为S的连续正数序列
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不</br>
满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数</br>
和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
## 思路
初始化small=1，big=2;</br>
small到big序列和小于sum，big++;大于sum，small++;</br>
当small增加到(1+sum)/2是停止