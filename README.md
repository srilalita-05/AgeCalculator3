***AgeCalculator3** - Java Program to Calculate Age*
*Overview*

This program calculates the age of a person based on their date of birth (DOB). It takes the user's DOB as input in the format dd-MM-yyyy and computes their age in years, months, and days. The program also performs various validations to ensure the provided date is correct and in the right format.
Prerequisites

Before running the program, make sure you have the following:

    Java Development Kit (JDK) installed (preferably version 8 or above).
    A command-line interface (CLI) like Terminal (Mac/Linux) or Command Prompt (Windows).

*How the Program Works*
1. Input:

    The program accepts the date of birth (DOB) as a command-line argument.
    The expected input format for the date is: dd-MM-yyyy.
    Example: 25-12-1995.

2. Validations:

    Check for Missing Input: If no input is provided, the program will print an error message and exit.
    Date Format Check: The input string is split and parsed to check if it follows the correct format.
    Month Check: Ensures the month provided is between 1 and 12.
    Day Check: Verifies if the provided day is valid for the given month and year (e.g., February 29th is valid only in leap years).
    Future Date Check: Ensures the provided date of birth is not in the future compared to the current date.

3. Age Calculation:

    After the date of birth is validated, the program calculates the age by comparing the DOB with the current date.
    The difference is expressed in terms of years, months, and days.

4. Output:

    The program prints the calculated age in a user-friendly format:
        Your age is X years, Y months, and Z days.
    If any error occurs, appropriate error messages are displayed.

**Code Walkthrough**

*Let's break down the key parts of the code:*

1. Input Handling

The program starts by checking if an argument (DOB) is passed through the command line:

    if (args.length == 0) {
        System.out.println("Please provide your date of birth as a command-line argument in the format dd-MM-yyyy.");
        return;
    }

If no argument is provided, it prints an error message and exits.

2. Parsing and Validation

The input string is split into three parts (day, month, and year):

    String[] dateParts = dobInput.split("-"); 

If there are not exactly three parts (day, month, year), a DateTimeParseException is thrown.

We also check if the month is between 1 and 12:

    if (month < 1 || month > 12) {
        System.out.println("Invalid date: month must be between 1 and 12.");
        return;
    }

3. Day Validation

The isValidDay method checks if the provided day is valid for the given month and year (considering leap years for February). It handles the different number of days in each month:

    private static boolean isValidDay(int day, int month, int year) {
        // Handles days in February, months with 30 days, and months with 31 days
    }

4. Leap Year Check

Leap years are calculated in the isLeapYear method:

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

5. Age Calculation

Once the input is validated, the program calculates the age using the Period.between() method from the java.time package:

    LocalDate dob = LocalDate.of(year, month, day);
    LocalDate currentDate = LocalDate.now();
    Period age = Period.between(dob, currentDate);

This gives the age in years, months, and days.
6. Error Handling

The program includes error handling for:

    Invalid input: When the date is in the wrong format or the numbers don't make sense (e.g., month > 12).
    Future date: The program checks if the DOB is in the future, which is an invalid input.

*How to Run the Program*

1. Compile the Program:

Open your terminal/command prompt and navigate to the directory where the file is saved. Compile the Java file with the following command:

    javac AgeCalculator3.java

2. Run the Program:

To run the program, provide your date of birth as an argument in the correct format (dd-MM-yyyy):

    java AgeCalculator3 25-12-1995

This will output something like:

    Your age is 28 years, 2 months, and 15 days.

Examples

Valid input:

    java AgeCalculator3 01-01-2000

Output:

    Your age is 24 years, 10 months, and 5 days.

Invalid input (future date):

    java AgeCalculator3 01-01-2025

Output:

    The date of birth cannot be in the future.

Invalid format (incorrect delimiter):

    java AgeCalculator3 01/01/2000

Output:

    Invalid date format or non-existent date. Please enter the date in the format dd-MM-yyyy.

**Conclusion**

This program provides an easy-to-use method to calculate a person's age based on their date of birth. It ensures that the input is valid, performs the necessary checks, and handles errors gracefully. You can use this as a foundation for more complex date-based calculations in Java.
