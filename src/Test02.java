public class Test02 {
    public static void main(String[] args) {
        String str = "2020-09-01/idcard/aaa.jpg";
        System.out.println(str.substring(0, str.lastIndexOf("/") + 1));
    }
}
