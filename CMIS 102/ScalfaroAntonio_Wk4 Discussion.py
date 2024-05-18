#Dev: Antonio Scalfaro, 4/3/2023
#Class: CMIS 102 week 4 Discussion Post
#This program will ask for input (height, radius) from the user then will call a
#function to calculate the volume of a cylinder.

def main():

    #Welcome message
    print('Dev:\t Antonio Scalfaro')
    print('Class:\t CMIS 102')
    print('Date:\t 4/3/2023')
    print('\nHello, this program will calculate the volume of a cylinder.')
    print('It will prompt the user for the height and radius of the cylinder')

    #User input for radius and height
    radius = float(input('\nPlease provide the radius:\t'))
    height = float(input('\nPlease provide the height:\t'))

    #Make call to calcVolume function, passing radius and height
    #Round answer to 2 decimals.
    #Set the rounded return value to volume
    volume = round(calcVolume(radius, height), 2)

    #Print out the calculated volume
    print('\nThe volume for a cylinder with radius {}'.format(radius),
          'and height {}'.format(height), 'is {}'.format(volume))

#Define calcVolume function and pass radius and height
def calcVolume(radius, height):
    #Set constant value for pi
    pi = 3.14
    return pi * (radius**2) * height

#Execute---------------------------------------------------------------
main()
