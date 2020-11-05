package Day01.CodeReview.bean;

import java.util.Date;

public class Student {
    private Integer sid;
    private String name;
    private Integer age;
    private Date insertTime;

    public Student() {
    }

    public Student(Integer sid, String name, Integer age, Date insertTime) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", insertTime=" + insertTime +
                '}';
    }
}
