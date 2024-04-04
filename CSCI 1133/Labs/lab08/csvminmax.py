def readcsv(filename):
    try:
        op = open(filename, "r")
        readf = op.read()
        splitf = readf.split()
        lst2 = []
        
        for num in splitf:
            if (num.strip('-')).isnumeric() == True:
                lst2.append(int(num))
        
        print("Max number:", max(lst2), "- Min number:", min(lst2))
        
    except FileNotFoundError:
        print("Bad file name")

def main():
    filename = input("Enter name of file: ")
    readcsv(filename)