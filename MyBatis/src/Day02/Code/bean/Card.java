package Day02.Code.bean;

public class Card {
    private Integer id;
    private Integer number;
    private Person person;

    public Card() {
    }

    public Card(Integer id, Integer number, Person person) {
        this.id = id;
        this.number = number;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number=" + number +
                ", person=" + person +
                '}';
    }
}
