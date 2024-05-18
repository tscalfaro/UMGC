#This program is designed to prompt input from the user and to display
#the total number of newspapers delivered in a week, weekly salary, and
#the total amount made for the week.
#I will create constants for price of each paper ($4.25) and commision rate (6%)
#The amount of papers delivered per day, number of days delivered per week, and total amount of tips will
#be provided by the user via prompt.

#Developer: Antonio Scalfaro CMIS 102 Date: Mar 21, 2023

def main():
    paperPrice = 4.25 #Cost per paper
    commisionRate = .06 #6% rate for commission

    #Opening message ------------------------------------------------------------------------
    
    print("Created by: Antonio Scalfaro CMIS 102 Date: Mar 21, 2023")
    print("Welcome to the newspaper monetary tabulation program.")
    print("This program will calculate the amount of papers per week that you have delivered")
    print("It will also tabulate your weekly salary as well as the total amount made for the week")
    
    #------------------------------------------------------------------------------------------
    #Collect user input for delivered papers, days delivered, and total tips------------------
    
    numDeliveredPerDay = int(input("\nHow many papers were deliverd per day?\t "))
    numDaysPerWeek = int(input("\nHow many days per week was the paper delivered?\t "))
    totalTips = float(input("\nHow much money did you receive via tip?\t $"))
    
    #-------------------------------------------------------------------------------------------
    
    #Check input values to ensure they are in proper range, i.e Day per week 0-7, nonnegative int for
    #totalTips and numDeliveredPerDay
    if(numDeliveredPerDay < 0 or numDaysPerWeek < 0 or numDaysPerWeek > 7 or totalTips < 0):
        print("\nError!\nPlease provide valid values for all input,i.e Day per week 0-7, nonnegative int for totalTips and numDeliveredPerDay")
        exit(0)
    else:
        print("\nThank you, calculating totals")
        #Call helper funcs and store returned values in variables
        numDeliveredInWeek = calcNumDeliveredInWeek(numDeliveredPerDay, numDaysPerWeek)
        weeklySalary = calcWeeklySalary(paperPrice, commisionRate, numDeliveredInWeek)
        totalMade = calcTotalMade(weeklySalary, totalTips)

        #Print break line
        print("\n------------------------------------------------------------------------------------\n")

        #Print out totals
        print("\n\nNumber Delivered this week:\t{}".format(numDeliveredInWeek))
        print("\nWeek's Salary:\t${}".format(round(weeklySalary, 2)))
        print("\nTotal, including tips:\t${}".format(round(totalMade, 2)))
        print("\nGood luck on your taxes!")

#Helper funcs to make main() cleaner------------------------------------------------------------
def calcNumDeliveredInWeek( numDeliveredPerDay, numDaysPerWeek ):
    return numDeliveredPerDay * numDaysPerWeek

def calcWeeklySalary(paperPrice, commisionRate, numDeliveredInWeek):
    return paperPrice * numDeliveredInWeek * commisionRate

def calcTotalMade(weeklySalary, totalTips):
    return weeklySalary + totalTips
#-- Execute -------------------------------------------------------------

main()

#------------------------------------------------------------------------
