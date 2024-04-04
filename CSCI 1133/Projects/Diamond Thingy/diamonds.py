
def diamonds(num):
    mid = (num // 2) + (1 if num % 2 == 1 else 0)
    m = 0

    for i in range(num):
        a = ""
        if i >= mid:
            m += 1
        else:
            m -= 1
        n = abs(m)

        for j in range(num):
            if j == 0 and mid - n == 0:
                a += " *"
            elif j > mid - n and j < mid + n + (1 if num % 2 == 0 else 0):
                a += "*"
            else: 
                a += " "

        if i == mid - 1 and num % 2 == 0:
            print(a)
        print(a)

diamonds(25)




