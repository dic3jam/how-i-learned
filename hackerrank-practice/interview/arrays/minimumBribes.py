def minimumBribes(q):
    offset = 1
    total_bribes = 0
    for x in q:
        if x != q.index(x)+offset:
            total_bribes += x - (q.index(x)+offset)
            if total_bribes > 2:
                print("Too chaotic")
                return
            offset -= 1
    print(total_bribes)

test = [1,3,2,5,4]
minimumBribes(test)
