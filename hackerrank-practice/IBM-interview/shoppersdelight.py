def getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, budgeted):
    list_of_lists = [priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops]
    memo = {}
    lists = sorted(list_of_lists, key=len)
    for l1 in lists[0]:
        for l2 in lists[1]:
            for l3 in lists[2]:
                for l4 in lists[3]:
                    if (l1,l2,l3,l4) in memo:
                        continue
                    elif l1 + l2 + l3 + l4 > budgeted:
                        continue
                    else:
                        memo[(l1,l2,l3,l4)] = l1 + l2 + l3 + l4
    return len(memo)



def getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, budgeted):
    combo = 0
    list_of_lists = [priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops]
    lists = sorted(list_of_lists, key=len)
    shorter = []
    longer = []
    for l1 in lists[0]:
        for l2 in lists[1]:
            shorter.append(l1+l2)                    
    for l3 in lists[2]:
        for l4 in lists[3]:
             longer.append(l3+l4)
    shorter = sorted(shorter)
    longer = sorted(longer, reverse=True)
    for i in range(len(shorter)):
        for j in range(len(longer)):
            if shorter[i] + longer[j] < budgeted:
                combo += len(longer[j:])
                     
    return combo
