## 复杂链表的复制
输入一个复杂链表(每个节点中有节点值，以及两个指针，一个指针指向下一个节点，另一个特殊指针指向任意一个节点)</br>
,返回结果为复制后复杂链表的head。
## 思路
1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面；</br>
2、遍历链表，A1->random = A->random->next;</br>
3、将链表拆分成原链表和复制后的链表。</br>