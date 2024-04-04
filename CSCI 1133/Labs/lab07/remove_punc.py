def remove_punc(text, punc):
    list1 = list(punc)
    list2 = []
    print(list1)
    for i in text:
        if i in list1:
            continue
        else:
            list2.append(i)
            
    new_str = ''.join(list2)
    
    return new_str

    
