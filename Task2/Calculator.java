
// I will be proving each line with what i am trying to do for better understanding of my code.
/* The instructions are as follows it will ask for your choice 
you should enter a double data type else it will display a message please enter a valid input . */
import java.util.*; // importing util package for using Scanner class

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Defining Scanner for taking user input
        int choice = 0; // Initializing choice with a default value
        double num1, num2; // declaring two variables for user input for arithmetic calculations.
        // Here I have used do-while loop to run the calculator atleast once.
        do {
            System.out.println("Calculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String ch = in.next();

            // I have used Switch statement to create a menu driven program.
            // use of try and catch block so that it can handle unwanted exceptions.
            try {
                choice = Integer.parseInt(ch);
                switch (choice) {
                    // for performing Addition
                    case 1:
                        // command();
                        // num1 = in.nextDouble();
                        // num2 = in.nextDouble();
                        num1 = getNumber("Enter the first number: ");
                        num2 = getNumber("Enter the second number: ");
                        double result = add(num1, num2);
                        System.out.println("Result: " + result);
                        break;

                    // for performing Substraction
                    case 2:
                        // command();
                        // num1 = in.nextDouble();
                        // num2 = in.nextDouble();
                        num1 = getNumber("Enter the first number: ");
                        num2 = getNumber("Enter the second number: ");
                        result = subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;

                    // for performing Multiplication
                    case 3:
                        // command();
                        // num1 = in.nextDouble();
                        // num2 = in.nextDouble();
                        num1 = getNumber("Enter the first number: ");
                        num2 = getNumber("Enter the second number: ");
                        result = multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;

                    // for performing Division
                    case 4:
                        // command();
                        // num1 = in.nextDouble();
                        // num2 = in.nextDouble();
                        num1 = getNumber("Enter the first number: ");
                        num2 = getNumber("Enter the second number: ");
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                        } else {
                            result = divide(num1, num2);
                            System.out.println("Result: " + result);
                        }
                        break;
                    // for Exiting the application
                    case 5:
                        System.out.println("Exiting calculator.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
            }
        } while (choice != 5);
        in.close();
    }

    // Function to get a valid numeric input from the user
    private static double getNumber(String message) {
        Scanner sc = new Scanner(System.in);
        double number;
        do {
            System.out.print(message);
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print(message);
                sc.next();
            }
            number = sc.nextDouble();
        } while (number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY || Double.isNaN(number));
        return number;

    }

    // Function to perform addition
    private static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Function to perform subtraction
    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Function to perform multiplication
    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Function to perform division
    private static double divide(double num1, double num2) {
        return num1 / num2;
    }
}
