# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 1

#asks user for amount of change
change = int(input("Amount of change: "))

#some variables created to calculate change needed for the coins
ch_half = change % 50
ch_quart = ch_half % 25
ch_dime = ch_quart % 10
ch_nickel = ch_dime % 5
ch_penny = ch_nickel % 1

#checking to see if half dollars needed
if change >= 50:
    print(change // 50, "half dollars")
   
#checking to see if quarters needed, prints amnt
if ch_half >= 25:
    print(ch_half // 25, "quarters")
   
#checking to see if dimes needed, prints amnt
if ch_quart >= 10:
    print(ch_quart // 10, "dimes")
   
#checking to see if nickels needed, prints amnt
if ch_dime >= 5:
    print(ch_dime // 5, "nickels")
    
#checking to see if pennies needed, prints amnt
if ch_nickel >= 1:
    print(ch_nickel // 1, "pennies")