#Marlena Slaw Kiewe
#CMSC 102
#Discussion 5
#4/13/2023
#This program get the total cost of someones bills in a month
#--------------------------------------------------------------
#Edited by: Antonio Scalfaro
#4/14/2023 CMIS 102
#All comments are mine from here.

#Encapsulate the code into a main function for usability and easier modification
def main():
    #Welcome message
    welcomeMessage()
    counter = 0
    total_cost = 0

    #Changed cost to float value
    #move the first bill input outside while loop
    cost = float(input('\nhow much was 1 of your bills this month? -1 to finish\t'))
    
    #-1 will be escape now, less room for error from user to input invalid entry
    while cost != -1:
        counter +=1
        #No if statement for sentinal loop needed here, add cost to total_cost and ask for
        #next value. If not sentinel value then it continues to add.
        total_cost += float(cost)
        cost = float(input('\nhow much was 1 of your bills this month? -1 to finish\t'))
        
        

    print('Your total cost of bills per month is $' + str(round(total_cost, 2)))
    #Calculate averageCost
    averageCost = total_cost / counter
    #Print averageCost
    print('\nYour average per bill is $', str(round(averageCost, 2)))

#Added welcomeMessage func to display welcome.
def welcomeMessage():
    print('Created by: Marlena Slaw Kiewe\n')
    print('Edited by: Antonio Scalfaro\n')
    print('4/14/2023, CMIS 102\n')
    print('This program adds your bills up and gives an average per bill this month.')

#Execute---------------------------------------------------------
main()
