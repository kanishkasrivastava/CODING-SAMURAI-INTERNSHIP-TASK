// In this i have used comments to make this project user friendly.
/* How to operate it 
 * You just have to run this code and then 4 messages will come 
 * like enter your assignment mars , quiz marks and etc and
 * you will get desired result.
*/

import java.util.*;

public class GradeCalculator {
    // Defining a method to calculate the letter grade to increase reusability, and
    // increased readability.
    // This function will check finalgrade and give the output.
    public static String calculateLetterGrade(double finalGrade, double[] gradeRanges, String[] letterGrades) {
        for (int i = 0; i < gradeRanges.length; i++) {
            if (finalGrade >= gradeRanges[i]) {
                return letterGrades[i];
            }
        }
        return "F"; // Default grade will be "F"
    }

    /*
     * A function to handle I/O exceptions at various locations in our code
     * entered by
     * the user
     */
    public static double getValidDoubleInput(Scanner in, String prompt) {
        double value = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt);
            String number = in.next();
            // Exception handler Try is used to avoid conflicts if any I/O exception occurs
            try {
                value = Double.parseDouble(number);
                /*
                 * Generally total marks is 100 and marks wont be negative so using this
                 * condition
                 */
                if (value >= 0 && value <= 100) {
                    validInput = true;
                }
                // Else block will be executed if number is negative or more than 100.
                else {
                    System.out.println("Invalid input. Please enter a valid numeric grade between 0 and 100.");
                }
            }
            // Catch block will display proper message if any non numeric value is entered.
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric grade.");
            }
        } while (!validInput);
        return value;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Displaying a welcome message and instructions to the user i.e, the Teacher.
        System.out.println("Welcome to the Student Grade Calculator!");
        double[] gradeRanges = { 90, 80, 70, 40, 0 };
        /*
         * Defining the grading scale A is outstanding B for Excellent and C for good D
         * for pass and F for fail.
         * Here i am using String in place of char because Handling errors and invalid
         * inputs is simpler with String
         */
        String[] letterGrades = { "A", "B", "C", "D", "F" };
        double assignmentGrade, quizGrade, midtermGrade, finalExamGrade, finalGrade;
        assignmentGrade = getValidDoubleInput(in, "Please enter your assignment marks: ");
        quizGrade = getValidDoubleInput(in, "Enter your quiz grade: ");
        midtermGrade = getValidDoubleInput(in, "Enter your midterm exam grade: ");
        finalExamGrade = getValidDoubleInput(in, "Enter your final exam grade: ");
        // to store marks obtained in FInal Exam
        /*
         * The marks will be calculated as 20% of total marks is taken from quiz and
         * assignment i.e 10% from each and 80% marks is taken from mid term and final
         * exam i.e, 80% and all are added together to get 100 marks and then the grade
         * is compared.
         */
        finalGrade = (assignmentGrade * 0.10) + (quizGrade * 0.10) + (midtermGrade * 0.40)
                + (finalExamGrade * 0.40);
        System.out.println("Your final course grade is: " + finalGrade);
        System.out.println("Your letter grade is: " + calculateLetterGrade(finalGrade, gradeRanges, letterGrades));
        in.close();
    }
}
