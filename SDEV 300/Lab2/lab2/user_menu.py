'''
Created on Oct 26, 2023

@author: tscal
Created by: Antonio Scalfaro
SDEV 300 / 7381
Lab 2 - User Menu
This program produces a user menu for the user to select one of six options from.
1. generate a secure password
2. calculate a percentage
3. how many days until july 4, 2025
4. calculate the third leg of a triangle
5. calculate the volume of a cylinder
6. exit
There are 10 functions.
welcome_message - Displays program details and details about developer
gen_secret_pass - Collects user input for parameters to create a secure password,
                  generates a new password
calc_percent - Collects user input for denominator, numerator, and number of digits to round to 
days_until - Calculates days until July 4, 2025 
calc_tri_leg - Collects user input for two legs of a triangle and the angle between them 
               and calculates the 3rd leg
calc_vol_cyl - Collects radius of the base and height of cylinder and calculates volume
exit_menu - Displays exit message
default_case - Displays message in the case of unrecognized menu input
print_menu - Displays the menu
main - Begins program, calls function based on user input from menu
'''
import string
import secrets
from datetime import datetime
import math

def welcome_message():
    """
    Display a welcome message to the user.
    """
    print("Created by: Antonio Scalfaro\n")
    print("SDEV 310 / 7381\n")
    print("10/26/2023\n")
    print("Lab 2 - User Menu\n")
    print("Select an option from the menu or select Exit to quit.\n")
    print("-----------------------------------------------------------\n")

def gen_secret_pass():
    """
    Generate a password based on input from user for format
    """
    special_chars = "!@#$%^&*(){}[]<>?"
    #Gather and validate user input
    while True:
        length = input("Please input a length for the password:")
        try:
            length_int = int(length)
            break
        except ValueError:
            print("Invalid input, try again.\n")
    while True:
        upper_case_input = input("Should the password have at least one upper case? y/n")
        if upper_case_input.lower() == "y" or upper_case_input.lower() == "n":
            break
        print("Please enter y or n")
    while True:
        special_char_input = input("Should the password have at least one special character? y/n")
        if special_char_input.lower() == "y" or special_char_input.lower() == "n":
            break
        print("Please enter y or n")
    while True:
        numeric_input = input("Should there be at least one digit? y/n")
        if numeric_input.lower() == "y" or numeric_input.lower() == "n":
            break
        print("Please enter y or n")
    #Construct alphabet string of all possible characters for passsword
    if upper_case_input.lower() == "y":
        alphabet = string.ascii_letters
    else:
        alphabet = string.ascii_lowercase
    if numeric_input.lower() == "y":
        alphabet = alphabet + string.digits
    if special_char_input.lower() == "y":
        alphabet = alphabet + special_chars
    #Generate password
    while True:
        password = ''.join(secrets.choice(alphabet) for i in range(length_int))
        # Check conditions based on user's input
        has_lowercase = any(c.islower() for c in password)
        has_uppercase = any(c.isupper() for c in password)
        has_digit = sum(c.isdigit() for c in password) >= 1
        has_special_char = any(c in special_chars for c in password)
        #Create booleans for specific conditions from user inputs
        uppercase_condition = (not upper_case_input.lower() == "y" or has_uppercase)
        special_char_condition = (not special_char_input.lower() == "y" or has_special_char)
        numeric_condition = (not numeric_input.lower() == "y" or has_digit)
        if (
        uppercase_condition and special_char_condition and numeric_condition and has_lowercase
        ):
            break
    print(f"Your new generated password is {password}\n")

def calc_percent():
    """
    Calculate a percentage based on user input for the denominator,
    numerator, and how many digits to be rounded to
    """
    while True:
        try:
            numerator = float(input("Enter the numerator: "))
            break
        except ValueError:
            print("Invalid input. Please enter a valid number.")

    while True:
        try:
            denominator = float(input("Enter the denominator: "))
            if denominator == 0:
                print("Denominator cannot be zero. Please enter a non-zero value.")
            else:
                break
        except ValueError:
            print("Invalid input. Please enter a valid number.")

    while True:
        try:
            decimal_places = int(input("Enter the number of decimal places to round to: "))
            if decimal_places >= 0:
                break
            print("Please enter a non-negative integer for decimal places.")
        except ValueError:
            print("Invalid input. Please enter a valid integer.")

    percentage = (numerator / denominator) * 100
    rounded_percentage = round(percentage, decimal_places)

    print(f"The percentage is: {rounded_percentage:.{decimal_places}f}%\n")

def days_until():
    """
    Calculate days until July 4, 2025 and print
    """
    target_date = datetime(2025, 7, 4)  # July 4, 2025
    current_date = datetime.now()
    days_remaining = (target_date - current_date).days

    if days_remaining < 0:
        print("July 4, 2025 has already passed.")
    else:
        print(f"Days until July 4, 2025: {days_remaining} days\n")

def calc_tri_leg():
    """
    Calculate the third leg of a triangle using the Law of Cosines
    when given two legs and the angle between those legs from the
    user. Round to 2 digits and print.
    """
    while True:
        try:
            leg1 = float(input("Enter the first leg: "))
            if leg1 >= 0:  # Check for a non-negative value
                break
            print("Leg length must be non-negative. Please enter a valid number.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")
    while True:
        try:
            leg2 = float(input("Enter the second leg: "))
            if leg2 >= 0:  # Check for a non-negative value
                break
            print("Leg length must be non-negative. Please enter a valid number.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")
    while True:
        try:
            angle = float(input("Enter the degrees of the angle between: "))
            if angle > 0:  # Check for a non-negative value
                break
            print("Angle must be greater than 0. Please enter a valid number.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")
    leg3 = math.sqrt(math.pow(leg1, 2) + math.pow(leg2, 2) - 2*leg1*leg2*math.cos(angle))
    leg3 = round(leg3, 2)
    print(f"The third leg of a triangle with legs {leg1} and {leg2}"
          f"with angle {angle} is {leg3}\n")

def calc_vol_cyl():
    """
    Calculate the volume of a right cylinder when given
    the radius of the base and the height of the cylinder
    from the user, print result rounded to 2 decimals.
    """
    while True:
        try:
            radius = float(input("Enter the radius of the base: "))
            if radius > 0:  # Check for a non-negative value
                break
            print("Radius must be greater than 0. Please enter a valid number.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")
    while True:
        try:
            height = float(input("Enter the height of the cylinder: "))
            if height > 0:  # Check for a non-negative value
                break
            print("Height must be greater than 0. Please enter a valid number.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")
    area = math.pi * math.pow(radius, 2) * height
    area = round(area, 2)
    print(f"The area of a right cylinder with radius {radius} and height {height} is {area}\n")

def exit_menu():
    """
    Exit menu print statement
    """
    print("Thank you for using the Multi-purpose User Menu. Goodbye.\n")
    print("-----------------------------------------------------------\n")

def default_case():
    """
    Default case for menu if input not recognized to be on the 
    menu.
    """
    print("Sorry, that entry did not match the given options. Please try again.\n")

def print_menu():
    """
    Print menu options to console
    """
    print("1:  Generate a Secure Password")
    print("2:  Calculate and Format Percentage")
    print("3:  How many days from today to July 4, 2025")
    print("4:  Use the Law of Cosines to Calculate Leg of a Triangle")
    print("5:  Calculate the volume of a Right Circular Cylinder")
    print("6:  Exit\n")

def main():
    """
    Main method, while loop to stay in menu and call necessary
    function until exit option is selected.
    """
    welcome_message()
    #Create switch options for menu corresponding to functions
    switch_dict = {
        "1": gen_secret_pass,
        "2": calc_percent,
        "3": days_until,
        "4": calc_tri_leg,
        "5": calc_vol_cyl,
        "6": exit_menu
        }
    while True:
        print_menu()
        user_input = input("Please select an option by entering its given numbered choice.\n")
        switch_case = switch_dict.get(user_input.strip(), default_case)
        switch_case()
        if switch_case == exit_menu:
            print("\n")
            break

if __name__ == '__main__':
    main()
    