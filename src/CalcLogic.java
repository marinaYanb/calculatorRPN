import java.util.ArrayDeque;
import java.util.Deque;

public class CalcLogic {

    public static double calculate(String parsedString) {
        String[] parsedStringArray = parsedString.split(" ");
        Deque<Double> deque = new ArrayDeque<>();
        for (String s : parsedStringArray) {
            if (!isNumber(s)) {
                double a = deque.pop();
                double b = deque.pop();
                switch (s) {
                    case "+":
                        deque.push(a + b);
                        break;
                    case "-":
                        deque.push(b - a);
                        break;
                    case "*":
                        deque.push(a * b);
                        break;
                    case "/":
                        if (a == 0) {
                            throw new ArithmeticException();
                        } else {
                            deque.push(b / a);
                        }
                        break;
                }
            } else {
                deque.push(Double.parseDouble(s));
            }
        }
        return deque.peek();
    }

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
