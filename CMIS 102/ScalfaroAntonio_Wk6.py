#Created by: Antonio Scalfaro
#CMIS 102 4/19/2023
#This program asks user for a password and checks that it is of valid format

def welcomeMessage():
    print('Created by: Antonio Scalfaro')
    print('\nCMIS 102 4/19/2023')
    print('\nThis program checks to see if an input password is of valid format')
    print('\nI.e 6-15 characters, no spaces, at least 1 digit, at least 1 alpha')
    print('\nI.e valid = thisisvalid7')
    print('\nI.e not valid = Thisisnotvalidformorethan onereason')

#checks length of password is between 6-15 chars
def checkLen(password):
    return (len(password) < 6 or len(password) > 15)

#Checks for atleast 1 digit and 1 alpha char
def checkCharDigit(password):
    digitCount = sum(c.isdigit() for c in password)
    alphaCount = sum(c.isalpha() for c in password)

    return (alphaCount < 1 or digitCount < 1)

#Check for white space in password
def checkSpace(password):
    return (' ' in password)


def main():
    welcomeMessage()

    password = input('\nInput a valid password:\t')

    #Validity check, true return from funcs = invalid
    if(checkLen(password)):
        print('\nInvalid password length, must be 6-15 chars')
    elif(checkCharDigit(password)):
        print('\nInvalid password. Must contain at least 1 digit and 1 alpha')
    elif(checkSpace(password)):
        print('\nInvalid password. White space not allowed')
    else:
        print('\nValid password')

#Execute-------------------------------------------------------------------------
main()
