# coding=utf8

def swap(a, firstIndex, secondIndex):
    t              = a[firstIndex]
    a[firstIndex]  = a[secondIndex]
    a[secondIndex] = t

def hillSort(a):
    if len(a)<=0:
        return ''

    length = len(a)
    h = 1
    while h<(length/3):
        h = h * 3 + 1

    while h>=1:
        for i in range(h, length):
            j = i
            while (j>=h) and (a[j]<=a[j-h]):
                swap(a, j, j-h)
                j -= h
        h = h / 3

    return a

test = [2,1,3,4,5,6,9,7,8,0]

print hillSort(test)