public class Test09 {
    public static void main(String[] args) {

        String path = "/root/ocr/image/2020-06-21";
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        System.out.println(path);
    }
}
