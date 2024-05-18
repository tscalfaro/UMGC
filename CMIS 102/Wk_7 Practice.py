#Practice CMIS 102 python
#Take in any # of peoples' heights as feet and inches, store in array as inches
#Store, in second array, heights in meters. Keep track of # of short, normal,
#and tall. Display in table

def sizeChecker(inches, heightDict):
    if (inches >= 72):
        heightDict['tall']= heightDict['tall'] + 1
    elif (inches >= 66):
        heightDict['medium'] = heightDict['medium'] + 1
    else:
        heightDict['small'] = heightDict['small'] + 1

def main():

    print('Provide heights as two digits, with space between ft and inches')
    print('i.e, a 5 ft 10 in person would be recorded as 5 10')
    print('enter the height 0 0 to finish')

    heightToAdd = input('\nWhat is the first height?\t')
    heightsInInches = []
    heightsInMeters = []

    heightDict = {
        'small': 0,
        'medium': 0,
        'tall': 0
        }
    while (heightToAdd != '0 0'):
        height = [float (n) for n in heightToAdd.strip().split(' ')]
        x = height[0] * 12
        y = height[1]
        heightInIn = x + y
        sizeChecker(heightInIn, heightDict)
        heightsInInches.append(heightInIn)
        heightsInMeters.append(heightInIn * .0254)
        heightToAdd = input('Next individual\'s height:')

    table = [[] * len(heightsInInches)]
    print('|\tHeight In Iches.\t|\tHeight In Meters\t|')
    for row in heightsInInches:
        print('|\t{:1}\t\t\t|\t{:1}\t\t\t|'.format(row, (row2 for row2 in heightsInMeters)))
    print('-' * 80)
    print('|\tSmall : {}'.format(heightDict['small']) +
          '\tMedium : {}'.format(heightDict['medium']) +
          '\tTall : {}'.format(heightDict['tall']))
        
main()
