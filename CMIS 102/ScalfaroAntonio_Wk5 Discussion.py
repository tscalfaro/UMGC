#Created by: Antonio Scalfaro
#CMIS 102, 4/12/2023
#This program will calculate total money spent on baseball cards in a month

def main():
    welcomeMessage()

    monthlyCost = 0.0
    cardCost = float(input('\nPlease provide the price of the first card:\t'))
    
    #Negative value for cardCost exits loop
    while(cardCost >= 0):
        monthlyCost += cardCost
        cardCost = askCardCost()
        
    print('\nYour total card expendature for the month is $', monthlyCost)

#Welcome message func
def welcomeMessage():
    print('Created by: Antonio Scalfaro for CMIS 102 on 4/12/2023')
    print('\nThis program will calculate total spent on baseball cards this month')
    print('\nEnter the amount spent on each card, one at a time')
    print('\nWhen you have entered all prices, submit a negative number to end tally')
    print('\nI.e, 5.5, 4.5, 66, -1, if you bought 3 cards the 4th entry is negative')

#Function to retreive user input for individual card cost
def askCardCost():
    thisCardCost = float(input('\nPlease provide the next price:\t'))
    return thisCardCost

#Execute----------------------------------
main()
