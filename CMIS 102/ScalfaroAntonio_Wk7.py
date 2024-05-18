#Created by: Antonio Scalfaro
#CMIS 102 4/25/2023
#This program will calculate cost for a road trip and give a per person cost
#of the trip

def welcomeMessage():
    print('Created by: Antonio Scalfaro')
    print('CMIS 102 4/25/2023')
    print('\nThis program will calculate total cost of a trip')
    print('It will prompt the user for the number of people on the trip')
    print('as well as days spent, and money spent on food and gas')
    print('It will display totals for food, gas, total cost, and per person cost')

#Print out food total, gas total, total cost, per person cost
def endMessage(food, gas, totalCost, perPersonCost):
    print('\nThe total spent on food is ${}'.format(round(sum(food), 2)))
    print('The total spent on gas is ${}'.format(round(sum(gas), 2)))
    print('The total spent is ${}'.format(totalCost))
    print('Total per person cost is ${}'.format(perPersonCost))

    
def main():
    welcomeMessage()
    #Input for number of People on trip
    numPeople = int(input('\nInput number of people on the trip:\t'))
    #Input for the number of Days spent on trip
    numDays = int(input('\nNumber of days the trip was?\t'))

    count = 1
    food = []
    gas = []
    #Collect food and gas costs per day and append to respective arrays
    while count <= numDays:
        food.append(float(input('\nDay {} food cost: \t'.format(count))))
        gas.append(float(input('\nDay {} gas cost: \t'.format(count))))
        count += 1

    #Calculate total cost and perPersonCost
    totalCost = round(sum(food) + sum(gas), 2)
    perPersonCost = round(totalCost / numPeople, 2)

    endMessage(food, gas, totalCost, perPersonCost)

#Execute---------------------------------------------------------------
main()
