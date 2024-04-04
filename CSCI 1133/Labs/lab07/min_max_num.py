

def min_max_nums(text):

    mn = 100
    mx = 0
    list1 = list(text.split(" "))

    if text == "":
        print("Min/Max",[0,0])
        
    else:
        for i in list1:
            if len(i) >= mx:
                mx = len(i)
            elif len(i) <= mn:
                mn = len(i)
            else:
                continue
            
    print("Min/Max:", mn, "and", mx)
    
    return(mn, mx)
                
    