#Created by: Antonio Scalfaro
#CMIS 102 4/18/2023
#This program counts the amount of times my initials are in an inputted string
#and will reverse and title case the string.

#Welcome message display
def welcomeMessage():
    print('Created by: Antonio Scalfaro\n')
    print('CMIS 102 4/18/2023\n')
    print('This program takes in a string, reverses it and title cases it.\n')
    print('It will also count how many times my initials, acs, are in the string\n')
    print('I.e input = this STRing Acs, output = Sca Gnirts Siht, 1 initials found')

#Counts occurrence of Initials in string
def countInitials(thisString):
    #Set my initials 
    initials = 'acs'
    count = 0
    #Lower case and seperate string on whitespace
    seperatedString = thisString.lower().split()
    
    #Check each word for initials in them and incriment count accordingly
    for word in seperatedString:
        if initials in word:
            #Count initials occurrence in each word, add it to count
            countInWord = word.count(initials)
            count += countInWord
    return count

#Main ----------------------------------------------------------------------------------
def main():
    welcomeMessage()

    newString = input('\nPlease provide a string:\t')

    initialCount = countInitials(newString)
    
    finalString = newString[::-1].title()
    
    print('\nThe final string is:\n', finalString)
    print('\nMy initials were found {} times'.format(initialCount))

#Execute --------------------------------------------------------------------------------
main()
