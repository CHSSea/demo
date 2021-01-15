import java.io.File;
import java.io.RandomAccessFile;

/**
 * 每次读取文件后N行
 */
public class Test19 {

    public static String readLastLinesFor(String osPath , int lines , String charset){
        //通过获取文件偏移量
        RandomAccessFile randomAccessFile = null;
        try{
            StringBuilder sb = new StringBuilder();
            File file = new File(osPath);

            if (!file.exists() || file.isDirectory() || !file.canRead()) {
                return null;
            }

            randomAccessFile = new RandomAccessFile(file, "r");
            //文件总的偏移量
            long len = randomAccessFile.length();
            //如果文件为空
            if(len == 0l){
                return "";
            }else{
                //取其前一位，循环找到200行的具体偏移量
                long pos = len -1;
                while(pos > 0 && lines > 0){
                    pos--;
                    //获取当前pos
                    randomAccessFile.seek(pos);
                    if(randomAccessFile.readByte() == '\n'){
                        lines--;
                    }

                }
                //根据偏移量创建byte数组
                byte[] bytes = new byte[(int) (len - pos)];
                randomAccessFile.read(bytes);
                //编码按照个人需要，源码默认是"GB-2312"
                if(charset == null){
                    return new String(bytes);
                }else{
                    return new String(bytes, charset);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(randomAccessFile != null){
                    randomAccessFile.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  "";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = readLastLinesFor("D:\\1610611752312_55.txt", 10, null);
        long end = System.currentTimeMillis();
        System.out.println(s);
        System.out.println(end-start);
    }
}
