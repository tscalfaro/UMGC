#Created by: Antonio Scalfaro
#CMIS 102, 5/2/2023

def welcomeMessage():
    print('Created by: Antonio Scalfaro')
    print('CMIS 102, 5/2/2023')
    print('This program is created for a combined House Cleaning, Yard Cleaning')
    print('company. The user will designate which service they want and will')
    print('input the required information to complete the quote.')

def getJobType():
    print('\nYou must first select whether you want House or Yard cleaning.')
    print('Please input 1, for House and 2, for Yard')

    #Retreive job input, exit loop when input in range and return jobType
    token = True
    while(token):
        jobType = int(input('Which type of job will you need?\t'))
        if (jobType == 1 or jobType == 2):
            token = False
        else:
            print('Invalid input, please input either 1 or 2.')
    return jobType

#Size of house function to determine cost
def houseSize(numRooms):
    cost = 0
    #Small house cost $250
    if(numRooms < 3):
        cost += 250
    #Medium house cost $400
    elif(numRooms < 5):
        cost += 400
    #Large house cost $550
    else:
        cost += 550
    return cost

#Determine package function, add package price to cost
def packageSelectionCost(packageSelected, cost):
    #Basic package addtional $100
    if (packageSelected == 1):
        cost += 100
    #Deluxe package additional $300
    else:
        cost += 300
    return cost
                      
def houseCleaning():
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
    finalCost = float(packageSelectionCost(packageSelected, cost))

    return finalCost

    

def mowingService():
    #Cost per sq foot = $5, gather sqr ft and return price
    sqrFt = float( input('\nPlease input the square footage for your yard:\t'))
    return sqrFt * 5

def edgingService():
    #Cost per linear foot = $5, gather linear foot and return price
    linFt = float(input('\nPlease input the linear footage of the edging:\t'))
    return linFt * 5

def shrubService():
    #Under 5 shrubs = $50, Under 10 = $100, 10 and over = $200
    numShrubs = int(input('\nHow many shrubs need cutting?\t'))

    #set cost according to numShrubs and return cost
    cost = 0
    if(numShrubs >= 10):
        cost += 200
    elif(numShrubs >= 5):
        cost += 100
    else:
        cost += 50
    return cost

def yardCleaning():
    #Print Yard cleaning options
    print('\nYou will have the choice of up to 3 yard cleaning options')
    print('\nMowing will cost $5 per square foot.')
    print('Edging will cost $5 per linear foot.')
    print('Shrubs will be priced by how many shrubs. Under 5 = $50, Under')
    print('10 = $100, 10 and over = $200')

    print('\nIf the service is desired, enter Y. Otherwise N')

    #Set finalCost = 0, add desired service costs to finalCost and return finalCost as float
    finalCost = 0
    if(input('\nWill you need our Mowing service?\t') == 'Y'):
        finalCost += mowingService()
    if(input('\nWill you need our Edging service?\t') == 'Y'):
        finalCost += edgingService()
    if(input('\nWill you need our Shrub service?\t') == 'Y'):
        finalCost += shrubService()
    return float(finalCost)

#Determines if customer is eligible for Senior Discount
#( 65 years old or older) returns boolean
def isSenior():
    token = True

    age = int(input('\nTo determine if you qualify for a discount, enter your age:\t'))

    if(age < 65):
        token = False
    return token

def main():
    welcomeMessage()
    
    jobType = getJobType()

    if (jobType == 1):
        jobCost = houseCleaning()
    else:
        jobCost = yardCleaning()

    #Senior Discount of 10%
    if(isSenior()):
        print('\nDiscounting final cost')
        jobCost = round(jobCost - (jobCost * .10), 2)

    #Print out jobCost for the house or yard cleaning
    print('\nYour total for this job will be ${}.'.format(jobCost))
    print('\nThank you for using House & Yard Cleaning Global Enterprises')
    


#Execute---------------------------------------------------------------
main()
