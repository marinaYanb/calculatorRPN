import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcStringValidator {
    public static boolean validate(String src) {
        Pattern pattern = Pattern.compile("^(\\d+(\\.\\d+)*\\s*(\\+|\\-|\\/|\\*)\\s*)+\\d+(\\.\\d+)*$");
        Matcher matcher = pattern.matcher(src);
        if (matcher.find()) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
