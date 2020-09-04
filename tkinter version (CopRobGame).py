from tkinter import *
import tkinter.messagebox

class CopRobGame:

    def __init__(self, setMoves):
        self.vertices = []
        self.edges = []
        self.setMoves = setMoves
        self.players =["C","R"]
        self.C = 'C'
        self.R = 'R'
        self.D = {}
        

        i = 0
        for i in self.vertices:
            if i > 3:
                print("Robber wins!")

            if i == 3:
                print("This is your final move! Make it count.")

            i += 1
    


    def createVertex(self, n):
        self.vertices.append(n)
        


    def createEdge(self, v, q):

        if v == q:
            return False

        elif v not in self.vertices or q not in self.vertices:
            return False

        elif (v, q) in self.edges or (q, v) in self.edges:
            return False

        else:
            self.edges.append((v, q))
            return True
            
        
            
    def createdict(self):
        for i in self.players:
            self.D[i] =''


    def placePlayer(self, CR, v):
        self.wasmoved = False
        if len(self.D)==0:
            self.createdict()
        for i in self.vertices:
            if v==i:
                self.D[CR] = v
                self.wasmoved =True
        
        


    def movePlayer(self, RC, q):
        self.placePlayer(RC,q)
        self.setMoves -=1
        return self.wasmoved



    def winCheck(self):
        if self.D[self.C] == self.D[self.R]:
            return 'C'

        elif self.setMoves <=0:
            return 'R'
        else:
            return 'X'
        
        
    def display(self):
        print("Cop:",self.D[self.C],end = "     ")
        print("Robber:",self.D[self.R])
        print("Vertices:",end=" ")
        for i in self.vertices:
            print(i,end =",")
        print("\nEdges:",end=" ")   
        for i in self.edges:
            print(i,end =",")



class UserInterface(CopRobGame):

    def printIntro(self):
        print("Welcome to the Cop and Robber Game.")
        print("This is a two player game where one person is a cop and the other is the robber.")
        print("Each person picks a starting point, and the cop must catch the robber in order to win.")
        print("If the cop doesn't catch the robber, the robber wins.")

    def continuePlay(self):
        response = input("Would you like to continue playing (Yes or No)?")

        if response in ('Yes', 'y', 'yes', 'Y'):
            print(self.vertices)

        if response in ('n', 'No', 'N', 'no'):
            print("Thanks for playing The Cop and Robber Game")

        
 

    def printConclusion(self):
        print("Thanks for playing")
        print("The winner of this game was ... ")
        print("If you would like to play again, press play")

    def testUserInterface():
        U = UserInterface()
        U.printIntro()
        print(U.continuePlay())           


    def placeVertex(can, x, y, label):

        size = 20
        x1 = x - size/2
        y1 = y - size/2
        x2 = x + size/2
        y2 = y + size/2

    rect = Button(can, text =label,bg="white",relief=FLAT)
    rect.bind("<Button-1>", lambda e: edge(x,y))
    
    
    #can.create_rectangle(x1,y1,x2,y2) 
    #can.create_text(x,y,text=label)

    
   
    
    rect.place(x=x1,y=y1)   
    
    
L =[]
def edge(x1,y1):
    global L
    L.append((x1,y1))


    
def connect(can, values):

    global L
    for i in values:
        for j in values[1:]:
            can.create_line(i[0],i[1],j[0],j[1])
    L.clear()

    
                   
                    

root = Tk()

board = Canvas(width = 200, height = 200)

xCoord = Entry(width = 5)
yCoord = Entry(width = 5)
name   = Entry(width = 5)
enter  = Button(text = "Enter Vertex")

b = Button(board, text ="CONNECT")
b.bind("<Button-1>",lambda e: connect(board,L))
b.place(x = 100,y=180)

enter.bind('<Button-1>', lambda e: placeVertex(board,eval(xCoord.get()), eval(yCoord.get()),name.get()))

tkinter.messagebox.showinfo('Game Status', 'You have lost the game.')
answer = tkinter.messagebox.askquestion('Question 1', 'Would you like to continue playing?')

if answer == 'yes':
    print('Press Play')
    


if answer == 'no':
    print('Thank you for playing.')


xCoord.pack()
yCoord.pack()
name.pack()
enter.pack()
board.pack()




root.mainloop()



# self.UI = userInterface()
x = CopRobGame(3)
x.createVertex('a')
x.createVertex('b')
x.createVertex('c')
x.createVertex('d')
x.createEdge('a', 'd')
x.createEdge('a', 'b')
x.createEdge('b', 'c')
x.createEdge('c', 'd')
x.placePlayer('C', 'a')
x.placePlayer('R', 'd')

