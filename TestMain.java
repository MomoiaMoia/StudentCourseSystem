package StudentCourseSystem;

public class TestMain {
    public static void main(String[] args) {
        // 使用 ArraryList studentList

        // 学生初始化
        Student momoia = new Student("Momoia");
        Student momori = new Student("momori");
        System.out.println(Person.getStudentList());

        // 教师初始化
        Teacher koko = new Teacher();
        System.out.println(Person.getTeacherList());

        // 多态性体现
        System.out.println("多态性体现：/n Momoia 与 Momori账户对比： " + momoia.compareTo(momori));

        // 课程初始化
        Course java = new Course("java");
        Course python = new Course("python");
        Course c = new Course("c++");

        System.out.println(" *　课程初始化");
        Course.initCou(new String[] { "r", "go" });
        Courses.print();
        System.out.println("\n------------");

        // 学生选课测试
        System.out.println("------------为 Momoia 执行选课测试");
        momoia.select();
        System.out.println("------------执行选课结果展示");
        momoia.printSelect();
        System.out.println("------------");

        // 教师修改分数测试
        System.out.println("------------执行分数修改测试");
        koko.grade();
    }
}
