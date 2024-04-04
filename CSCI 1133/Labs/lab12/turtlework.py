import turtle


class Shape:
    
    def __init__(self, x=0, y=0, color="#000000"):
        self.y = y
        self.x = x
        self.color = color
        self.fill = False
        
    def set_fill_color(self, fcol):
        self.color = fcol
    
    def set_filled(self, fillit):
        self.fill = fillit
    
    def is_filled(self):
        return self.fill

class Circle(Shape):
    
    def __init__(self, x=0, y=0, radius=1, color="#000000"):
        super().__init__(x, y, color)
        self.radius = radius

    
    def draw(self, t):
        
        if self.fill == True:
            t.penup()
            t.goto(self.x, self.y)
            t.pendown()
            t.fillcolor(self.color)
            t.begin_fill()
            t.circle(self.radius)
            t.end_fill()
            
        else:
            t.penup()
            t.goto(self.x, self.y)
            t.pendown()
            t.circle(self.radius)

class Display(Circle):
    
    def __init__(self):
        self.t = turtle.Turtle()
        self.scr = turtle.getscreen()



a = Shape(50, 50, "red")
print(a.is_filled())
a.set_filled(True)
print(a.is_filled())

b = Circle(50, 50, 100, "red")
b.draw(turtle.Turtle())


                 