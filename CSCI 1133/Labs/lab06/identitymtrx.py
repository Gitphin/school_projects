

def identity(n):
    
    lst = []
    lst2 = []
    
    for i in range(0, n):
        lst.append(lst2)
        
    for i in range(0, n):
        lst2.append(0)
        
        
    for i in range(0, len(lst)):
        for j in range(0, i):
            if i == j:
                lst[i][j] = 1
  #  for j in range(0, n):
        #for k in range(0, n):
        #    if j == k:
          #      lst[j][k] = 1
        
    return lst


    