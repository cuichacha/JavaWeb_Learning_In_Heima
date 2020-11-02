package Day01.Code.Domain;

import java.sql.Date;

public class Student {
    private Integer sid;
    private String name;
    private Integer age;
    private Date date;

    public Student() {
    }

    public Student(Integer sid, String name, Integer age, Date date) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
