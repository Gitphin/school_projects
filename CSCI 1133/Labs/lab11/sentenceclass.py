class Sentence:
    
    def __init__(self, string = "default"):
        self.txt = string
        
    def getSentence(self):
        return str(self.txt)
    
    def getWords(self):
        words = (self.txt).split()
        return words
            
        
    def getLength(self):
        count = 0
        for i in self.txt:
            count+=1
        return count
    
    def getNumWords(self):
        words = (self.txt).split()
        return len(words)
            
test = Sentence()

print(test.getSentence())
print(test.getWords())
print(test.getLength())
print(test.getNumWords())