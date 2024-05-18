#This program is for Discussion post week 3 for CMIS 102,
#Created by: Antonio Scalfaro 3/29/2023
#This program will ask for 3 inputs from the user, two numeric values and
#an operand (+, -, *, /, etc), the program will print the result of the values
#operated by the desired operand.

def main():
    #Welcome message
    print("Hello please provide 2 numeric values and the operand that should be used on them.")

    #input values, ensure numeric values are taken as floats
    firstValue = float(input('\nFirst numeric value:\t'))
    secondValue = float(input('\nSecond numeric value:\t'))
    operand = input('What operand should be used?\t')

    operationValue = 0;
    
    #check which operation to take place
    if(operand == '+'):
        operationValue = firstValue + secondValue

    elif(operand == '-'):
        operationValue = firstValue - secondValue

    elif(operand == '*'):
        operationValue = firstValue * secondValue

    elif(operand == '/'):
        operationValue = firstValue / secondValue

    elif(operand == '%'):
        operationValue = firstValue % secondValue

    else:
        print('\n\t Error! Invalid operand\n')

    #Print out value of operation and exit message
    print('\n The value of {}'.format(firstValue), ' {} '.format(operand), ' {} '.format(secondValue), ' is {} '.format(operationValue))

#Execute-------------------------------------------------------------
main()
