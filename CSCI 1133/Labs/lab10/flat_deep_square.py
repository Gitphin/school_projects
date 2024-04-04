def flat_deep_square(lst):
    

    if lst == []:
        return []

    elif isinstance(lst[0], int): 
        return [lst[0] ** 2] + flat_deep_square(lst[1:])
    
    elif isinstance(lst[0], list):            
        return flat_deep_square(lst[0]) + flat_deep_square(lst[1:])
    
        

