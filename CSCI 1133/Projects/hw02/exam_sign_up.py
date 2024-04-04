# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 2

# This will define a function called 'oral_exam_sign_up', with 3 parameters
def oral_exam_sign_up(start_time, end_time, lunch_time):
    if start_time > end_time:
        #adjusts time so it wont go to 13
        end_time += 12
        
    slots = 0
    #multiply by 60 for minute values
    for i in range(start_time * 60, end_time * 60, 15):
        #checks if it is not lunch time
        if not (i // 60 == lunch_time and i % 60 < 30):
            #counts amount of slots 
            slots += 1
            #t1 is start time for slot
            #t2 is end time for slot 
            #creates a 10 minute time gap
            t1 = i
            t2 = i + 10
            #checks to make sure it doesnt go to 13
            if t1 >= 13 * 60: 
                t1 -= 12 * 60
            if t2 >= 13 * 60: 
                t2 -= 12 * 60
            #converts to string, zfill makes it 2 digits, prints out slot times
            print(str(t1 // 60).zfill(2) + ":" + str(t1 % 60).zfill(2) + " - " + str((t2) // 60).zfill(2) + ":" + str((t2) % 60).zfill(2))
            #creates a 5 minute gap between slots
            t1 -= 5
    return slots

