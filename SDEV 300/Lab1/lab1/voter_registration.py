'''
Created on Oct 17, 2023

@author: tscal

Created by: Antonio Scalfaro
SDEV 300 / 7381 - Lab 1 - Voter Registration
'''

#State abbreviation array to test input against
state_abbreviations = [
    "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
    "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
    "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
    "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
    "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
]

#Opening output
print("Voter Registration Program")
print("Created by: Antonio Scalfaro")
print("SDEV 300 / 7381")

print("**************************************************************************")
print("Welcome to the Voter Registration Application")
#user input accepted to begin registration data collection
CONTINUE_INPUT = input("Would you like to continue? y/n\n")
#While loop for user input
while CONTINUE_INPUT.lower() == 'y':
    #retrieve first name, store, ask to continue
    first_name = input("What is your first name?\n")
    #validate name is not blank
    if first_name.strip() == "":
        print("A name must be entered. Please try again.\n")
        continue
    CONTINUE_INPUT = input("Would you like to continue? y/n\n")
    #check continue input is y
    if CONTINUE_INPUT.lower() != "y":
        break #exit
    #retrieve last name, store, ask to continue
    last_name = input("What is your last name?\n")
    #validate name is not blank
    if last_name.strip() == "":
        print("A surname must be entered. Please try again.\n")
        continue
    #check continue input for exit
    CONTINUE_INPUT = input("Would you like to continue? y/n\n")
    if CONTINUE_INPUT.lower() != "y":
        break
    #combine first and last name into one variable
    full_name = first_name + " " + last_name

    #retrieve age input, verify it is digit and falls in boundary
    age_input = input("What is your age?\n")
    if age_input.strip() == "":
        print("An age must be entered. Please try again.\n")
        continue
    if not age_input.isdigit():
        print("The age must be entered as a integer. Please try again.\n")
        continue
    #save age input as int
    age = int(age_input)
    if age < 18 or age > 125:
        print("Sorry, invalid age. Must be 18 or older and less than 125. Please try again.\n")
        continue
    CONTINUE_INPUT = input("Would you like to continue? y/n\n")
    #check continue input is y
    if CONTINUE_INPUT.lower() != "y":
        break #exit
    citizenship_input = input("Are you a citizen of the United States? y/n\n")
    if citizenship_input.lower() != 'y':
        print("Sorry, invalid citizenship. Please try again.\n")
        continue
    CONTINUE_INPUT = input("Would you like to continue? y/n\n")
    #check continue input is y
    if CONTINUE_INPUT.lower() != "y":
        break #exit
    state = input("Please enter the state abbreviation for the state you reside in.\n")
    #check that state input matches state abbreviation
    if state.upper() not in state_abbreviations:
        print("Abbreviation for state not recognized. Please try again.\n")
        continue
    CONTINUE_INPUT = input("Would you like to continue? y/n\n")
    #check continue input is y
    if CONTINUE_INPUT.lower() != "y":
        break #exit
    zipcode = input("What is your zipcode?\n")
    if not zipcode.isdigit():
        print("Invalid zipcode. Please try again.\n")
        continue
    if len(zipcode) != 5:
        print("Invalid Zipcode. Please try again.\n")
        continue
    #Print out data retrieved and exit
    print("Thanks for Registering, here is the information we have gathered:\n")
    print("Name (first, last): ", full_name, "\n")
    print("Age: ", age, "\n")
    print("U.S Citizen: ", citizenship_input.upper(), "\n")
    print("State: ", state.upper(), "\n")
    print("Zipcode: ", zipcode, "\n")
    print("Thanks for using the Voter Registration. Your voter ID card should ship in 3 weeks.\n")
    CONTINUE_INPUT = 'n'

print("**************************************************************************")
print("\n")
