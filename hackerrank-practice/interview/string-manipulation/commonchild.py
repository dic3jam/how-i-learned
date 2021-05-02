def commonChild(s1, s2):
    comChild = ""
    for i in range(len(s1)-1):
        j = 0
        l = len(s2) - 1
        while((s1[i] != s2[j]) and (j < l)):
            j += 1
        if s1[i] == s2[j]:
            comChild += s1[i]
            s2 = s2[j:]
            j = 0
    return len(comChild)

a = "HARRY"
b = "SALLY"

print(commonChild(a,b))
