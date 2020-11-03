package Day02.Code.Proxy.StaticProxy;

public class StudentStaticProxy implements StudentInterface{
    private StudentInterface studentInterface;

    public StudentStaticProxy(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    @Override
    public void study() {
        System.out.println("增强");
    }

    @Override
    public void eat(String str) {
        studentInterface.eat(str);
    }
}
