memo = {}
def fib(n):
    if (n in memo): 
        return memo[n]
    elif n <= 2:
        return 1
    else:
    #    breakpoint()
        memo[n] = fib(n-1) + fib(n-2)
        return memo[n]

n = int(input("N = "))
print(fib(n))

