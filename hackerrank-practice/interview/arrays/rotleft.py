def rotleft(a, d):
    for n in range(d):
        a.append(a.pop(0))
    return a

test = [1,2,3,4,5,6,7,8]
print(rotleft(test, 7))
