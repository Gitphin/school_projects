# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 2

#IDLE, READY, SAFE
#start_btn, safe_btn, launch_btn, reset_btn

#global variable assigned to new_state
new_state = "IDLE"

def launch_rocket(current_state, button):

    #brings global variable into function
    global new_state

    #if current_state, button, and new_state are valid, returns 'READY'
    if new_state == "IDLE" and current_state == "IDLE" or current_state == "LAUNCH" and button == "start_btn":
        new_state = "READY" 
        return new_state

    #if current_state, button, or both are invalid, returns 'INVALID'
    if new_state == "IDLE" and current_state != "IDLE" and button == "start_btn":
        new_state == "IDLE"
        return new_state
    if new_state == "IDLE" and current_state == "IDLE" and button != "start_btn":
        new_state == "IDLE"
        return new_state
    if new_state == "IDLE" and current_state != "IDLE" and button != "start_btn":
        new_state == "IDLE"
        return new_state

    #if current_state, button, and new_state are valid, returns 'SAFE', elif reset_btn, returns 'RESET TO IDLE'
    if new_state == "READY" and current_state == "READY" and button == "safe_btn":
        new_state = "SAFE"
        return new_state
    if new_state == "READY" and current_state == "READY" and button == "reset_btn":
        new_state = "IDLE"
        return new_state 
    
    #if current_state, button, or both are invalid, returns 'IDLE'
    if new_state == "READY" and current_state == "READY" and button != "safe_btn" and button != "reset_btn":
        new_state == "IDLE"
        return new_state
    if new_state == "READY" and current_state != "READY" and button == "safe_btn" or button == "reset_btn":
        new_state == "IDLE"
        return new_state
    if new_state == "READY" and current_state != "READY" and button != "safe_btn" and button != "reset_btn":
        new_state == "IDLE"
        return new_state

    #if current_state, button, and new_state are valid, returns 'LAUNCH', elif reset_btn, returns 'RESET TO IDLE'
    if new_state == "SAFE" and current_state == "SAFE" and button == "launch_btn":
        new_state = "LAUNCHED"
        return new_state
    if new_state == "SAFE" and current_state == "SAFE" and button == "reset_btn":
        new_state == "IDLE"
        return new_state

    #if current_state, button, or both are invalid, returns 'IDLE'
    if new_state == "SAFE" and current_state == "SAFE" and button != "launch_btn" and button != "reset_btn":
        new_state == "IDLE"
        return new_state
    if new_state == "SAFE" and current_state != "SAFE" and button == "launch_btn" or button == "reset_btn":
        new_state == "IDLE"
        return new_state
    if new_state == "SAFE" and current_state != "SAFE" and button != "launch_btn" and button != "reset_btn":
        new_state == "IDLE"
        return new_state
    #checks if launched, makes new_state 'IDLE'
    if new_state == "LAUNCH":
        new_state == "IDLE"

    



