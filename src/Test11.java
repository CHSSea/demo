

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Test11 {
    public static void main(String[] args) throws Exception {
        String url = "https://ocr-api-sandbox.ccint.com/ocr_service?app_key=ai_demo_bills_crop";
        String appKey = "ai_demo_bills_crop";
        String appSecret = "ai_demo_bills_crop";
        url = String.format(url, appKey);
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";

        try {
            String imgData = imageToBase64("C:\\Users\\admin\\Desktop\\dasfdsa_x.jpg");
            String param = "{\"app_secret\":\"%s\",\"image_data\":\"%s\"}";
            param = String.format(param, appSecret, imgData);
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.append(param);
            out.flush();
            out.close();

            String line;
            for (in = new BufferedReader(new InputStreamReader(conn.getInputStream())); (line = in.readLine()) != null; result = result + line) {
            }
        } catch (Exception var20) {
            System.out.println("发送 POST 请求出现异常！" + var20);
            var20.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }

                if (in != null) {
                    in.close();
                }
            } catch (IOException var19) {
                var19.printStackTrace();
            }

        }

        System.out.println(result);
    }

    public static String imageToBase64(String path) {
        String imgFile = path;
        InputStream in = null;
        byte[] data = null;

        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(data);
    }
}
