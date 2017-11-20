# -*- coding: utf-8 -*-

class Node(object):
    def __init__(self, key, val):
        self.key   = key
        self.val   = val
        self.left  = None
        self.right = None

class BST(object):

    def __init__(self, root):
        self.root = root

    #递归地查找值
    def __getValue__(self, x, key):
        print x.key
        if x==None:
            return None

        if x.key<key:
            return self.__getValue__(x.right, key)
        elif x.key>key:
            return self.__getValue__(x.left, key)
        else:
            return x.val

    #如果key存在于以x为根节点的子树中则更新它的值，否则将以key和val为键值对的新节点插入到该子树中
    def __putValue__(self, x, key, val):
        if x.key<key:
            if x.right!=None:
                x.right  = self.__putValue__(x.right, key, val)
            else:
                x.right  = Node(key, val)
        elif x.key>key:
            if x.left!=None:
                x.left = self.__putValue__(x.left, key, val)
            else:
                x.left = Node(key, val)
        else:
            x.val   = val



    #查找值
    def _get_(self, key):
        print self.root.key
        return self.__getValue__(self.root, key)

    #插入值
    def _put_(self, key, val):
        self.__putValue__(self.root, key, val)
