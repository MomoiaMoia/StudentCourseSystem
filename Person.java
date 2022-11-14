package StudentCourseSystem;

import java.util.HashMap;

public abstract class Person implements Compare {

    /**
     * @param id          ID
     * @param name        姓名
     * @param type        TYPE 学生 = "student", 教师 = "teacher"
     * @param teacherList 教师列表 KEY 为 tid，VALUE 为 Teacher 对象
     * @param studentList 学生列表 KEY 为 cid，VALUE 为 Student 对象
     */

    protected int id;
    private String name;
    private String type;
    private static HashMap<Integer, Student> studentList = new HashMap<Integer, Student>();
    private static HashMap<Integer, Teacher> teacherList = new HashMap<Integer, Teacher>();

    public int getId() {
        return id;
    }

    public abstract void setId();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static HashMap<Integer, Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(Integer sid, Student student) {
        studentList.put(sid, student);
    }

    public static HashMap<Integer, Teacher> getTeacherList() {
        return teacherList;
    }

    public static void setTeacherList(Integer tid, Teacher teacher) {
        teacherList.put(tid, teacher);
    }

    @Override
    public int compareTo(Person p) {
        if (this.getId() > p.getId()) {
            return 1;
        } else if (this.getId() < p.getId()) {
            return 0;
        } else {
            return -1;
        }
    }
}
