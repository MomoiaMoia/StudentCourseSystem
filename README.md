# Version

v0.1     [11/2/2022]     实验1-2
v0.2     [11/14/2022]    实验3-5


# Update
## v0.2

var: `courseList`       移动到  `Courses`   类
var: `teacherList`      移动到  `Person`    类
var: `studentList`      移动到  `Person`    类
var: `tid`, `sid`       转为    `Person`.`id`
var: `sname`, `tname`   转为    `Person`.`name`
var: `type`             增加
部分方法逻辑更改。


# Info

file: `Compare`     type: `interface`                       定义了compareTo方法。
file: `Course`      type: `class`                           课程对象
file: `Courses`     type: `class`                           课程列表对象
file: `Person`      type: `class`   implement: `Compare`    人物对象
file: `Student`     type: `class`   extend: `Person`        学生对象
file: `Teacher`     type: `class`   extend: `Person`        教师对象
file: `TestMain`    type: `class`                           主类

# StudentCourseSystem
