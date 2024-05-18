#House Cleaning Cost Calculator
#Dev: Antonio Scalfaro CMIS 102 3/29/2023
#This program calculates the cost of a house cleaning depending on rooms and
#packaged selected for cleaning.

def main():

    #Welcome Message
    print('Dev:\t Tony Scalfaro')
    print('Class:\t CMIS 102 4/3/2023')
    
    print('\nWelcome to the House Cleaning Global Enterprise.')

    #User input for number of Rooms
    numRooms = int(input('\nHow many rooms will be cleaned?\t'))

    #Inform user of cleaning packages
    print('\nThere are two packages to choose from:')
    print('\n1 - Basic package, windows and floors')
    print('\n2 - Deluxe package, windows-floors-bathrooms-dusting')
    print('\nThe Basic package is a flat rate of $100 + house size')
    print('\nThe Deluxe is $300 + house size')

    #Collect user input for package selection
    packageSelected = int(input('\nWhich package would you like? 1 - Basic, 2 - Deluxe:\t'))

    #check valid user inputs
    if(numRooms <= 0 or packageSelected > 2 or packageSelected < 1):
        print('\n----------Error-----------------------\n')
        print('\t\tInvalid Input.')
        print('\nNumber of rooms must be greater than 0 and package selected must be 1 or 2')
        exit(0)

    #Call houseSize function to find size of house by number of rooms
    #assign return value to cost
    cost = houseSize(numRooms)
    
    #Set finalCost equal to return from packageSelectionCost
    #Pass cost and packageSelection
    finalCost = packageSelectionCost(packageSelected, cost)

    #Print out cost for the house cleaning
    print('\nYour total for this job will be ${}.'.format(finalCost))
    print('\nThank you for using House Cleaning Global Enterprises')

#Size of house function to determine cost
def houseSize(numRooms):
    #Small house
    if(numRooms < 3):
        return 250
    #Medium house
    elif(numRooms < 5):
        return 400
    #Large house
    else:
        return 550

#Determine package function, add package price to cost
def packageSelectionCost(packageSelected, cost):
    #Basic package 
    if (packageSelected == 1):
        return cost + 100
    #Deluxe package
    else:
        return cost + 300
#Execute-----------------------------------------------------------
main()
