from quicksort import *

def binsearch(arr, q):
    low = 0
    high = len(arr) - 1
    while low <= high:
        mid = (high+low) // 2
        if arr[mid] > q:
            high = mid - 1
        elif arr[mid] < q:
            low = mid + 1
        else:
            return mid
    return -1


print(binsearch(quicksort(test, 0, (len(test)-1)), 24))

