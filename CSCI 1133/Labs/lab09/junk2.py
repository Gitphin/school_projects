from tkinter import *
import random

class SnakeGUI():
    def __init__(self):
        self.win = Tk()
        self.win.title("SNAAAAAAAKE")
        self.win.geometry("600x800")
        self.win.bind("<w>",self.pressW)
        self.win.bind("<a>",self.pressA)
        self.win.bind("<s>",self.pressS)
        self.win.bind("<d>",self.pressD)
        self.win.bind("<space>",self.pressSpace)
        self.canvas = Canvas(self.win,width = 600,height = 600, bg = "white")
        self.canvas.pack()
        self.button = Button(self.win,text = "Pause", command = self.togpause)
        self.button.place(x=280, y=650)
        self.restart()
        
        

    def restart(self):
        self.canvas.delete(ALL)
        self.delay = 200
        self.x = 280
        self.y = 280
        self.vx = 20
        self.vy = 0
        self.seglist = [self.makeSquare()]
        self.xylist = [[self.x,self.y]]
        self.ax = random.randint(0,29)*20
        self.ay = random.randint(0,29)*20
        self.apple = self.makeApple()
        self.pause = False
        self.lose = False
        self.button.config(text = "Pause", command = self.togpause)
        self.last = 20
        self.animate()
        
    def makeSquare(self):
        return self.canvas.create_rectangle(self.x,self.y,self.x+20,self.y+20,fill = "black")
    
    def makeApple(self):
        return self.canvas.create_oval(self.ax,self.ay,self.ax+20,self.ay+20,fill= "red")

    def pressW(self,event):
        if len(self.seglist) == 1 or self.last != 200:
            self.vy = -20
            self.vx = 0

    def pressA(self,event):
        if len(self.seglist) == 1 or self.last != 20:
            self.vy = 0
            self.vx = -20
        
    def pressS(self,event):
        if len(self.seglist) == 1 or self.last != -200:
            self.vy = 20
            self.vx = 0
        
    def pressD(self,event):
        if len(self.seglist) == 1 or self.last != -20:
            self.vy = 0
            self.vx = 20

    def pressSpace(self,event):
        self.togpause()

    def togpause(self):
        if self.pause:
            self.button.config(text = "Pause")
            self.pause = False
        else:
            self.button.config(text = "Resume")
            self.pause = True

    def checkLose(self):
        if self.x + self.vx > 580 or self.x + self.vx < 0:
            self.lose = True
        if self.y + self.vy > 580 or self.y + self.vy < 0:
            self.lose = True
        if self.x + self.vx == self.ax and self.y + self.vy == self.ay:
            ls = self.xylist
        else:
            ls = self.xylist[1:]
        for i in ls:
            if self.x + self.vx == i[0] and self.y + self.vy == i[1]:
                self.lose = True
    
    def animate(self):
        self.checkLose()
        if not self.lose:
            if not self.pause:
                self.x = self.x + self.vx
                self.y = self.y + self.vy
                self.last = self.vx + self.vy*10
                if self.x == self.ax and self.y == self.ay:
                    self.canvas.delete(self.apple)
                    self.ax = random.randint(0,29)*20
                    self.ay = random.randint(0,29)*20
                    self.apple = self.makeApple()
                    self.delay -= 10
                else:
                    self.canvas.delete(self.seglist[0])
                    del self.seglist[0]
                    del self.xylist[0]
                    
                self.seglist.append(self.makeSquare())
                self.xylist.append([self.x,self.y])
            self.canvas.after(self.delay,self.animate)
        else:
            
            self.canvas.create_text(300,300, text = "Game Over! Score: " + str(len(self.seglist)))
            self.button.config(text = "Restart", command = self.restart)
            

SnakeGUI()
