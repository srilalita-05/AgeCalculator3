import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class AgeCalculator3 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide your date of birth as a command-line argument in the format dd-MM-yyyy.");
            return;
        }

        String dobInput = args[0];

        try {
            // Split the input string to manually parse day, month, and year
            String[] dateParts = dobInput.split("-");
            if (dateParts.length != 3) {
                throw new DateTimeParseException("Invalid format", dobInput, 0);
            }

            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            // Check if the input month is valid
            if (month < 1 || month > 12) {
                System.out.println("Invalid date: month must be between 1 and 12.");
                return;
            }

            // Check if the input day is valid for the given month and year
            if (!isValidDay(day, month, year)) {
                System.out.println("Invalid date: " + dobInput + " is not a valid date.");
                return;
            }

            LocalDate dob = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now();

            // Check if the date of birth is in the future
            if (dob.isAfter(currentDate)) {
                System.out.println("The date of birth cannot be in the future.");
                return;
            }

            // Calculate the age
            Period age = Period.between(dob, currentDate);
            System.out.printf("Your age is %d years, %d months, and %d days.%n",
                    age.getYears(), age.getMonths(), age.getDays());

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: please enter numeric values for day, month, and year in the format dd-MM-yyyy.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format or non-existent date. Please enter the date in the format dd-MM-yyyy.");
        }
    }

    // Method to check if the day is valid for the given month and year
    private static boolean isValidDay(int day, int month, int year) {
        // Handle days in each month
        if (day < 1) return false;

        switch (month) {
            case 2: // February
                if (isLeapYear(year)) {
                    return day <= 29;
                } else {
                    return day <= 28;
                }
            case 4: case 6: case 9: case 11: // April, June, September, November
                return day <= 30;
            default: // All other months have 31 days
                return day <= 31;
        }
    }

    // Helper method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
