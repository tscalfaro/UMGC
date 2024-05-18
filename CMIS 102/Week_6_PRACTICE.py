#This is string practice in python
#Week 6 CMIS 102

def welcomeMessage():
    print('Pass a valid university email.\n')
    print('i.e namehere@UNI.edu\n')
    print('Must be between 6-15 characters long and end \'UNI.edu\'')

def checkEmailValid(email):
    token = True
    split_email = email.split('@')

    #less than means no '@', more than means too many '@'
    if len(split_email) != 2:
        token = False
    #email length must be 6 - 15 characters
    if len(split_email[0]) < 6 or len(split_email[0]) > 15:
        token = False
    #All emails must end as 'UNI.edu'
    if split_email[1] != 'UNI.edu':
        token = False
    
    return token


    
def main():
    welcomeMessage()

    #Gather input string from user
    email = input('\nProvide a university email:\t')

    print(checkEmailValid(email))



main()
