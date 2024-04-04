
def zellerMethod(m, d, y):
       day = ((d + 5 + ((26 * (m + 1)) // 10) + ((5 * (y % 100)) // 4) + ((21 * (y // 100)) // 4)) % 7)    
       return day
def main():
    m = float(input("Enter a month: "))
    d = float(input("Enter a day: "))
    y = float(input("Enter a year: "))
    zel_results = (zellerMethod(m, d, y))
    print(zel_results)

