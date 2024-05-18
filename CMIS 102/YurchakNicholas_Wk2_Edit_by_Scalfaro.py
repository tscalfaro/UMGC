# Python code
#This program will calculate and display in intger miles per hour and kilometers per hour
# The user will be prompted for distance and time in minutes and hours

#Developer: Nicholas Yurchak
#Class: CMIS 102
#Date: 03/18/2023

def main():

    #init variables
    mph_to_kph = 1.60934

    #welcome message
    print("Hello, this program will calulate your speed in miles per hour and kilometer per hour and round to the nearest intger")

    #prompt user for distance and time
    distance = eval(input("Distance traveled in miles:\n "))
    timeInhours = eval(input("\nTime spent traveling in hours:\n "))
    timeInmin = eval(input("\nTime spent traveling in minutes:\n "))

    #Calculations
    total_time = (timeInmin/60 + timeInhours)
    kph = int(distance/ total_time * mph_to_kph)
    mph = int(distance/ total_time)

    #display total
    print("\nYour time in MPH is ", mph, "\nYour time on KPH is ", kph)

    #Calculate amount of gas used for vehicle for that travel.
    mpg = float(input('\nHow many miles per gallon does your vehicle get?\t'))

    gasUsed = float(distance/mpg)

    print('\nYou used {} gallons of gas on your trip'.format(round(gasUsed, 2)))

main()
