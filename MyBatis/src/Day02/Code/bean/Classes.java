package Day02.Code.bean;

import java.util.List;

public class Classes {
    private Integer id;
    private String name;
    private List<Learner> learners;

    public Classes() {
    }

    public Classes(Integer id, String name, List<Learner> learners) {
        this.id = id;
        this.name = name;
        this.learners = learners;
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

    public List<Learner> getLearners() {
        return learners;
    }

    public void setLearners(List<Learner> learners) {
        this.learners = learners;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", learners=" + learners +
                '}';
    }
}
