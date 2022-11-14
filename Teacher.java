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
    public void grade() throws OutofCourseBoundException{
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println(" * 当前学生列表：");
            for (Map.Entry<Integer, Student> entry : Person.getStudentList().entrySet()) {
                System.out.println(" -- " + entry.getKey() + "\t" + entry.getValue());
            }

            // 检查学生是否存在
            System.out.print(" -- 请键入学生学号以查看其选课信息: ");
            Student student = Person.getStudentList().get(sc.nextInt());
            if (student == null){
                System.out.println(" -- 该学生不存在。");
                continue;
            }

            // 检查学生是否有选课信息
            if (student.getCoursesSelected().size() == 0) {
                System.out.println(" -- 该学生无选课信息。");
                continue;
            } else {
                student.printSelect();
            }

            // 进行课程评分
            System.out.print(" -- 请键入需要修改分数的课程号： ");
            Course course = Courses.getCourses().get(sc.nextInt());
            // 判定课程是否存在
            if (student.getCoursesSelected().contains(course)) {
                System.out.print(" -- 请键入需要修改的分数（0-4.0）： ");
                double credit = sc.nextDouble();
                // 输入是否正确
                while (!(credit <= 4.0 & credit >= 0)){
                    System.out.print(" -- 输入不正确，请重新输入： ");
                    credit = sc.nextDouble();
                }
                // 实施修改
                student.setCoursesCredit(course, credit);
                System.out.println(" -- 修改成功！");
            // 课程不存在
            } else {
                throw new OutofCourseBoundException();
            }
 
            System.out.println(" -- 该学生当前信息：");
            student.printSelect();

            System.out.print(" * 输入 1 继续，输入 0 退出：");
            if (sc.nextInt() == 0) {
                flag = false;
            }
        }

    }
}
