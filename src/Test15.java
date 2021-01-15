import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Test15 {
    public static void main(String[] args) throws Exception {
        String respXML = null;
        URL url = new URL("http://106.15.251.138:4869/upload");
        URLConnection connection = url.openConnection();
        connection.setReadTimeout(5000);
        connection.setConnectTimeout(5000);
        HttpURLConnection uc = (HttpURLConnection) connection;

        uc.setRequestMethod("POST");
        uc.setRequestProperty("Connection", "Keep-Alive");
        uc.setRequestProperty("Cache-Control", "no-cache");
        uc.setRequestProperty("Content-Type", "jpg");
        uc.setRequestProperty("COOKIE", "william");
        uc.setDoOutput(true);
        uc.setDoInput(true);

        uc.connect();

        OutputStream om = uc.getOutputStream();
        FileInputStream in = new FileInputStream("C:\\Users\\admin\\Desktop\\dsafefe_y.jpg");
        byte[] buf = new byte[1024];
        while (true) {
            int len = in.read(buf);
            if (len <= 0)
                break;
            om.write(buf, 0, len);
        }

        InputStreamReader im = new InputStreamReader(uc.getInputStream(),
                "UTF-8");
        char[] bb = new char[1024];
        while (true) {
            int length = im.read(bb);
            if (length == -1)
                break;
            char[] bc = new char[length];
            for (int i = 0; i < length; i++)
                bc[i] = bb[i];
            respXML += new String(bc);
        }

        System.out.println(respXML);
        im.close();
        uc.disconnect();

    }
}
