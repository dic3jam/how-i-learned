def commonSubstring(a, b):
    for i in range(len(a)):
        for ea in a[i]:
            if ea in b[i]:
                print("YES")
                break
        else:
            print("NO")

a = ["hello","hi"]
b = ["world","bye"]

commonSubstring(a,b)
