public class Test01 {
    public static void main(String[] args) {

        String columnName = "name";
        String regular = "^[0-9]*$";
        String str = " " + columnName + " REGEXP " + "'" + regular + "'" + " and ";

        System.out.println(str);
        String tmp = str.substring(0, str.length() - 4);
        System.out.println(tmp);
    }
}
