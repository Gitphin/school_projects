def deep_square(lst):
    

    if lst == []:
        return []

    elif isinstance(lst[0], int): 
        return [lst[0] ** 2] + deep_square(lst[1:])

    elif isinstance(lst[0], list):            
        return [deep_square(lst[0])] + deep_square(lst[1:])
    
        
