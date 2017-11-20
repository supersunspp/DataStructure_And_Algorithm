# -*- coding: utf-8 -*-

from binarySearchTree import Node, BST
root = Node(2, 1)
a    = BST(root)
a._put_(1, 3)
a._put_(3, 3)
print a.root.left.key
print a.root.right.key