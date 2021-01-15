import java.nio.ByteBuffer;

public class Test04 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        int i = buffer.get(5 - 1) & 0xff;
        System.out.println(i);
    }
}