#This program calculates surfae area of a cylinder, user will supply the radius and height of the
#cylinder to be measured.
#Antonio Scalfaro CMIS 102
def main():
    #Constant for pi
    pi = 3.14

    #Welcome message
    print('Hello, this program calculates the surface area of a cylinder when given a radius and height.\n')
    print('Created by Antonio Scalfaro CMIS 102\n')
    
    #Prompt to get radius and height from input
    radius = float(input('Please provide the radius for the cylinder to be measured in meters:\t'))
    height = float(input('\nPlease provide the height for the cylinder to be measured in meters:\t'))

    #Calculate surface area
    surfaceArea = 2*pi*radius*height + 2*pi*radius*radius

    #Print out surface area
    print('\nThe surface area of a cylinder with radius {} meters'.format(radius), ' and height {} meters'.format(height),' is {} meters squared'.format(surfaceArea))

main()
