'''
Created on Nov 8, 2023

@author: tscal
Created by: Antonio Scalfaro
SDEV 300 / 7381
11/08/2023
Lab 4 - Matrix Game
This is the Matrix Game application utilizing numpy, regex, and StringIO. 
It will prompt the user for a phone number, a zip code, and two 3x3
matrices. The user will then be able to select from four matrix operations:
1 - Addition
2 - Subtraction
3 - Matrix Multiplication
4 - Element by element multiplication
5 - Exit
It will display the answer to the operation, a transposed matrix of
the answer, and the means of the rows and columns. This program 
utilizes 14 functions
welcome_message - Display developer and program details
exit_menu - Display exit message
validate_phone_number - Accept user input for phone number and 
                        validate for correct form
validate_zip_code - Accept user input for a zip code and validate
                    for correct form
create_matrix - Accept user input for 9 floats or ints separated
                by a space for the creation of a valid 3x3 matrix,
                returns matrix
matrix_menu - Displays menu for matrix operations and returns selected
              option
matrix_addition - Adds two matrices & displays and returns answer
matrix_subtraction - Subtracts two matrices & displays and returns answer
matrix_multiplication - Uses dot multiplication on two matrices & displays
                        and returns answer
elem_by_elem_mult - Performs element by element multiplication of two 
                    matrices & displays and returns answer
row_mean - Calculates the mean of the rows of a matrix, displays answer
column_mean - Calculates the mean of the columns of a matrix, displays
              answer
neat_matrix - Uses StringIO to format and return a matrix without brackets
main - Initiates program and continues until user selects to exit
'''

import re
from io import StringIO
import numpy as np

def welcome_message():
    """
    Welcome message to user, displays program and developer details
    """
    print("Created by: Antonio Scalfaro")
    print("SDEV 300 / 7381")
    print("11/08/2023")
    print("This is the Matrix Game application. It will prompt the user for a phone" +
          " number, a zip code, and two 3x3 matrices.")
    print("The user will then be able to select from four matrix operations:")
    print("addition, subtraction, matrix multiplication, and element by element multiplication.")
    print("It will display the answer, the transpose of the answer, and the means of" +
          "the columns and rows.")
    print("---------------------------------------------------------------------\n")

def exit_menu():
    """
    Exit message to user
    """
    print("\nThanks for using the Matrix Game Application. Goodbye.")
    print("---------------------------------------------------------------------\n")

def validate_phone_number():
    """
    Creates regex pattern and validates input for phone number matches
    """
    pattern = r'^\d{3}-\d{3}-\d{4}$' #Set phone number pattern
    while True:
        number = input("Enter your phone number (XXX-XXX-XXXX)\t").strip()
        if bool(re.match(pattern, number)): #If number matches format, return it else try again
            return number
        print("Incorrect format for a phone number. (XXX-XXX-XXXX)")

def validate_zip_code():
    """
    Creates regex pattern and validates input for zipcode matches
    """
    pattern = r'^\d{5}(-\d{4})?$' #Set pattern for zipcode
    while True:
        zip_code = input("Enter your zipcode+4 (XXXXX-XXX)").strip()
        if bool(re.match(pattern, zip_code)):#If zipcode matches pattern, return it else try again
            return zip_code
        print("Incorrect format, please retry. (XXXXX-XXXX)")

def create_matrix():
    """
    Receive valid input for 3x3 matrix and create & return matrix
    """
    while True:
        try:
            matrix_input = input("Enter the numbers for a 3x3 matrix separated by a space:\t")
            matrix_nums = [float(num) for num in matrix_input.split()]
            if len(matrix_nums) != 9:
                raise ValueError("Invalid input, please enter 3x3 matrix")
            return np.array(matrix_nums).reshape(3, 3)
        except ValueError as e:
            print(f"Error: {e}. Please enter valid numeric input")

def matrix_menu():
    """
    Display matrix menu and validate & return input 
    """
    print("Select a Matrix operation from the list below:\n")
    print("1) Addition")
    print("2) Subtraction")
    print("3) Matrix Multiplication")
    print("4) Element by element multiplication")
    print("5) Exit")
    while True:
        try:
            choice = int(input("Please enter the integer of your choice:\t"))
            if choice < 1 or choice > 5:
                raise ValueError("Invalid selection.")
            return choice
        except ValueError as e:
            print(f"Error: {e}. Please enter valid int choice.")

def matrix_addition(matrix_a, matrix_b):
    """
    Calculate matrix addition
    """
    matrix_add = matrix_a + matrix_b
    print(f"The addition of Matrix A and Matrix B is:\n{neat_matrix(matrix_add)}")
    return matrix_add

def matrix_subtraction(matrix_a, matrix_b):
    """
    Calculate matrix subtraction
    """
    matrix_sub = matrix_a - matrix_b
    print(f"The subtraction of Matrix A and Matrix B is:\n{neat_matrix(matrix_sub)}")
    return matrix_sub

def matrix_multiplication(matrix_a, matrix_b):
    """
    Calculate Dot Multiplication of matrices
    """
    matrix_mult = np.dot(matrix_a, matrix_b)
    print(f"The product of Matrix A and Matrix B is:\n{neat_matrix(matrix_mult)}")
    return matrix_mult

def elem_by_elem_mult(matrix_a, matrix_b):
    """
    Calculate matrix multiplication, element by element
    """
    matrix_mult = matrix_a * matrix_b
    print("The element by element product of Matrix A and " +
          f"Matrix B is:\n{neat_matrix(matrix_mult)}")
    return matrix_mult

def row_mean(matrix):
    """
    Calculate and display the mean of the rows of the matrix
    """
    #Get mean of each row
    row1_mean = np.mean(matrix[0])
    row2_mean = np.mean(matrix[1])
    row3_mean = np.mean(matrix[2])
    #Round to 2 decimals
    row1_mean = round(row1_mean, 2)
    row2_mean = round(row2_mean, 2)
    row3_mean = round(row3_mean, 2)
    #Print means
    print(f"The mean of row 1 is {row1_mean}")
    print(f"The mean of row 2 is {row2_mean}")
    print(f"The mean of row 3 is {row3_mean}\n")

def column_mean(matrix):
    """
    Calculate and display the mean of the columns of the matrix
    """
    #Calculate means
    col1_mean = np.mean(matrix[:, 0])
    col2_mean = np.mean(matrix[:, 1])
    col3_mean = np.mean(matrix[:, 2])
    #Round to 2 decimals
    col1_mean = round(col1_mean, 2)
    col2_mean = round(col2_mean, 2)
    col3_mean = round(col3_mean, 2)
    #Print means
    print(f"The mean of column 1 is {col1_mean}")
    print(f"The mean of column 2 is {col2_mean}")
    print(f"The mean of column 3 is {col3_mean}\n")

def neat_matrix(matrix):
    """
    Takes existing matrix and formats it neatly without brackets
    """
    #Use StringIO to capture printed output
    output_buff = StringIO()
    #Save matrix to output buffer without brackets
    np.savetxt(output_buff, matrix, fmt='%d', delimiter='\t')
    #Move buffer cursor to beginning
    output_buff.seek(0)
    return output_buff.read()

def main():
    """
    Main function
    """
    welcome_message()
    play_token = True
    #Matrix Game Loop
    while play_token:
        play_game = input("Do you want to play the Matrix Game? y/n\t").strip()
        if play_game.lower() == "n":
            play_token = False
            continue
        validate_phone_number() #Func to input and validate phone number
        validate_zip_code() #Func to input and validate zipcode
        #Create matrices
        matrix_a = create_matrix()
        matrix_b = create_matrix()
        print("Matrix A is:\n")
        print(neat_matrix(matrix_a))
        print("Matrix B is:\n")
        print(neat_matrix(matrix_b))
        matrix_menu_token = True
        #Matrix Menu Loop
        while matrix_menu_token:
            menu_selection = matrix_menu()
            #Exit menu if selection is 5
            if menu_selection == 5:
                matrix_menu_token = False
                continue
            switch_menu = {
                1: matrix_addition,
                2: matrix_subtraction,
                3: matrix_multiplication,
                4: elem_by_elem_mult}
            matrix_op = switch_menu.get(menu_selection) #Get correct operation callable
            matrix_answer = matrix_op(matrix_a, matrix_b) #Call operation func with matrices
            matrix_trans = np.transpose(matrix_answer) #Transpose answer matrix
            print(f"The Transpose is:\n{neat_matrix(matrix_trans)}\n")
            row_mean(matrix_answer) #Display means of rows of answer matrix
            column_mean(matrix_answer) #Display means of columns of answer matrix
    exit_menu()
    print("\n")

if __name__ == '__main__':
    main()
