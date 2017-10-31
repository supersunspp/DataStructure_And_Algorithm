# coding=utf8

def swap(a, firstIndex, secondIndex):
    t              = a[firstIndex]
    a[firstIndex]  = a[secondIndex]
    a[secondIndex] = t

def selectSort(a):
    if len(a)<=0:
        return ''
    if len(a)==1:
        return a

    for i in range(0, len(a)):
        minIndex = i
        for j in range(i+1, len(a)):
            if a[j]<a[minIndex]:
                minIndex = j
        swap(a, i, minIndex)
    return a

test = [2,1,3,4,5,6,9,7,8,0]

print selectSort(test)

