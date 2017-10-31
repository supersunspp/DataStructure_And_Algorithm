# coding=utf8

def swap(a, firstIndex, secondIndex):
    t              = a[firstIndex]
    a[firstIndex]  = a[secondIndex]
    a[secondIndex] = t

def insertSort(a):
    if len(a)<=0:
        return ''
    if len(a)==1:
        return a

    for i in range(1, len(a)):
        j = i
        while (j>0) and (a[j]<a[j-1]):
            swap(a, j, j-1)
            j -= 1

    return a

test = [2,1,3,4,5,6,9,7,8,0]

print insertSort(test)

