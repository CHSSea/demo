import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test16 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?:^|\\s)'([^']*?)'(?:$|\\s)",Pattern.MULTILINE);
        String temp = "column regexp '( )' and column not regexp '[a-zA-Z]' or column regexp '[a-z]'";
        String columnName = "password";
        List<String> list1 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String[] ands = temp.split("and");
        for (String or : ands){
            String[] ors = or.split("or");
            for (String str : ors){
                list1.add(str);
            }
        }

        for (String str : list1){
            //1.拿到正则表达式的
            String regexp = str.substring(str.indexOf("'")+1,str.lastIndexOf("'"));
            //2.判断是否包含not
            if(str.contains("not") || str.contains("NOT")){
                list.add(" and NOT REGEXP_LIKE("+"\"" + columnName + "\""+","+"'"+regexp + "')");
            }else {
                list.add(" and REGEXP_LIKE("+"\"" + columnName + "\""+","+"'"+regexp + "')");
            }
        }
        /*String temp = regexp.replaceAll("column","username");
        System.out.println(temp);
        Matcher matcher = pattern.matcher(temp);
        *//*if(matcher.find()){
            System.out.println(matcher.group());
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }*//*

        while (matcher.find()){
            System.out.println(matcher.group());
        }*/
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append(str);
        }
        System.out.println(stringBuffer);
    }
}
