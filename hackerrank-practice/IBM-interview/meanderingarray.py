def meanderingArray(unsorted):
    array = sorted(unsorted)
    i = 0
    j = len(array) - 1 
    out_array = []
    for x in range(len(array)):
        out_array.append(array[j])
        out_array.append(array[i])
        j -= 1
        i += 1
        if j == i:
            out_array.append(array[j])
            break
        elif j < i:
            break
