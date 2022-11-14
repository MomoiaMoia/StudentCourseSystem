package StudentCourseSystem;

import java.util.HashMap;

public class Courses {
    /**
     * @param coursesList    课程列表，KEY 为 Integer cid， VALUE 为 Couse 对象。
     */
    private static HashMap<Integer, Course> coursesList = new HashMap<Integer, Course>();

    public static HashMap<Integer, Course> getCourses() {
        return coursesList;
    }

    public static void setCourses(Integer cid, Course course) {
        coursesList.put(cid, course);
    }

    public static void print() {
        for (Course course : coursesList.values()) {
            System.out.println(" - 课程号：" + course.getCid() + "\t" + "课程名："+ course.getCname());
        }
    }
}
