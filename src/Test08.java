import java.util.ArrayList;
import java.util.List;

public class Test08 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s = new Student();
        s.setId(1);
        s.setAge(12);
        s.setName("aa");
        Student s1 = new Student();
        s1.setId(2);
        s1.setAge(13);
        s1.setName("aa");
        Student s2 = new Student();
        s2.setId(3);
        s2.setAge(14);
        s2.setName("aa");
        Student s3 = new Student();
        s3.setId(4);
        s3.setAge(15);
        s3.setName("aa");
        Student s4 = new Student();
        s4.setId(5);
        s4.setAge(16);
        s4.setName("aa");

        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        System.out.println(list.stream().anyMatch(a -> a.getAge().equals(17)));
    }
}
