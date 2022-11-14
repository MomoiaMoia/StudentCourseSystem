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

    /** 
     * @see StudentCourseSystem.Compare#compareTo(StudentCourseSystem.Person)
     * @return 对比ID的大小，当大于其对比对象的ID时，返回1，小于返回-1，相等返回0.
     */
    @Override
    public int compareTo(Person p) {
        if (this.getId() > p.getId()) {
            return 1;
        } else if (this.getId() < p.getId()) {
            return -1;
        } else {
            return 0;
        }
    }


    /** 
     * @see StudentCourseSystem.Compare#equals(java.lang.String)
     * @return 对比用户类型是否相同，相同返回 true，不同返回false
     */
    @Override
    public boolean equals(String type) {
        if (this.type == type) {
            return true;
        } else {
            return false;
        }
    }
}
