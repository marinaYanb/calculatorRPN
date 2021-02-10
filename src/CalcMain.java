import java.util.Scanner;

public class CalcMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String scr;
        do {
            System.out.print("To exit enter 'Q'\n");
            System.out.print("Enter your math expression: ");
            scr = input.nextLine();
            try {
                CalcStringValidator.validate(scr);
                System.out.printf("%.1f", CalcLogic.calculate(CalcStringParser.parseToRPN(scr)));
                System.out.println();
            } catch (ArithmeticException e) {
                System.out.println("Division by zero");
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect format");
            }
        } while (!scr.equals("Q"));
    }
}

