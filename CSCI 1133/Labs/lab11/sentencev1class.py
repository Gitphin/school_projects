class SentenceV1:
    
    def __init__(self, string = "default"):
        self.txt = string.split()
        self.txt2 = string
    def getSentence(self):
        return "".join(self.txt)
     
    def getWords(self):
        return self.txt
        
    def getLength(self):
        count = 0
        for i in self.txt2:
            count+=1
        return count
    
    def getNumWords(self):
       
        return len(self.txt)
    
    
   
    
test = SentenceV1()

print(test.getSentence())
print(test.getWords())
print(test.getLength())
print(test.getNumWords())
