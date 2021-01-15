import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test06 {
    public static void main(String[] args) {
        String temp = "username < NOW()";
        String str = temp.replace("NOW()", "to_date()");
        System.out.println(str);


    }
}
