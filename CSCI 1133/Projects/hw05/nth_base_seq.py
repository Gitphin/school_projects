# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 5

#==========================================
# Purpose: It finds squared values of a number up to a limit
# Input Parameter(s): base takes in the base number you want to
# be squaring, n is the limit amount of times squared, lst is not
# really a parameter to input, it is just a placeholder
# Return Value(s): (return lst) - It returns the outputs of the function into a
# list, which should follow the pattern b^0+count to the set limit.
# (return nth_base...) -  passes the function recursively, while
# subtracting 1 from n each time it is called.
#==========================================

def nth_base_seq(base, n, lst = None):
    # defines a global variable called count
    global count
    # checks if no lst, which is every time, then creates 
    # an empty list and assigns count to 0
    if lst == None:
        lst = []
        count = 0
    # checks if has reached the set limit and returns completed lst
    if n < 0:
        return lst
    # if n limit not reached, appends the base ^ count and returns the 
    # function, also increases count by 1
    else:
        lst.append(base ** count)
        count += 1
        return nth_base_seq(base, n - 1, lst)



      

