package Day03.Code.bean;

import java.util.Date;
import java.util.List;

public class Student {
    private Integer sid;
    private String name;
    private Integer age;
    private Date insertTime;
    private List<Course> courses;

    public Student() {
    }

    public Student(Integer sid, String name, Integer age, Date insertTime, List<Course> courses) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.insertTime = insertTime;
        this.courses = courses;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", insertTime=" + insertTime +
                ", courses=" + courses +
                '}';
    }
}
