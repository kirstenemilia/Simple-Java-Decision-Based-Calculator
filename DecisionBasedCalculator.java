import java.util.Scanner;
public class DecisionBasedCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String operation;
        boolean running = true;

        while (running)
        {
            System.out.println("Choose an operation: (+, -, *, /) or type 'exit' to quit:");
            operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("exit")) // Checks if user inputs exit and if it does, print message
            {
                System.out.println("Exiting calculator. Bye!");
                running = false;
                continue;
            }

            if (!(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/"))) // Checks if user entered invalid operation
            {
                System.out.println("Invalid operation.");
                continue;
            }

           double firstNum; // Gets first num in range
           while (true) 
           {
                System.out.print("Enter first number, from -1000 to 1000: ");
                firstNum = getValidNumber(scanner);
                if (firstNum >= -1000 && firstNum <= 1000) 
                {
                break; // valid number, exit the loop
                }
                System.out.println("Number out of range.");
            }

           double secondNum; // Get second num in range
           while (true) 
           {
                System.out.print("Enter second number, from -1000 to 1000: ");
                secondNum = getValidNumber(scanner);
                if (secondNum >= -1000 && secondNum <= 1000) 
                {
                    break; // valid number, exit the loop
                }
                System.out.println("Number out of range.");
            }

            if (operation.equals("/")) 
            {
                while (secondNum == 0) 
                {
                System.out.println("Error, cannot divide by zero.");
                System.out.print("Enter second number (non-zero), from -1000 to 1000: ");
                secondNum = getValidNumber(scanner);
                }
            }

            double result;
            switch(operation)
            {
                case "+":
                    result = firstNum + secondNum;
                    System.out.println("Result: " + result);
                    break;

                case "-":
                    result = firstNum - secondNum;
                    System.out.println("Result: " + result);
                    break;

                case "*":
                    result = firstNum * secondNum;
                    System.out.println("Result: " + result);
                    break;

                case "/":
                    result = firstNum / secondNum;
                    System.out.println("Result: " + result);
                    break;

                default:
                    System.out.println("Error");

            }


        }
        scanner.close();

    }

    public static double getValidNumber(Scanner scanner)
    {
        while (!scanner.hasNextDouble()) // Checks if input can be interpreted as double
        {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next(); // Discards invalid input 
        }
        double num = scanner.nextDouble(); // Reads number
        scanner.nextLine(); // Consumes the leftover newline character
        return num;
    }

}