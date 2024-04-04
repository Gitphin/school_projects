

words = []
dblwords = []
uword = "placehold"

while uword != "":
    uword = input("Insert  word: ")
    words.append(uword.lower())

for i in range(len(words)):
    for char in words[i]:
        if words[i].count(char) > 1:
            dblwords.append(words[i])
            break
        
for i in range(len(dblwords)):
    print(dblwords[i])

           
        
    
    