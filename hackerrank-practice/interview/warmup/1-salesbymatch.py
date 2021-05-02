#! /usr/bin/python3
# comprehend the list - if of certain type, move into its own list

def sockMerchant(n, arr):
    y = 0
    for x in range(101):
        tmp = [y for y in arr if y == x]
        if len(tmp) > 1:
            y += len(tmp) // 2

    return y

test = [67,67,67,67,67,67]

print(sockMerchant(6, test))
