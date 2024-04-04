class Rational:
    def __init__(self, num=0, den=1):
        self.numerator = num
        if den == 0:
            self.denominator = 1
        else:
            self.denominator = den
        
    def __str__(self):
        if self.numerator == 0:
            return str(0)
        elif self.denominator == 1 and self.numerator != 0:
            return str(self.numerator)
        else:
            return str(self.numerator) + '/' + str(self.denominator)
        
    def scale(self, n = 1):
        return str(self.numerator * n) + '/' + str(self.denominator * n)
        
    
            
num1 = Rational(0,0)
print(num1)

num2 = Rational(3,4)
print(num2.scale(3))