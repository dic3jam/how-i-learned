
def partition(array, low, high):
    pi = array[high]
    i = low - 1
    for x in range(low, high):
        if(array[x] < pi):
            i += 1
            k = array[i]
            array[i] = array[x]
            array[x] = k

    z = array[i+1]
    array[i+1] = array[high]
    array[high] = z
    return i+1

def quicksort(array, low, high):
    if low < high:
        p = partition(array, low, high)
        #lower
        quicksort(array, low, p-1)
        #upper
        quicksort(array, p+1, high)

    return array

test = [4,7,2,1,10,32,1,1,29,74,23,24,67]
print(quicksort(test, 0, len(test)-1))
