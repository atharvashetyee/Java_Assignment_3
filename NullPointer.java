import java.util.Scanner;

public class NullPointer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to convert to integer: ");
        String input = scanner.nextLine();

        try {
            // Attempt to convert the input string to an integer
            int number = Integer.parseInt(input);
            System.out.println("Converted integer: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: The input is not a valid integer.");
        } catch (NullPointerException e) {
            System.out.println("Error: Input is null.");
        } finally {
            System.out.println("Conversion attempt completed.");
            scanner.close();
        }
    }
}
