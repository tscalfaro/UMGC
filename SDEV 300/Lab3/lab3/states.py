'''
Created on Nov 3, 2023

@author: tscal
Created by: Antonio Scalfaro
SDEV 300 / 7381
Lab 3 - States Information

This program displays a menu with 5 options for the user:
1 - Display all US states in alphabetical order (State, population, capital, state flower)
2 - Search and display a single state, show image of state flower
3 - Display a bar graph with the 5 most populated states
4 - Allow user to select a state and edit its population
5 - Exit program

There are 8 functions in this program:
welcome_message - Displays program and developer details
display_menu - Displays the menu to the console
display_all - Prints all states and their data in alphabetical order to console
find_one - Finds user selected state and displays data to console, invokes native system image
           displayer to show state flower
bar_graph - Creates and displays bar graph of most populated states
update_pop - User selects state and updates its population
default_case - Displays error message if user inputs an unrecognized menu option
exit_menu - Displays exit message
main - Initiates program, uses while loop for menu until exit is selected
'''
from subprocess import run
import matplotlib.pyplot as plt
import sys

states_info = {
    "Alabama": {
        "population": 4908621,
        "capital": "Montgomery",
        "state_flower": "Camellia"
    },
    "Alaska": {
        "population": 731007,
        "capital": "Juneau",
        "state_flower": "Forget-Me-Not"
    },
    "Arizona": {
        "population": 7278717,
        "capital": "Phoenix",
        "state_flower": "Saguaro Cactus Blossom"
    },
    "Arkansas": {
        "population": 3017804,
        "capital": "Little Rock",
        "state_flower": "Apple Blossom"
    },
    "California": {
        "population": 39538223,
        "capital": "Sacramento",
        "state_flower": "California Poppy"
    },
    "Colorado": {
        "population": 5773714,
        "capital": "Denver",
        "state_flower": "Columbine"
    },
    "Connecticut": {
        "population": 3605944,
        "capital": "Hartford",
        "state_flower": "Mountain Laurel"
    },
    "Delaware": {
        "population": 989948,
        "capital": "Dover",
        "state_flower": "Peach Blossom"
    },
    "Florida": {
        "population": 21538187,
        "capital": "Tallahassee",
        "state_flower": "Orange Blossom"
    },
    "Georgia": {
        "population": 10711908,
        "capital": "Atlanta",
        "state_flower": "Cherokee Rose"
    },
    "Hawaii": {
        "population": 1455271,
        "capital": "Honolulu",
        "state_flower": "Hibiscus"
    },
    "Idaho": {
        "population": 1839106,
        "capital": "Boise",
        "state_flower": "Syringa"
    },
    "Illinois": {
        "population": 12812508,
        "capital": "Springfield",
        "state_flower": "Violet"
    },
    "Indiana": {
        "population": 6794422,
        "capital": "Indianapolis",
        "state_flower": "Peony"
    },
    "Iowa": {
        "population": 3192406,
        "capital": "Des Moines",
        "state_flower": "Wild Rose"
    },
    "Kansas": {
        "population": 2937880,
        "capital": "Topeka",
        "state_flower": "Sunflower"
    },
    "Kentucky": {
        "population": 4505836,
        "capital": "Frankfort",
        "state_flower": "Goldenrod"
    },
    "Louisiana": {
        "population": 4657757,
        "capital": "Baton Rouge",
        "state_flower": "Magnolia"
    },
    "Maine": {
        "population": 1362359,
        "capital": "Augusta",
        "state_flower": "White Pine Cone and Tassel"
    },
    "Maryland": {
        "population": 6177224,
        "capital": "Annapolis",
        "state_flower": "Black-Eyed Susan"
    },
    "Massachusetts": {
        "population": 7033469,
        "capital": "Boston",
        "state_flower": "Mayflower"
    },
    "Michigan": {
        "population": 10599193,
        "capital": "Lansing",
        "state_flower": "Apple Blossom"
    },
    "Minnesota": {
        "population": 5706494,
        "capital": "St. Paul",
        "state_flower": "Lady's Slipper"
    },
    "Mississippi": {
        "population": 2963914,
        "capital": "Jackson",
        "state_flower": "Magnolia"
    },
    "Missouri": {
        "population": 6160281,
        "capital": "Jefferson City",
        "state_flower": "Hawthorn"
    },
    "Montana": {
        "population": 1085407,
        "capital": "Helena",
        "state_flower": "Bitterroot"
    },
    "Nebraska": {
        "population": 1952570,
        "capital": "Lincoln",
        "state_flower": "Goldenrod"
    },
    "Nevada": {
        "population": 3139658,
        "capital": "Carson City",
        "state_flower": "Sagebrush"
    },
    "New Hampshire": {
        "population": 1371246,
        "capital": "Concord",
        "state_flower": "Purple Lilac"
    },
    "New Jersey": {
        "population": 9288994,
        "capital": "Trenton",
        "state_flower": "Violet"
    },
    "New Mexico": {
        "population": 2117522,
        "capital": "Santa Fe",
        "state_flower": "Yucca Flower"
    },
    "New York": {
        "population": 20215751,
        "capital": "Albany",
        "state_flower": "Rose"
    },
    "North Carolina": {
        "population": 10600823,
        "capital": "Raleigh",
        "state_flower": "Dogwood"
    },
    "North Dakota": {
        "population": 761723,
        "capital": "Bismarck",
        "state_flower": "Wild Prairie Rose"
    },
    "Ohio": {
        "population": 11799448,
        "capital": "Columbus",
        "state_flower": "Scarlet Carnation"
    },
    "Oklahoma": {
        "population": 3953823,
        "capital": "Oklahoma City",
        "state_flower": "Oklahoma Rose"
    },
    "Oregon": {
        "population": 4301089,
        "capital": "Salem",
        "state_flower": "Oregon Grape"
    },
    "Pennsylvania": {
        "population": 12823989,
        "capital": "Harrisburg",
        "state_flower": "Mountain Laurel"
    },
    "Rhode Island": {
        "population": 1098163,
        "capital": "Providence",
        "state_flower": "Violet"
    },
    "South Carolina": {
        "population": 5210095,
        "capital": "Columbia",
        "state_flower": "Yellow Jessamine"
    },
    "South Dakota": {
        "population": 903027,
        "capital": "Pierre",
        "state_flower": "Pasque Flower"
    },
    "Tennessee": {
        "population": 6897576,
        "capital": "Nashville",
        "state_flower": "Iris"
    },
    "Texas": {
        "population": 29145505,
        "capital": "Austin",
        "state_flower": "Bluebonnet"
    },
    "Utah": {
        "population": 3271616,
        "capital": "Salt Lake City",
        "state_flower": "Sego Lily"
    },
    "Vermont": {
        "population": 643077,
        "capital": "Montpelier",
        "state_flower": "Red Clover"
    },
    "Virginia": {
        "population": 8631393,
        "capital": "Richmond",
        "state_flower": "American Dogwood"
    },
    "Washington": {
        "population": 7693612,
        "capital": "Olympia",
        "state_flower": "Coast Rhododendron"
    },
    "West Virginia": {
        "population": 1792001,
        "capital": "Charleston",
        "state_flower": "Rhododendron"
    },
    "Wisconsin": {
        "population": 5897473,
        "capital": "Madison",
        "state_flower": "Wood Violet"
    },
    "Wyoming": {
        "population": 576851,
        "capital": "Cheyenne",
        "state_flower": "Indian Paintbrush"
    }
}

def welcome_message():
    """
    Welcome message to user, contains developer and program details
    """
    print("Created by: Antonio Scalfaro")
    print("SDEV 300 / 7381")
    print("Lab 3 - States Information")
    print("This program allows the user to look up information on states: " +
          "their capital, population, and state flower. When searching by a " +
          "singular state, you can get that information plus an image of the " +
          "state flower. The user can see a bar graph of the 5 most populated " +
          "states. Lastly, a user can edit the population of a state.")
    print("----------------------------------------------------------------------")

def display_menu():
    """
    Display the user menu
    """
    print("1:\tDisplay all U.S. States in Alphabetical order along with the " +
          "Capital, State Population, and Flower")
    print("2:\tSearch for a specific state and display the appropriate Capital " +
          "name, State Population, and an image of the associated State Flower.")
    print("3:\tProvide a Bar graph of the top 5 populated States showing their " +
          "overall population.")
    print("4:\tUpdate the overall state population for a specific state.")
    print("5:\tExit\n")

def display_all():
    """
    Display all states and their information
    """
    # Display the full dictionary
    for state, info in states_info.items():
        print(f"State: {state}")
        print(f"Population: {info['population']}")
        print(f"Capital: {info['capital']}")
        print(f"State Flower: {info['state_flower']}")
        print()

def find_one():
    """
    Find selected state and display its information, display image of state
    flower.
    """
    while True:
        state_choice = input("Please input a state or 'q' to quit: ").strip()
        # Check if the user wants to quit
        if state_choice.lower() == 'q':
            break
        # Convert the user's input to title case for matching
        state_choice = state_choice.title()
        # Check if the state is in the dictionary
        if state_choice in states_info:
            state_info = states_info[state_choice]
            print(f"State: {state_choice}")
            print(f"Population: {state_info['population']}")
            print(f"Capital: {state_info['capital']}")
            print(f"State Flower: {state_info['state_flower']}")
            # Load and display an image of the state flower
            try:
                # Format state name to match image file
                state_name = state_choice.lower().replace(" ", "_")
                flower_image = f"images/{state_name}_flower.jpg"
                run(["start", flower_image], shell=True, check=False)
                flower_image = f"images/{state_name}_flower.jpg"
            except FileNotFoundError:
                print("Image not found for the state flower.")
        else:
            print("State not found. Please enter a valid state name.")

def bar_graph():
    """
    Create and display bar graph of 5 highest populated states
    """
    # List of tuples of state name and population
    state_population = [(state, info['population']) for state, info in states_info.items()]
    state_population.sort(key=lambda x: x[1], reverse=True)
    top_states = state_population[:5]
    # Zip list of tuples to create two lists one for state name and one for
    # the corresponding population
    state_names, population_values = zip(*top_states)
    plt.figure(figsize=(10, 6))
    plt.bar(state_names, population_values)
    plt.xlabel('State')
    plt.ylabel('Population (Tens of Millions)')
    plt.title('Top 5 States by Population')
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.show()

def update_pop():
    """
    Select a state and update its population
    """
    state_choice = input("Please enter the name of the state you want" +
                         " to update the population for: ").strip().title()
    if state_choice in states_info:
        new_population = input(f"Enter the new population for {state_choice}: ")
        # Validate that the input is a positive integer
        try:
            new_population = int(new_population)
            if new_population >= 0:
                states_info[state_choice]['population'] = new_population
                print(f"Population for {state_choice} has been updated to {new_population}.")
            else:
                print("Population must be a positive integer.")
        except ValueError:
            print("Invalid population input. Please enter a positive integer.")
    else:
        print("State not found. Please enter a valid state name.")

def default_case():
    """
    Default case for menu if input not recognized to be on the 
    menu.
    """
    print("Sorry, that entry did not match the given options. Please try again.\n")

def exit_menu():
    """
    Exit menu message
    """
    print("Thank you for using the States Information Application. Goodbye.\n")
    print("----------------------------------------------------------------------\n")

def main():
    """
    Main method
    """
    welcome_message()
    switch_dict = {
        "1": display_all,
        "2": find_one,
        "3": bar_graph,
        "4": update_pop,
        "5": exit_menu
        }
    continue_menu = True
    while continue_menu:
        display_menu()
        user_input = input("Please select an option from the menu\t").strip()
        switch_case = switch_dict.get(user_input, default_case)
        switch_case()
        if switch_case == exit_menu:
            continue_menu = False
    print("\n")

if __name__ == '__main__':
    main()
    