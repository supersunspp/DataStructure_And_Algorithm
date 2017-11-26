# -*- coding: utf-8 -*-
class _ListNode(object):
    def __init__(self, key):
        self.key  = key
        self.next = None

#拉链法解决碰撞散列表
class HashMap(object):
    def __init__(self, tableSize):
        self._table = [None] * tableSize
        self.num    = 0

    def __len__(self):
        return self.num

    def _hash(self, key):
        return abs(hash(key)) % len(self._table)

    def getItem(self, key):
        j    = self._hash(key)
        node = self._table[j]
        while node is not None and node.key!=key:
            node = node.next
        if node is None:
            raise KeyError, 'KeyError' + repr(key)

        return node

    #每次都插入在链表头部
    def insert(self, key):
        try:
            self[key]
        except KeyError:
            j    = self._hash(key)
            node = self._table[j]
            self._table[j] = _ListNode(key)
            self._table[j].next = node
            self.num += 1

    def delItem(self, key):
        j    = self._hash(key)
        node = self._table[j]
        if node is not None:
            if node.key==key:
                self._table[j]=node.next
                self.num -= 1
            else:
                while node.next!=None:
                    pre  = node
                    node = node.next
                    if node.key==key:
                        pre.next = node.next
                        self.num -= 1
                        break