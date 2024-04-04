import math
import random
    
def farCel():
    cel = 100
    far = (9 / 5) * (cel) + 32
    while cel != far:
        cel = cel - 1
        far = ((9 / 5) * (cel) + 32)
    print("They are equal at", int(cel), "Farenheight and", int(far), "Celsius.")
 

            
             