import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<Student1> students = new ArrayList<Student1>() {
            {
                add(new Student1(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student1(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student1(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student1(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student1(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student1(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student1(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student1(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student1(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student1(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }

        };

        List<Student1> s = students.stream().filter(student1 -> "武汉大学".equalsIgnoreCase(student1.getSchool())).collect(Collectors.toList());

        List<Student1> s1 = students.stream().filter(student1 -> student1.getAge() % 2 == 0).distinct().collect(Collectors.toList());
    }
}
