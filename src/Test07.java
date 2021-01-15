import java.text.SimpleDateFormat;
import java.util.Date;

public class Test07 {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
