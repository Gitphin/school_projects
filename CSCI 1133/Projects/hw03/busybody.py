# Alexander Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 3

def busybody(list_of_clubs):
    #empty lists to store for later
    lst = []
    busybody = []
    #runs through the names
    for i in (list_of_clubs):
        for j in i:
            #makes a unique list
            if j not in lst:
               lst.append(j)
    #checks if the name is or not in for all the clubs 
    for name in (lst):
        for club in (list_of_clubs):
            if name not in club:
                break
        #appends the name to names if else
        else:
            busybody.append(name)

    return busybody


