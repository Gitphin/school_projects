

def minimum_index(listed, ind):

    minimum = listed[0]
    
    for i in range(ind, len(listed)):
        if listed[i] < minimum:
            minimum = listed[i]
            
    index_min = listed.index(minimum)   
    
    print("The smallest value is", minimum)     
    print("The index of it is",index_min)
    
        