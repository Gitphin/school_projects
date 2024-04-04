# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 5

#==========================================
# Purpose: It finds the minimum and maximum hours worked per week by a list of employees
# Input Parameter(s): It takes in a dictionary {emp_diction}, which takes the name 
# of the employee and their hours worked per week that is documented
# Return Value(s): a dictionary called "dic" gets returned which shows the min and max
# number of hours worked by each employee. Additionally, if the dictionary is empty it returns
# an empty dictionary.
#==========================================

def min_max_hours(emp_diction):
    # creates an empty dic to store values
    dic = {}
    # checks if an empty dic, returns the empty dic
    if emp_diction == {}:
        return {}
    # if not empty dic
    else: 
        # parses through the keys and values of emp_diction
        for k, v in emp_diction.items():
            # if the values are empty, returns a min/max 0,0
            if emp_diction[k] == []:
                dic[k] = (0,0)
            # if has values, returns the min and max of them
            else:
                dic[k] = (min(v), max(v))
    # returns a dictionary of employees and their min/max hours worked
    return dic


       
