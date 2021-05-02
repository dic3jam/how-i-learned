# divide
# merge
# lolz

def mergesort(array):
    if(len(array) <= 1):
        return array
    mid = len(array) // 2
    larray = array[:mid]
    rarray = array[mid:]
    larray = mergesort(larray)
    rarray = mergesort(rarray)
    return merge(larray, rarray)

def merge(larray, rarray):
    i = j = k = 0
    out_array = []

    while i < len(larray) and j < len(rarray):
        if larray[i] < rarray[j]:
            out_array.append(larray[i])
            i += 1
        else:
            out_array.append(rarray[j])
            j += 1

    while i < len(larray):
        out_array.append(larray[i])
        i += 1
    while j < len(rarray):
        out_array.append(rarray[j])
        j += 1

    return out_array

# main

test = [98,43,25,104,2,3,4]

print(mergesort(test))
