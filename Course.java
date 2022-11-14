package StudentCourseSystem;

public class Course {
    /**
     * @param cid     课程号 由 HashMap 的 Size 确定
     * @param cname   课程名 toString 返回该值
     */
    private int cid;
    private String cname;
    

    public Course(String cname) {
        this.cid = Courses.getCourses().size() + 1;
        this.cname = cname;
        Courses.setCourses(this.cid, this);
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    @Override
    public String toString() {
        return this.cname;
    }

    public static void initCou(String[] coursesNames) {
        for (String course : coursesNames) {
            Course _temp = new Course(course);
        }
    }

}
