# coding=utf8

def swap(a, firstIndex, secondIndex):
    t              = a[firstIndex]
    a[firstIndex]  = a[secondIndex]
    a[secondIndex] = t

#切分函数
def partition(a, start, end):
    i = start
    j = end + 1
    v = a[start]

    while True:
        i = i + 1
        j = j -1
        while a[i]<v:
            if i==end:
                break
            i = i + 1
        while v<a[j]:
            if j==start:
                break
            j = j -1
        if i>=j:
            break
        swap(a, i, j)

    swap(a, start, j)
    return j

#快速排序
def quickSort(a, start, end):
    if end<=start:
        return

    j = partition(a, start, end)
    quickSort(a, start, j-1)
    quickSort(a, j+1, end)

test = [2,1,3,4,5,6,9,7,8,0]
quickSort(test, 0, len(test)-1)

print test