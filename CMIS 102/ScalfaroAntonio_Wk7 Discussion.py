#Created By: Antonio Scalfaro
#4/25/2023 CMIS 102
#This program creates an array containing inputs from the user and returns
#the array with each input reversed (i.e 45 = 54, string = gnirts)

def welcomeMessage():
    print('Created By: Antonio Scalfaro')
    print('CMIS 102 4/25/2023')
    print('\nThis program accepts input from the user and reverses')
    print('each string. Add as many inputs as desired.')
    print('Input -1 to finish input')

#Accepts array of string and reverse each string
def reverseString(inputArray):
    count = 0
    while( count < len(inputArray)):
        inputArray[count] = (inputArray[count])[::-1]
        count += 1  

def main():
    welcomeMessage()

    #Cerate input array
    inputArray = []

    #Create token and set as input from user
    token = input('\nPlease provide the first input:\t')

    #While loop to add items to inputArray, '-1' sentinel value
    while (token != '-1'):
        inputArray.append(token)
        token = input('\nNext input:\t')

    #If inputArray has at least 1 item, call reverseString()
    if(len(inputArray) > 0):
        reverseString(inputArray)

    #While loop to print inputArray items
    count = 0
    while (count < len(inputArray)):
        print(inputArray[count])
        count += 1

    
                      

#Execute---------------------------------------------------------
main()
