# coding=utf8

#两个子数组合并
def merge(a, start, mid, end):
    i = start
    j = mid + 1
    aux = [0 for n in range(len(a)+1)]

    for k in range(start, end+1):
        aux[k]= a[k]

    for k in range(start, end+1):
        if i>mid:
            a[k] = aux[j]
            j += 1
        elif j>end:
            a[k] = aux[i]
            i += 1
        elif aux[j]<aux[i]:
            a[k] = aux[j]
            j += 1
        else:
            a[k] = aux[i]
            i += 1

#自顶向下的归并排序
def topTobottomSort(a, start, end):
    if end<=start:
        return
    mid = start + (end - start) / 2
    topTobottomSort(a, start, mid)
    topTobottomSort(a, mid+1, end)
    merge(a, start, mid, end)

#自底向上的归并排序
def bottomTotop(a):
    length = len(a)
    aux = [0 for n in range(length)]

    sz = 1
    while sz<length:
        start = 0
        while start<(length-sz):
            merge(a, start, start+sz-1, min(start+sz+sz-1, length-1))
            start += sz + sz
        sz = sz + sz

test = [2,1,3,4,5,6,9,7,8,0]

topTobottomSort(test, 0, len(test)-1)

print test