#This code is for the odds and evens game option

import random


def play_odds_evens():
    
    side = input("Please enter Odd or Even: ")
    
    ocount = 0
    ecount = 0
    tcount = 5
    
    if side == 'Odd' or side == 'Even':
        
        while tcount > 0:
            
            num = int(input("Please enter 1, 2, or 3: "))
            comp = random.randint(1,3)
            result = num + comp   
            
            if not 1 <= num <= 3:
                
                print("Invalid entry, number must be a number between 1 and 3")
                
            if result % 2 == 0 and 1 <= num <= 3:
                    
                ecount += 1
                print(result, "is drawn, Evens wins this round!")
                print("Odds:", ocount, "- Evens:", ecount)
                tcount -= 1
                    
            elif result % 2 != 0 and 1 <= num <= 3:
                    
                ocount += 1
                print(result, "is drawn, Odds wins this round!")
                print("Odds:", ocount, "- Evens:", ecount)
                tcount -= 1
            
                
        if ocount >= ecount and side == 'Odd':
            
            print("Odds has won more rounds, you win!")
            
        elif ocount <= ecount and side == 'Odd':
            
            print("Evens has won more rounds, you lost!")
        
        elif ecount >= ocount and side == 'Even':
            
            print("Evens has won more rounds, you won!")
            
        elif ecount <= ocount and side == 'Even':
            
            print ("Odds has won more rounds, you lost!")
            
            
    elif side != 'Odd' or side != 'Even':
        
        print("Invalid input, must enter either 'Odd' or 'Even'.")
            
              
        
        
    