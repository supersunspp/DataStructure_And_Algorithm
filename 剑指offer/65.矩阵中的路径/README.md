## 矩阵中路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以</br>
从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如</br>
果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
## 思路
用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归。