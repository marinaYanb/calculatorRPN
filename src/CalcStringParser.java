import java.util.ArrayDeque;
import java.util.Deque;

public class CalcStringParser {

    public static String parseToRPN(String scr) {
        StringBuilder parsedString = new StringBuilder();
        char[] tokens = scr.replaceAll("\\s", "").toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char token : tokens) {
            if (Character.isDigit(token) || token == '.') {
                parsedString.append(token);
            } else {
                parsedString.append(" ");
                if (deque.size() != 0 && priority(token) <= priority(deque.peek())) {
                    parsedString.append(deque.pop()).append(" ");
                }
                deque.push(token);
            }
        }
        while (!deque.isEmpty()) {
            parsedString.append(" ");
            parsedString.append(deque.pop());
        }
        return parsedString.toString().trim();
    }

    private static int priority(char token) {
        if (token == '*' || token == '/') {
            return 1;
        } else {
            return 0;
        }
    }
}