package Code.Search.bean;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer searchCount;

    public User() {
    }

    public User(Integer id, String name, Integer age, Integer searchCount) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.searchCount = searchCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", searchCount=" + searchCount +
                '}';
    }
}
