# -*- coding: utf-8 -*-

class Node(object):
    def __init__(self, key, val, color, left=None, right=None):
        self.key   = color
        self.val   = val
        self.color = color
        self.left  = left
        self.right = right #由其父节点指向它链接的颜色

class binaryBalancedTree(object):
    def __init__(self, root):
        self.root = root

    #判断一个节点的链接是否为红链接
    def _isRed_(self, x):
        if x==None:
            return False

        return x.color=="red"

    def __put__(self, h, key, val):
        if h==None:
            return Node(key, val, "red")

        if key<h.key:
            h.left  = self.__put__(h.left, key, val)
        elif key>h.key:
            h.right = self.__put__(h.right, key, val)
        else:
            h.val = val

        if (self._isRed_(h.right) and (self._isRed_(h.left)==False)):
            h = self._rotateLeft_(h)
        if (self._isRed_(h.left) and self._isRed_(h.left.left)):
            h = self._rotateRight_(h)
        if (self._isRed_(h.left) and self._isRed_(h.right)):
            h = self._flipColor(h)

        return self.root

    def _flipColor(self, h):
        h.color       = "red"
        h.left.color  = "black"
        h.right.color = "black"

    #左旋转
    def _rotateLeft_(self, h):
        x        = h.right
        h.right  = x.left
        x.left   = h
        x.color = h.color
        h.color = "red"

        return x

    #右旋转
    def _rotateRight_(self, h):
        x        = h.left
        h.left   = x.right
        x.color  = h.color
        h.color  = "red"

        return x

    #插入节点
    def _put_(self, key, val):
        self.root = self.__put__(self.root, key, val)
        self.root.color = "black"

    #查找节点
    def _get_(self, x, key):
        if key==None:
            raise Exception("there is a error!!！")
        if x==None:
            return None

        if key<x.key:
            return self._get_(x.left, key)
        elif key>x.key:
            return self._get_(x.right, key)
        else:
            return x.val