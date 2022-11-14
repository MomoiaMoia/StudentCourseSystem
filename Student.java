package StudentCourseSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Student extends Person {
    /**
     * @param type            角色类型
     * @param coursesSelected 已选课程
     * @param courseCredit    课程分数，KEY 为 Course 对象， VALUE 为 double
     */
    private ArrayList<Course> coursesSelected = new ArrayList<Course>();

    // 在下一次需要进行修改
    private HashMap<Course, Double> coursesCredit = new HashMap<Course, Double>();

    // 构造方法
    public Student() {
        this.setId();
        super.setType("student");
        Person.setStudentList(this.getSid(), this);
    }

    public Student(String name) {
        this();
        super.setName(name);
    }

    // Getter and Setter
    public int getSid() {
        return super.getId();
    }

    public String getSname() {
        return super.getName();
    }

    public void setSname(String sname) {
        super.setName(sname);
    }

    public ArrayList<Course> getCoursesSelected() {
        return coursesSelected;
    }

    public void setCoursesSelected(ArrayList<Course> coursesSelected) {
        this.coursesSelected = coursesSelected;
    }

    public HashMap<Course, Double> getCoursesCredit() {
        return coursesCredit;
    }

    public void setCoursesCredit(Course course, double credit) {
        this.coursesCredit.replace(course, credit);
    }

    // 覆写方法
    @Override
    public void setId() {
        Random r = new Random();
        super.id = r.nextInt(10000) - 1;
    }

    @Override
    public String toString() {
        return super.getName();
    }

    /*
     * 选课方法
     * Course.getCourses() 将返回哈希图类型的已存储课程。
     * 其中 KEY 为课程号，VALUE 为 Course 类型的课程对象。
     */
    public void select() {
        Courses.print();
        Scanner sc = new Scanner(System.in);

        System.out.println("------------");
        boolean flag = true;

        while (flag) {
            System.out.print(" * 请键入一个数字来选择相应课程(键入 0 退出)：");
            int cid = sc.nextInt();
            if (cid == 0) {
                flag = false;

            } else if (coursesSelected.contains(Courses.getCourses().get(cid))) {
                System.out.println(" - 课程已选择！");

            } else if (Courses.getCourses().containsKey(cid)) {
                coursesSelected.add(Courses.getCourses().get(cid));
                coursesCredit.put(Courses.getCourses().get(cid), 0.0);
                System.out.println(" - 选课成功。");

            } else {
                System.out.println(" - 课程不存在。");
            }
        }
    }

    public void printSelect() {
        System.out.println(" * 学生：" + super.getName());
        System.out.println(" - 已选课程：" + coursesSelected);
        for (Map.Entry<Course, Double> entry : coursesCredit.entrySet()) {
            System.out.println(" - 课程号：" + entry.getKey().getCid() + "\t 课程名：" + entry.getKey().getCname() + "\t分数："
                    + entry.getValue());
        }
    }
}
