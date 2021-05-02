
# Bubblesort.py
# takes as input an array of unsorted ints, returns a sorted array

def bubblesort(arr):
    for x in range(len(arr) - 1):
        for y in range(len(arr) - 1):
            if arr[y] > arr[y+1]:
                z = arr[y] 
                arr[y] = arr[y+1]
                arr[y+1] = z


# main

arr = [1,9,20,4,5,1,78,54,0,23]

bubblesort(arr)

print(arr)
