

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test12 {
    public static final String TAG = Test12.class.getSimpleName();

    public static void main(String[] args) {
        String urlString = "https://temp-852.ai.intsig.net/icr/recognize_id_card";
        File file = new File("C:\\Users\\admin\\Desktop\\dasfdsa_x.jpg");
        String resultString = DocumentOCR(file, urlString);
        System.out.println(resultString);
    }

    public static String DocumentOCR(File file, String urlstr) {
        OutputStream out = null;
        FileInputStream inputStream = null;
        String retString = null;

        try {
            URL url = new URL(urlstr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setConnectTimeout(1500000);
            con.setReadTimeout(1500000);
            con.setRequestProperty("Content-type", "application/json");
            con.setRequestMethod("POST");
            out = con.getOutputStream();
            inputStream = new FileInputStream(file);
            byte[] data = new byte[2048];
            //int len = false;

            int sum;
            int len;
            for (sum = 0; (len = inputStream.read(data)) != -1; sum += len) {
                out.write(data, 0, len);
            }

            System.out.println("upload size=" + sum);
            System.out.println("url =" + url);
            out.flush();
            int code = con.getResponseCode();
            System.out.println("code=" + code);
            if (code != 200) {
                retString = code + "服务器http返回错误";
            } else {
                InputStream inputStream2 = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                while ((len = inputStream2.read(data)) != -1) {
                    bos.write(data, 0, len);
                }

                retString = bos.toString();
                inputStream2.close();
                bos.close();
            }

            con.disconnect();
        } catch (MalformedURLException var28) {
            var28.printStackTrace();
        } catch (IOException var29) {
            var29.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException var27) {
                var27.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException var26) {
                var26.printStackTrace();
            }

        }

        return retString;
    }

    public static String TableOCRHttps(File file, String urlstr, String appkey, String appsecret) {
        String retString = null;
        OutputStream out = null;
        FileInputStream inputStream = null;

        try {
            URL url = new URL(urlstr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setConnectTimeout(1500000);
            con.setReadTimeout(1500000);
            con.setRequestProperty("Content-type", "application/json");
            con.setRequestProperty("app-key", appkey);
            con.setRequestProperty("app-secret", appsecret);
            con.setRequestMethod("POST");
            out = con.getOutputStream();
            inputStream = new FileInputStream(file);
            byte[] data = new byte[2048];
            //int len = false;

            int len;
            int sum;
            for (sum = 0; (len = inputStream.read(data)) != -1; sum += len) {
                out.write(data, 0, len);
            }

            System.out.println("upload size=" + sum);
            System.out.println("url =" + url);
            out.flush();
            inputStream.close();
            out.close();
            int code = con.getResponseCode();
            System.out.println("code=" + code);
            if (code != 200) {
                retString = code + "服务器http返回错误";
            } else {
                InputStream inputStream2 = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                while ((len = inputStream2.read(data)) != -1) {
                    bos.write(data, 0, len);
                }

                retString = bos.toString();
                inputStream2.close();
                bos.close();
            }

            con.disconnect();
        } catch (MalformedURLException var30) {
            var30.printStackTrace();
        } catch (IOException var31) {
            var31.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException var29) {
                var29.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException var28) {
                var28.printStackTrace();
            }

        }

        return retString;
    }
}
