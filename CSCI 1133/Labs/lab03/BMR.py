import math

wgt = float(input("Enter your weight in pounds: "))
hgt = float(input("Enter your height in inches: "))
age = float(input("Enter your age in years: "))

morf = int(input("Are you a male or female (1 for male, 2 for female): "))

if morf == 1:
    BMR = 66 + (6.3 * wgt) + (12.9 * hgt) - (6.8 * age)
    choc = BMR / 230
    print("")
    print("You must eat", math.ceil(choc), "chocolate bars")
elif morf == 2:
    BMR = 655 + (4.3 * wgt) + (4.7 * hgt) - (4.7 * age)
    choc = BMR / 230
    print("")
    print("You must eat", math.ceil(choc), "chocolate bars")