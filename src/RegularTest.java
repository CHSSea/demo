import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
    public static void main(String[] args) {
        String regular = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher("110101199003073677");

        System.out.println(matcher.find());
        System.out.println(matcher.group(0));

    }
}
