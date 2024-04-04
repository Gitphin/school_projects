def max_value(lst):

    if len(lst) == 1:
       return lst[0]

    else:
        if lst[0] >= lst[1]:
            del lst[1]
            return max_value(lst)
        
        elif lst[1] >= lst[0]:
            del lst[0]
            return max_value(lst)

