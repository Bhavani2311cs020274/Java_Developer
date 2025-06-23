import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner calculator = new Scanner(System.in);
        

        System.out.println("Basic Calculator");
        char choice = 'y';  

        do {
        
            System.out.print("\nEnter first number: ");
            double num1 = calculator.nextDouble();

            System.out.print("Enter operator (+ , - , * , % , /): ");
            char operator = calculator.next().charAt(0);

            System.out.print("Enter second number: ");
            double num2 = calculator.nextDouble();

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;
                    
                case '%':
                    result = num1 % num2;
                    break;

                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                        continue;
                    }
                    result = num1 / num2;
                    break;

                default:
                    System.out.println("Error: Invalid operator.");
                    continue;
            }

            System.out.printf("\nResult: %.3f %c %.3f = %.3f\n", num1, operator, num2, result);

            System.out.print("\nDo you want to perform another calculation? ");
            choice = calculator.next().toLowerCase().charAt(0);
            //charAt(0) only choices the 0 index number char

        } while (choice == 'y');

        System.out.println("Calculator exited. Thank you!");
        calculator.close();
    }
}