import random

#empty list to store rolls
rolls = []

#simulates 10000 rolls
for i in range(1,10001):
    dice = ((random.randint(1,6)) + random.randint(1,6))
    #appends the roll value to the roll list
    rolls.append(dice)

#prints the count of how many times a num appears in the list
for i in range (2,13):
    print(str(i) + ":", rolls.count(i))
    
