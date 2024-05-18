def perform_operation(operator, num1, num2):
    if operator == '+':
        return num1 + num2
    elif operator == '-':
        return num1 - num2
    elif operator == '*':
        return num1 * num2
    elif operator == '/':
        if num2 == 0:
            return "Error: Cannot divide by zero."
        return num1 / num2
    #Adding the operand '%' for modulus calculations
    elif operator == '%':
        return num1 % num2
    else:
        return "Error: Invalid operator."


def main():
    operator = input("Enter the operator (+, -, *, /, %): ")
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))

    result = perform_operation(operator, num1, num2)
    print("Result:", result)


if __name__ == "__main__":
    main()
