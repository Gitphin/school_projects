# Alexander Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 4




#==========================================
# Purpose: It flags repeated keys up to a certain defined limit
# Input Parameter(s): phrase takes in a string to evaluate, limit either takes in an integer
# or has a default value of 2, which is the limit on how often a character can repeat before it is flagged
# Return Value(s): A list of repeated characters gets returned 
#==========================================

# max repeat is set to 2 by default, but if a different parameter is set 2 is replaced
def flag_keys(phrase, limit = 2):
    # splits the phrase into a list
    txt = phrase.split()
    # empty list to store flagged characters
    flags = []

    for i in txt:
        for j in i:
            # checks the char count for each word in phrase if they surpass limit
            if i.count(j) > limit:
                # if yes, appends to the list flags
                flags.append(j)
    # turns the flags list into a set to eliminate repeats
    set_flags = set(flags)
    # turns the set_flags set into a sorted list
    repeats = sorted(list(set_flags))
    # returns the list of repeating characters
    return repeats

if __name__ == '__main__':
    print(flag_keys('Heeellooo Wooorld', 2))
    print(flag_keys('Iii aaam bbbattmmman', 2))
    print(flag_keys('Heeeellooo Wooorllld', 3))
    print(flag_keys('Heeellooo Wooorllld'))
    # print(flag_keys("testtt 843", "2")) would not work since limit is not an integer