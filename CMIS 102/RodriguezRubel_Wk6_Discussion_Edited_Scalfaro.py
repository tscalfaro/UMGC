def analyze_string(input_str):
    # count the number of spaces in the string
    num_spaces = input_str.count(' ')
    print(f'The string contains {num_spaces} spaces')

    # capitalize the first letter of each word in the string
    capitalized_str = input_str.title()
    print(f'The capitalized string is: {capitalized_str}')

    # check if the user's initials are in the string, regardless of case
    initials = input('Enter your initials: ')
    if initials.lower() in input_str.lower():
        print(f'The string contains your initials ({initials})')
    else:
        print(f'The string does not contain your initials ({initials})')

    print('Rubel Rodriguez, CMIS 102, 4/17/2023')
    print('\nEdited by: Antonio Scalfaro 4/19/2023')
    numDigits = sum(c.isdigit() for c in input_str)
    print('\nThere are {} digits in the string'.format(numDigits))


# test the function with a sample input string
sample_str = 'This is a sample string with my initials, RR'
analyze_string(sample_str)

test_edit_str = 'This 1s a tes3t string 4 with digit5s'
analyze_string(test_edit_str)
