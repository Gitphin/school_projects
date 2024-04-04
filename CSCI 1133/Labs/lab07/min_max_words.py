
def min_max_words(text):
    mn = 100
    mx = 0
    list1 = list(text.split(" "))
    max_list = []
    min_list = []
    
    if text == "":
        print("Largest / Smallest word(s): '' and ''")
        
    elif len(list1) == 1:
        print("Largest / Smallest word(s):", text, "and",text)
        
    else:
        for i in list1:
            if len(i) >= mx:
                mx = len(i)
            elif len(i) <= mn:
                mn = len(i)
            else:
                continue
            
        for i in list1:
            if len(i) == mx:
                max_list.append(i)
            elif len(i) == mn:
                min_list.append(i)
            else:
                continue
            
    print("Largest / Smallest word(s)", max_list, "and", min_list)

    return(mn, mx)