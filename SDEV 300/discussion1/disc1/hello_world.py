'''
Created on Oct 17, 2023

@author: tscal
'''

class Conversion:
 
    # Constructor to initialize the class variables
    def __init__(self, capacity):
        self.top = -1
        self.capacity = capacity
         
        # This array is used a stack
        self.array = []
         
        # Precedence setting
        self.output = []
        self.precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
 
    # Check if the stack is empty
    def isEmpty(self):
        return True if self.top == -1 else False
 
    # Return the value of the top of the stack
    def peek(self):
        return self.array[-1]
 
    # Pop the element from the stack
    def pop(self):
        if not self.isEmpty():
            self.top -= 1
            return self.array.pop()
        else:
            return "$"
 
    # Push the element to the stack
    def push(self, op):
        self.top += 1
        self.array.append(op)
 
    # A utility function to check is the given character
    # is operand
    def isOperand(self, ch):
        return ch.isalpha()
 
    # Check if the precedence of operator is strictly
    # less than top of stack or not
    def notGreater(self, i):
        try:
            a = self.precedence[i]
            b = self.precedence[self.peek()]
            return True if a <= b else False
        except KeyError:
            return False
    
    def getInfix(self, exp) :
 
        s = [] 
     
        for i in exp:     
             
            # Push operands 
            if (self.isOperand(i)) :         
                s.insert(0, i) 
                 
            # We assume that input is a 
            # valid postfix and expect 
            # an operator. 
            else:
             
                op1 = s[0] 
                s.pop(0) 
                op2 = s[0] 
                s.pop(0) 
                s.insert(0, "(" + op2 + i +
                                 op1 + ")") 
                 
        # There must be a single element in 
        # stack now which is the required 
        # infix. 
        return s[0]
        # The main function that
        # converts given infix expression
        # to postfix expression
    def infixToPostfix(self, exp):
 
        # Iterate over the expression for conversion
        for i in exp:
             
            # If the character is an operand,
            # add it to output
            if self.isOperand(i):
                self.output.append(i)
 
            # If the character is an '(', push it to stack
            elif i == '(':
                self.push(i)
 
            # If the scanned character is an ')', pop and
            # output from the stack until and '(' is found
            elif i == ')':
                while((not self.isEmpty()) and
                      self.peek() != '('):
                    a = self.pop()
                    self.output.append(a)
                if (not self.isEmpty() and self.peek() != '('):
                    return -1
                else:
                    self.pop()
 
            # An operator is encountered
            else:
                while(not self.isEmpty() and self.notGreater(i)):
                    self.output.append(self.pop())
                self.push(i)
 
        # Pop all the operator from the stack
        while not self.isEmpty():
            self.output.append(self.pop())
 
        for ch in self.output:
            print(ch, end="")
 
 
# Driver code
if __name__ == '__main__':
    exp = "X×Y+W×Z+V×U"
    obj = Conversion(len(exp))
    exp2 = "XYZ+VW-*Z++"
    obj2 = Conversion(len(exp2))
 
    # Function call
    obj.infixToPostfix(exp)
    print("\n")
    print(obj2.getInfix(exp2))