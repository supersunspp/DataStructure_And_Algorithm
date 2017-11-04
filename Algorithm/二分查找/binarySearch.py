def binarySearch(a, key):
    low  = 0
    high = len(a) - 1

    if key==a[low]:
        return low
    if key==a[high]:
        return high
    if key<a[low] or key>a[high]:
        return

    while (high-low)>1:
        mid = low + (high - low) / 2
        if a[mid]>key:
            high = mid - 1
        elif a[mid]<key:
            low  = mid + 1
        else:
            return mid

    return

a = [1,2,3,4,5]
print binarySearch(a,3)