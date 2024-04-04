import random


def csvgen(filename):

    op = open(filename, "w")
    count = 0
    for i in range(100):
        randnum = random.randint(-1000, 1000)
        count += 1
        op.write(str(count) + ", " + str(randnum) + " \n")

    

def main():
    filename = input("Enter name of file: ")
    csvgen(filename)