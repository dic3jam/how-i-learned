import sys

print("Number: ")
cred = input()

try:
    credit = [int(x) for x in str(cred)]
except:
    print("INVALID")
    exit(1)

#American Express 34 37
#MasterCard 51, 52, 53, 54, or 55
#Visa 4

if((credit[0] == 3) and ((credit[1] == 4) or (credit[1] == 7))):
    card = "AMEX"
elif((credit[0] == 5) and (credit[1] <= 5)):
    card = "MASTERCARD"
elif(credit[0] == 4):
    card = "VISA"
else:
    print("INVALID")
    exit(1)

#reverse reverse!
credit.reverse()
 
sectolast = 0

#every other digit starting from second to last
for x in range(1, len(credit), 2):
  
    tmp = credit[x] * 2
 
    tmpex = 0

    if tmp > 10:
        tmpex = tmp % 10 
        tmp = 1
 
    sectolast = sectolast + tmp + tmpex

firtolast = 0

#every other digit starting from the last
for x in range(0, len(credit), 2):

    tmp = credit[x] 

    firtolast = firtolast + tmp

if(((sectolast+firtolast) % 10) == 0):
    print(card)
else:
    print("INVALID")
    exit(1)











    




