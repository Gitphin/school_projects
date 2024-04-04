import random
import math
#cmove = 3
  #             while  pile // 4 != 0:
 #                  cmove = cmove - 1
     #          pile = pile - cmove
           #    print("I choose",cmove,pile, "remains)
                   
def takeAway():
    pile = 21
    
    first = input("Go first (Y/N)? ")
    
    while first == "Y" and pile > 0:
        if pile != 0:
            print(pile, "objects remaining.")
            ymove = int(input("Choose between 1 and 3: "))
            pile = pile - ymove
            win = 1
            print(pile, "Objects remaining")
            cmove = random.randint(1,3)
            pile = pile - cmove
            win = 0
            print("I took", cmove, "There is", pile, "objects.")
        else:
            break
    if win == 1:
        print("You win")
    elif win == 0:
        print("I win")
               