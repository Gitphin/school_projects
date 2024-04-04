# Alexander Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 3

#this allows for combinations
import itertools

def triples(num_list, target):
    #empty list to store good combinations
    triples = []
    #finding combinations with a length of 3
    for i in itertools.combinations(num_list, 3):       
        #if the sum of the combination is the target
        if sum(i) == target:
            triples.append(i)
        #else it keeps running
        else:
            continue
    #counts how many triples were found
    triple_count = len(triples)
    #if there are triples found, prints math and returns amnt of triples, else returns 0
    if len(triples) >= 1: 
        for i in range(len(triples)):
            print(str(triples[i][0]), "+", str(triples[i][1]), "+", str(triples[i][2]), "=", target)  
        return triple_count
    else:
        return triple_count
