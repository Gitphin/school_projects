# Alexander Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 4



#==========================================
# Purpose: Finds the amount of miles that a member has run
# Input Parameter(s): file_name takes in a file, while member takes
# in a string value to determine amount of miles this member has run
# Return Value(s): If file_name and member are valid, it will return miles,
# which is the miles ran by the member. If the filename is invalid, it returns -1
# and if the member is invalid, it returns 0.
#==========================================
def miles_run(file_name, member):
    try:
        # opens and reads the file, then filters and splits it into a list
        op_file = open(file_name, "r")
        rd_file = op_file.read()
        rp_file = rd_file.replace(","," ")
        lst = rp_file.split()
        # finds the index of the member parameter
        ind = lst.index(member)
        # creates miles for use later
        miles = 0
        # checks if the name is still in the list
        while member in lst:
            # if name still in, finds index of name and gets the miles ran
            ind = lst.index(member)
            miles += int(lst[ind + 1])
            # removes name and miles value from list to not repeat endlessly
            lst.pop(ind)
            lst.pop(ind)
        # closes file and returns number of miles ran by member
        op_file.close()
        return miles 
    # If no miles reported, returns 0
    except ValueError:
        return 0
    # If file not found, returns -1
    except FileNotFoundError:
        return -1
