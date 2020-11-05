package Day02.CodeReview.StaticProxy;

public class StaticStudent implements StudentInterface{
    private StudentInterface studentInterface;

    public StaticStudent(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    @Override
    public void eat(String str) {
        studentInterface.eat(str);
    }

    @Override
    public void study() {
        System.out.println("增强");
    }
}
