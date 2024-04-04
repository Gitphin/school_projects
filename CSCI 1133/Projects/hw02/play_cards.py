# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 2


import random

def play_cards():
    #variables to call later in function
    p_score = 0
    o_score = 0
    tcount = 0
    
    print("Game Starts!")
    #defines player cards and opponent cards
    pcards = [random.randint(1,9) for i in range(3)]
    ocards = [random.randint(1,9) for i in range(3)]
    #prints out players cards
    print("Player's cards:", pcards[0], pcards[1], pcards[2])
    #empty list to append used cards in the function
    used_cards = []
    
    while tcount < 3 and o_score < 2 and p_score < 2:
        #asks user to input an index
        turn = int(input("Enter player card index: "))
        #checks if a used card, prints if true
        if turn in used_cards:
            print("Invalid entry, cannot use same card twice")
            continue
        #checks if valid range, prints if true
        if turn > 3 or turn < 1:
            print("Invalid index, please try something else")
        #if player has larger value, they win round
        if pcards[(turn - 1)] > ocards[(turn - 1)]:
            tcount += 1
            p_score += 1
            print(pcards[(turn - 1)], "is greater than", ocards[(turn - 1)],"- Player wins the round")
            print("Score: Player has", p_score,"and Computer has", o_score)
            used_cards.append(turn)
        #if computer has larger value, they win round
        elif pcards[(turn - 1)] < ocards[(turn - 1)]:
            tcount += 1
            o_score += 1
            print(pcards[(turn - 1)], "is less than", ocards[(turn - 1)],"- Computer wins the round")
            print("Score: Player has", p_score,"and Computer has", o_score)
            used_cards.append(turn)
        #if they have the same, nobody wins round, turn counter goes up
        elif pcards[(turn - 1)] == ocards[(turn - 1)]:
            print("Both have the same value!")
            tcount += 1

    #if player wins with 2
    if p_score == 2:
        print("Player wins the game")
    #if player wins with more on three turns
    elif tcount == 3 and p_score > o_score:
        print("Player wins the game")
    #if computer wins with 2
    elif o_score == 2:
        print("Computer wins the game")
    #if computer wins with more on three turns
    elif tcount == 3 and p_score < o_score:
        print("Computer wins the game")
    #if they both scored the same value of points, tie
    elif tcount == 3 and p_score == o_score:
        print("The game is a tie!")

play_cards()

