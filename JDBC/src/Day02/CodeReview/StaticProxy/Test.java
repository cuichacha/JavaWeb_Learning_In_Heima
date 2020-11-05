package Day02.CodeReview.StaticProxy;

public class Test {
    public static void main(String[] args) {
        StudentInterface studentInterface1 = new Student();
        studentInterface1.eat("food");
        studentInterface1.study();

        StudentInterface studentInterface2 = new StaticStudent(studentInterface1);
        studentInterface2.eat("food");
        studentInterface2.study();
    }
}
