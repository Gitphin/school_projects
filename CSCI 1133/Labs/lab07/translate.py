
def pig(text):
    
    list2 = []
    list1 = list(text.split(" "))
    vowels = ['a', 'e', 'i', 'o', 'u']
    curr = " "
    
    for i in list1:
        
        if (i[0]).lower() not in vowels:
            
            new = (i[1:] + i[0] + "ay").lower()
            list2.append(new)
            
        else:
            new = i + "way"
            list2.append(new)
            
    to_pig = (curr.join(list2))
    
    print(to_pig)
    return to_pig
        