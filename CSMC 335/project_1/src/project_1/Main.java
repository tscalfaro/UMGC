/*
 * Created by: Antonio Scalfaro
 * Due: 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Main class which is used to initiate the Shapes program. It contains 13 public
 * methods, they are as follows:
 * void welcomeMessage() - Displays welcome message with program and developer details.
 * void exitMessage() - Displays exit message when program terminates.
 * int userMenu(Scanner) - Displays the user menu, loops until valid entry is input and returns 
 * 						   the desired choice as an int.
 * void constructCircle(Scanner) - Accepts input for radius of the circle to be created, loops until
 * 								   valid entry is input (positive numeric value). Creates a Circle 
 * 								   and displays the area of the Circle.
 * void constructRectangle(Scanner) - Accepts input for length and width of rectangle to be created,
 * 									  loops until valid entries are input (positive numeric value).
 * 									  Creates Rectangle and displays the area of the Rectangle.
 * void constructSquare(Scanner) - Accepts input for the side length of a square to be created, loops
 * 								   until valid entry is input (positive numeric value). Creates
 * 								   Square and displays the area of the Square.
 * void constructTriangle(Scanner) - Accepts input for the legs of a triangle to be created, loops
 * 									 until valid entries are input (positive numeric values) and 
 * 									 checks that the input entries can form a valid triangle. Creates
 * 									 Triangle and displays area of the Triangle.
 * void constructSphere(Scanner) - Accepts input for the radius of a sphere to be created, loops
 * 								   until valid entry is input (positive numeric value). Creates
 * 								   Sphere and displays the volume of the Sphere.
 * void constructCube(Scanner) - Accepts input for the side length of cube to be created, loops until
 * 								 valid entry is input (positive numeric value). Creates Cube and
 * 								 displays the volume of the Cube.
 * void constructCone(Scanner) - Accepts input for the radius of the base and the height of the cone
 * 								 to be created, loops until valid entries are input (positive numeric
 * 								 values). Creates Cone and displays volume of the Cone.
 * void constructCylinder(Scanner) - Accepts input for the radius and height of right cylinder to be
 * 									 created, loops until valid entries are input (positive numeric
 * 									 values). Creates Cylinder and displays the volume of the Cylinder.
 * void constructTorus(Scanner) - Accepts input for the major radius and minor radius of torus to be
 * 								  created, loops until valid entries are input (positive numeric values)
 * 								  and checks that the minor radius is not greater than or equal to the 
 * 								  major radius. Creates Torus and displays the volume of the Torus.
 * void main(String[]) - Initiates the program and calls methods as they are needed. Creates HashMap to 
 * 						 store the methods for Shape creations and loops until exit selection is made and
 * 						 returned from userMenu()
 * */

package project_1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void welcomeMessage() {
		System.out.println("Created by: Antonio Scalfaro");
		System.out.println("CMSC 335 - Project 1");
		System.out.println("Due: 03/26/2024");
		System.out.println("Welcome to the Shapes Program.");
		System.out.println("This program is designed to practice inheritance in Java");
		System.out.println("by prompting the user to create 2D or 3D shapes chosen from");
		System.out.println("the user menu. The user will provide the appropriate specifications");
		System.out.println("and the program will output the area (2D) or the volume (3D) of the shape.");
		System.out.println("############################################################################");
	}
	
	public static void exitMessage() {
		System.out.println("");
		System.out.println("############################################################################");
		System.out.println("Thanks for using the Shape Program.");
		System.out.println("Goodbye!");
	}
	
	public static int userMenu(Scanner scanner) {
		
		String input = "";
		int choice = 0;
		System.out.println("");
		System.out.println("1. Construct a Circle");
		System.out.println("2. Construct a Rectangle");
		System.out.println("3. Construct a Square");
		System.out.println("4. Construct a Triangle");
		System.out.println("5. Construct a Sphere");
		System.out.println("6. Construct a Cube");
		System.out.println("7. Construct a Cone");
		System.out.println("8. Construct a Cylinder");
		System.out.println("9. Construct a Torus");
		System.out.println("10. Exit Program");
		input += scanner.nextLine().strip();
		try {
			choice = Integer.parseInt(input);
			if(choice < 1 || choice > 10) {
				System.out.println("Menu choice not available, please input a valid int.");
				return userMenu(scanner);
			}
		}catch(NumberFormatException e) {
			System.out.println("Invalid input, please input an integer between 1 and 10.");
			return userMenu(scanner);
		}
		return choice;
	}
	
	public static void constructCircle(Scanner scan) {
		
		double radius = 0.0;
		while(true) {
			System.out.println("Please input the radius of the circle you wish to construct:");
			try {
				radius = scan.nextDouble();
				scan.nextLine();
				if(radius <= 0) {
					System.out.println("The radius cannot be negative or 0.");
				}else {
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("The radius must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		Circle c = new Circle(radius);
		double circleArea = c.getArea();
		System.out.println("The area of a circle with radius " + radius + " is " + circleArea);
	}
	
	public static void constructRectangle(Scanner scan) {
		
		double width = 0.0;
		double length = 0.0;
		
		while(true) {
			System.out.println("Please input the width of the rectangle:");
			try {
				width = scan.nextDouble();
				scan.nextLine();
				if(width <= 0) {
					System.out.println("The width cannot be negative or 0.");
				} else {
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println("The width must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		
		while(true) {
			System.out.println("Please input the length of the rectangle:");
			try {
				length = scan.nextDouble();
				scan.nextLine();
				if(length <= 0) {
					System.out.println("The length cannot be negative or 0.");
				} else {
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println("The length must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		
		Rectangle r = new Rectangle(length, width);
		double rectArea = r.getArea();
		System.out.println("The area of a rectangle with width " + width + " and length " +
				length + " is " + rectArea);
	}
	
	public static void constructSquare(Scanner scan) {
		
		double side = 0.0;
		
		while(true) {
			System.out.println("Please input the length of the sides of the square:");
			try {
				side = scan.nextDouble();
				scan.nextLine();
				if(side <= 0) {
					System.out.println("The length of the sides cannot be negative or 0");
				} else {
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("The side length must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		
		Square s = new Square(side);
		double squareArea = s.getArea();
		System.out.println("A square with side length of " + side + " has an area " + squareArea);
	}
	
	public static void constructTriangle(Scanner scan) {
		
		double leg1 = 0.0;
		double leg2 = 0.0;
		double leg3 = 0.0;
		
		while(true) {
			System.out.println("Please input the first leg of the triangle:");
			try {
				leg1 = scan.nextDouble();
				scan.nextLine();
				if (leg1 <= 0) {
					System.out.println("The leg cannot be a negative or 0 value");
				} else {
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println("The input for the leg must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		
		while(true) {
			System.out.println("Please input the second leg of the triangle:");
			try {
				leg2 = scan.nextDouble();
				scan.nextLine();
				if (leg2 <= 0) {
					System.out.println("The leg cannot be a negative or 0 value");
				} else {
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println("The input for the leg must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		
		while(true) {
			System.out.println("Please input the final leg of the triangle:");
			try {
				leg3 = scan.nextDouble();
				scan.nextLine();
				if (leg3 <= 0) {
					System.out.println("The leg cannot be a negative or 0 value");
				} else {
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println("The input for the leg must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		
		if (leg1 + leg2 <= leg3 || leg2 + leg3 <= leg1 || leg1 + leg3 <= leg2) {
			System.out.println("Sorry, the legs you entered cannot form a valid triangle.");
			System.out.println("Please try again.");
			constructTriangle(scan);
		} else {
			Triangle t = new Triangle(leg1, leg2, leg3);
			double triangleArea = t.getArea();
			System.out.println("The area of a triangle with legs " + leg1 + ", " + leg2 + ", " +
					leg3 + " is " + triangleArea);
		}
		
	}
	
	public static void constructSphere(Scanner scan) {
		
		double radius = 0.0;
		while(true) {
			System.out.println("Please input the radius of the sphere you wish to construct:");
			try {
				radius = scan.nextDouble();
				scan.nextLine();
				if(radius <= 0) {
					System.out.println("The radius cannot be negative or 0.");
				}else {
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("The radius must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		Sphere s = new Sphere(radius);
		double sphereVolume = s.getVolume();
		System.out.println("The volume of a sphere with radius " + radius + " is " + sphereVolume);
	}
	
	public static void constructCube(Scanner scan) {
		
		double side = 0.0;
		
		while(true) {
			System.out.println("Please input the length of the sides of the cube:");
			try {
				side = scan.nextDouble();
				scan.nextLine();
				if(side <= 0) {
					System.out.println("The length of the sides cannot be negative or 0");
				} else {
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("The side length must be a nonnegative numeric value");
				scan.nextLine();
			}
		}
		
		Cube c = new Cube(side);
		double cubeVolume = c.getVolume();
		System.out.println("A cube with side length of " + side + " has a volume " + cubeVolume);
	}
	
	public static void constructCone(Scanner scan) {
		
		double radius = 0.0;
		double height = 0.0;
		
		while(true) {
			System.out.println("Please input the radius of the cone:");
			try {
				radius = scan.nextDouble();
				scan.nextLine();
				if(radius <= 0) {
					System.out.println("The radius cannot be 0 or a negative value");
				}else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("The radius must be a positive numeric value");
				scan.nextLine();
			}
		}
		
		while(true) {
			System.out.println("Please input the height of the cone:");
			try {
				height = scan.nextDouble();
				scan.nextLine();
				if(height <= 0) {
					System.out.println("The height cannot be 0 or a negative value");
				}else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("The height must be a positive numeric value");
				scan.nextLine();
			}
		}
		
		Cone c = new Cone(radius, height);
		double coneVolume = c.getVolume();
		System.out.println("The volume of a cone with radius " + radius + " and height " +
				height + " is " + coneVolume);
	}
	
	public static void constructCylinder(Scanner scan) {
		
		double radius = 0.0;
		double height = 0.0;
		
		while(true) {
			System.out.println("Please input the radius of the cylinder:");
			try {
				radius = scan.nextDouble();
				scan.nextLine();
				if(radius <= 0) {
					System.out.println("The radius cannot be 0 or a negative value");
				}else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("The radius must be a positive numeric value");
				scan.nextLine();
			}
		}
		
		while(true) {
			System.out.println("Please input the height of the cylinder:");
			try {
				height = scan.nextDouble();
				scan.nextLine();
				if(height <= 0) {
					System.out.println("The height cannot be 0 or a negative value");
				}else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("The height must be a positive numeric value");
				scan.nextLine();
			}
		}
		
		Cylinder c = new Cylinder(radius, height);
		double cylinderVolume = c.getVolume();
		System.out.println("The volume of a cylinder with radius " + radius + " and height " +
				height + " is " + cylinderVolume);
	}
	
	public static void constructTorus(Scanner scan) {
		
		double majorRadius = 0.0;
		double minorRadius = 0.0;
		
		while(true) {
			System.out.println("Please input the major radius of the torus:");
			try {
				majorRadius = scan.nextDouble();
				scan.nextLine();
				if(majorRadius <= 0) {
					System.out.println("The major radius cannot be 0 or a negative value");
				} else {
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println("The major radius must be a positive numeric value");
				scan.nextLine();
			}
		}
		
		while(true) {
			System.out.println("Please input the minor radius of the torus:");
			try {
				minorRadius = scan.nextDouble();
				scan.nextLine();
				if(minorRadius <= 0) {
					System.out.println("The minor radius cannot be 0 or a negative value");
				} else if (minorRadius >= majorRadius) {
					System.out.println("The minor radius must be less than the major radius");
				} else {
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println("The minor radius must be a positive numeric value");
				scan.nextLine();
			}
		}
		
		
		Torus t = new Torus(majorRadius, minorRadius);
		double torusVolume = t.getVolume();
		System.out.println("The volume of a torus with major radius " + majorRadius +
				" and minor radius " + minorRadius + " is " + torusVolume);
	}
	
	public static void main(String[] args) {
		
		welcomeMessage();

		Scanner scanner = new Scanner(System.in);
		Map<Integer, Runnable> methods = new HashMap<>();
		methods.put(1, () -> constructCircle(scanner));
		methods.put(2, () -> constructRectangle(scanner));
		methods.put(3, () -> constructSquare(scanner));
		methods.put(4, () -> constructTriangle(scanner));
		methods.put(5, () -> constructSphere(scanner));
		methods.put(6, () -> constructCube(scanner));
		methods.put(7, () -> constructCone(scanner));
		methods.put(8, () -> constructCylinder(scanner));
		methods.put(9, () -> constructTorus(scanner));
		methods.put(10, Main::exitMessage);
		
		System.out.println("Please select an option from the menu by inputting a valid int:");
		int userInput;
		String continueToken;
		do {
			userInput = userMenu(scanner);
			methods.get(userInput).run();
			if (userInput != 10) {
				System.out.println("Do you wish to continue? Y/N");
				continueToken = scanner.nextLine().strip();
				while(!(continueToken.equalsIgnoreCase("Y") || continueToken.equalsIgnoreCase("N"))) {
					System.out.println("Sorry, that input is not recognized");
					System.out.println("Do you wish to continue? Y/N");
					continueToken = scanner.nextLine();
				}
				if(continueToken.equalsIgnoreCase("N")) {
					userInput = 10;
					methods.get(userInput).run();
				}
			}
		}while(userInput != 10);
		scanner.close();
	}

}
