

def sieve(n):
    
    crossed = []
    
    for i in range(2, n):
        if i % 2 == 0:
            crossed.append(i)
    print(crossed)