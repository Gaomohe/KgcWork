import com.pojo.Student;

import static com.util.Vessel.stuInfoSer;

public class Main {
    public static void main(String[] args) {
        for (Student student : stuInfoSer.queryStuId(2)){
            System.out.println(student.getsName());
        }
    }
}