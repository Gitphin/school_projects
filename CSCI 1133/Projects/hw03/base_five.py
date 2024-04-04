# Alexander Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 3

def base_five(num):
    #empty list and variable for purposes in while loop
    lst = []
    div = 0
    #while num can still be divided 
    while num // 5 != 0:
        #divides and gets remainder of current num
        div = num % 5
        num = num // 5
        lst.append(div)
    #gets remainder after while loop exited and appends
    extras = num % 5
    lst.append(extras)
    #corrects number by reversing list
    lst.reverse()
    #joins the numbers in list together to create value
    num_five = "The converted number is " + "".join(map(str,lst))

    return num_five
    
