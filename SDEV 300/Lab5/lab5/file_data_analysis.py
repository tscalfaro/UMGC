'''
Created on Nov 15, 2023

@author: tscal
Created by: Antonio Scalfaro
SDEV 300 / 7381
Lab 5 - Data Analysis
This program gives the user the option to read in data from two csv files. The first is Population
Data for geographical regions in the US and the second is Housing Data. The user will be given 
a list of columns from the data set to get statistics and a histogram from. This program utilizes
pandas, matplotlib, and numpy.
'''
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

def welcome_message():
    """
    Print welcome message with program and developer details
    """
    print("Created by: Antonio Scalfaro")
    print("SDEV 300 / 7381")
    print("Lab 5 - Data Analysis")
    print("This program gives the user the option to read in data from two csv files.")
    print("The first is Population Data for geographical regions in the US.")
    print("The second is Housing Data. The user will be given a list of columns from ")
    print("the data to get statistics and a histogram from.")
    print("---------------------------------------------------------\n")

def exit_message():
    """
    Print exit message
    """
    print("Thank you for using the Data Analysis program\n")
    print("---------------------------------------------------------\n")

def file_menu():
    """
    Print file menu and return selection, blank String if Exit
    """
    f = "" #File name
    while True:
        print("Select the file you'd like to analyze")
        print("1 - Population Data")
        print("2 - Housing Data")
        print("3 - Exit")
        selection = input().strip()
        try:
            selection = int(selection)
            if selection == 1:
                print("You've selected Population Data")
                f = "PopChange.csv"
                break
            elif selection == 2:
                print("You've selected Housing Data")
                f = "Housing.csv"
                break
            elif selection == 3: #Exit chosen
                break
            else:
                print("Selection not valid, try again.")
                continue
        except ValueError as e:
            print(f"Error: {e}. Please enter valid numeric input")
    return f

def housing_menu(df):
    """
    Displays Housing menu, displays statistics (mean, max, min,
    count, standard deviation) for selected column, displays
    histogram for the selected column
    """
    column_dict = {
    1: "AGE",
    2: "BEDRMS",
    3: "BUILT",
    4: "ROOMS",
    5: "UTILITY"
    }
    menu_token = True
    while menu_token: #Loop for menu
        print("Please select the column you want analyzed:")
        print("1 - Age")
        print("2 - Bedrooms")
        print("3 - Built")
        print("4 - Rooms")
        print("5 - Utility")
        print("6 - Exit")
        choice = input().strip()
        try:
            choice = int(choice)
            if 1 <= choice <= 6:
                if choice == 6: #Exit column menu
                    menu_token = False
                    continue
                column_name = column_dict.get(choice)
                #Calc stats
                count = np.size(df[column_name])
                the_min = np.min(df[column_name])
                the_max = np.max(df[column_name])
                mean = round(np.mean(df[column_name]), 2)
                std_deviation = round(np.std(df[column_name]), 2)
                #Print stats
                print("The statistics for this column are as follows:")
                print(f"Count = {count}")
                print(f"Mean = {mean}")
                print(f"Standard Deviation = {std_deviation}")
                print(f"Min = {the_min}")
                print(f"Max = {the_max}\n")
                plt.hist(df[column_name], edgecolor='black')
                plt.xlabel(column_name)
                plt.ylabel("Number of Houses")
                plt.title(f"Histogram for {column_name}")
                plt.show()
            else:
                raise ValueError
        except ValueError as e:
            print(f"Error: {e}. Please enter valid numeric input")

def pop_change_menu(df):
    """
    Displays population change menu, takes selected column choice
    and displays the statistics (mean, max, min, count, and standard
    deviation) for it. Finally, displays a histogram of the column
    """
    column_dict = {
        1: "Pop Apr 1",
        2: "Pop Jul 1",
        3: "Change Pop"
        }
    menu_token = True
    while menu_token: #Loop for menu
        print("Please select the column you want analyzed:")
        print("1 - Pop Apr 1")
        print("2 - Pop Jul 1")
        print("3 - Change Pop")
        print("4 - Exit Column")
        choice = input().strip()
        try:
            choice = int(choice)
            if 1 <= choice <= 4:
                if choice == 4: #Exit column menu
                    menu_token = False
                    continue
                column_name = column_dict.get(choice)
                #Calc stats
                count = np.size(df[column_name])
                the_min = np.min(df[column_name])
                the_max = np.max(df[column_name])
                mean = round(np.mean(df[column_name]), 2)
                std_deviation = round(np.std(df[column_name]), 2)
                #Print stats
                print("The statistics for this column are as follows:")
                print(f"Count = {count}")
                print(f"Mean = {mean}")
                print(f"Standard Deviation = {std_deviation}")
                print(f"Min = {the_min}")
                print(f"Max = {the_max}\n")
                #Histogram of column selected
                plt.hist(df[column_name], edgecolor='black')
                plt.xlabel(column_name)
                plt.ylabel("Number of Territories")
                plt.title(f"Histogram for {column_name}")
                plt.show()
            else:
                raise ValueError
        except ValueError as e:
            print(f"Error: {e}. Please enter valid numeric input")

def main():
    """
    Main function to initiate program
    """
    welcome_message()
    program_cont = True #Continue Token
    while program_cont:
        file_name = file_menu() #Get file name or empty string for exit
        if len(file_name) == 0: #Exit option chosen
            exit_message()
            program_cont = False
            continue
        df = pd.read_csv(file_name) #Read in data
        if file_name == "Housing.csv":
            housing_menu(df)
        else: #file name is PopChange.csv
            pop_change_menu(df)

if __name__ == '__main__':
    main()
