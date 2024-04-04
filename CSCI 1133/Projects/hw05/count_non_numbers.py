# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 5

#==========================================
# Purpose: The function counts how many non number types are in the
# input_list parameter 
# Input Parameter(s): input_list takes in a list of objects, first is 
# a default value set to be True which changes when the first list is passed.
# Return Value(s): The first return will return 0 if it is the first list, and
# 1 if it is not. The second return will evaluate the object and determine the count.
# The third returns a cut off version of the list in order to evaluate it further. The
# fourth return will give 0 if it is a int, and 1 if it is not an int.
#==========================================

def count_non_numbers(input_list, first = True):
    # tests to see if you can put objects into input_list
    try:
        # checking if it can contain objects
        if 0 in input_list:
            pass
        # counts the lists following the initial, does not count initial if passed
        if len(input_list) == 0:
            return 1 - first
        # takes the first element of object and evaluates it, sets first to false since passed
        if len(input_list) == 1:
            return count_non_numbers(input_list[0], False) + 1 - first
        # cuts off parts of the list and returns to keep evaluating it, sets first to false since passed.         
        else:
            return count_non_numbers(input_list[0], False) + count_non_numbers(input_list[1:], False) - first
    # if not able to contain, it returns 1 if it is not an int, else it returns 0
    except Exception:
        return int(type(input_list) == str)
