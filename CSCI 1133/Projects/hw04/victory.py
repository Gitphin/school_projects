# Alexander Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 4

#==========================================
# Purpose: Checks to see if there are any vertical wins in Tic Tac Toe 
# Input Parameter(s): board takes in a matrix of a completed tic tac toe game
# Return Value(s): If there are winners, it returns the winning character, else it returns None
#==========================================
def vertical(board):
    if board[0][0] == board [0][1] == board [0][2]:
        return board[0][0]
    elif board[1][0] == board [1][1] == board [1][2]:
        return board[1][0]
    elif board[2][0] == board [2][1] == board [2][2]:
        return board[2][0]
    # if none found, returns None
    else:
        return None
#==========================================
# Purpose: Checks to see if there are any horizontal wins in Tic Tac Toe 
# Input Parameter(s): board takes in a matrix of a completed tic tac toe game
# Return Value(s): If there are winners, it returns the winning character, else it returns None
#==========================================
def horizontal(board):
    if board[0][0] == board [1][0] == board [2][0]:
        return board[0][0]
    elif board[0][1] == board [1][1] == board [2][1]:
        return board[0][1]
    elif board[0][2] == board [1][2] == board [2][2]:
        return board[0][2]
    # if none found, returns None
    else:
        return None
#==========================================
# Purpose: Checks to see if there are any diagonal wins in Tic Tac Toe 
# Input Parameter(s): board takes in a matrix of a completed tic tac toe game
# Return Value(s): If there are winners, it returns the winning character, else it returns None
#==========================================
def diagonal(board):
    if board[0][0] == board[1][1] == board [2][2]:
        return board[0][0]
    elif board[2][0] == board[1][1] == board[0][2]:
        return board[2][0]
    # if none found, returns None
    else:
        return None

#==========================================
# Purpose: Checks to see if there is a winning pattern in a Tic Tac Toe game
# Input Parameter(s): board takes in a matrix of a completed tic tac toe game
# Return Value(s): If the horizontal, vertical, or diagonal functions return a value 
# other than None, that value gets returned by the function, else it returns "Draw"
#==========================================
def find_winner(board):
    # goes through the previous functions to determine if there are any wins
    if diagonal(board) != None:
        return diagonal(board)
    elif horizontal(board) != None:
        return horizontal(board)
    elif vertical(board) != None:
        return vertical(board)
    # if none found, the result of the game is a draw
    else:
        return "Draw"

