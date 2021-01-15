import java.util.ArrayList;
import java.util.List;

public class Test03 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("select ");
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("age");
        list.add("sex");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + ",");
            if (i == list.size() - 1) {
                sb.deleteCharAt(list.size());
            }
        }

        System.out.println(sb);
    }
}
