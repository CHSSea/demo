import java.io.*;
import java.util.Date;

public class Test13 {
    public static void main(String[] args) {
        print("D:\\123.txt", "1111");
        print("D:\\123.txt", "2222");
    }

    public static boolean print(String filePath, String code) {
        try {
            File tofile = new File(filePath);
            FileWriter fw = new FileWriter(tofile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(code);
            pw.close();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
