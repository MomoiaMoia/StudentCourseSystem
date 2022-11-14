package StudentCourseSystem;

import java.util.Map;
import java.util.Scanner;

public class Teacher extends Person {

    public Teacher() {
        this.setId();
        super.setType("teacher");
        Person.setTeacherList(this.getId(), this);
    }

    public Teacher(String name) {
        this();
        super.setName(name);
    }

    @Override
    public void setId() {
        super.id = Person.getTeacherList().size() + 1;
    }

    // 分数修改方法
    // 在下一次需要进行判断的增补
    public void grade() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println(" * 当前学生列表：");
            for (Map.Entry<Integer, Student> entry : Person.getStudentList().entrySet()) {
                System.out.println(" - " + entry.getKey() + "\t" + entry.getValue());
            }

            System.out.print(" - 请键入学生学号以查看其选课信息: ");
            Student student = Person.getStudentList().get(sc.nextInt());
            student.printSelect();

            System.out.print(" - 请键入需要修改分数的课程号： ");
            Course course = Courses.getCourses().get(sc.nextInt());

            System.out.print(" - 请键入需要修改的分数： ");
            double credit = sc.nextDouble();
            student.setCoursesCredit(course, credit);
            System.out.println(" - 修改成功！");

            System.out.println(" - 该学生当前信息：");
            student.printSelect();

            System.out.print(" * 输入 1 继续，输入 0 退出：");
            if (sc.nextInt() == 0) {
                flag = false;
            }
        }

    }
}
