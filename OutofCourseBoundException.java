package StudentCourseSystem;
public class OutofCourseBoundException extends Exception{
    public OutofCourseBoundException() {
        super(" -- 该学生未选择该门课程。");
    }
}
