#Created by: Antonio Scalfaro
#CMIS 102, 4/12/2023
#This program calculates weighted grades for students in a class and tracks the
#highest graded student and prints out the result

#Welcome Message Func
def welcomeMessage():
    print('Created by: Antonio Scalfaro')
    print('\nCMIS 102, 4/12/2023')
    print('\nThis program will calculate the weighted average grade for students')
    print('\nand will display the highest graded student')
    print('\nValid grades are 0-100')

#Collect grades and multiply by their weight, return weighted grades as one grade
#Pass in str student, float grade. Checks for valid input using while loop
def collectGrades(student, grade):
    #Set weights, discussion = .15, quiz = .35, assignment = .50
    discussionWt = .15
    quizWt = .35
    assignmentWt = .50

    #Set discussion, quiz, and assignment grades via user input
    discussionGrade = float(input('\nWhat was {}\'s discussion grade?\t'.format(student)))
    quizGrade = float(input('\nWhat was {}\'s quiz grade?\t'.format(student)))
    assignmentGrade = float(input('\nWhat was {}\'s assignment grade?\t'.format(student)))

    counter = 0
    #Check valid inputs for grade, recursively call collectGrades until valid input
    while(counter == 0):
        if (checkInvalid(discussionGrade)):
            print('\nError, valid input is 0-100')
            counter += 1
            return collectGrades(student, grade) 
        elif (checkInvalid(quizGrade)):
            print('\nError, valid input is 0-100')
            counter += 1
            return collectGrades(student, grade)  
        elif (checkInvalid(assignmentGrade)):
            print('\nError, valid input is 0-100')
            counter += 1
            return collectGrades(student, grade) 
        else:
            counter += 1
            
    totalGrade = discussionGrade*discussionWt + quizGrade*quizWt + assignmentGrade*assignmentWt
    return totalGrade

#Invalid input func to see if grades are between 0 and 100, returns true if not or false if in range
def checkInvalid(grade):
    return (grade < 0 or grade > 100)

#Main ----------------------------------------------------------------------------------
def main():
    welcomeMessage()

    #Create two arrays, students and grades
    students = ['John', 'Mary', 'Elise', 'Mike']
    grades = [0.0, 0.0, 0.0, 0.0]

    counter = 0
    highGrade = 0
    
    for student in students:
        #Set students grade to return of collectGrades
        grades[counter] = collectGrades(student, grades[counter])

        #Find Highest Grade so far
        if(grades[counter] > highGrade):
            highGrade = grades[counter]
            #Set idx = counter to access students array at correct index
            idx = counter
        counter += 1

    #Print Student's name and grade with high score
    print('\nThe highest graded student is {}'.format(students[idx]))
    print('They had a grade of {}%'.format(highGrade))
    



#Execute----------------------------------------------------
main()
