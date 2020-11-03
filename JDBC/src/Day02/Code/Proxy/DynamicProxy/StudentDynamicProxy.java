package Day02.Code.Proxy.DynamicProxy;

public class StudentDynamicProxy implements StudentInterface{
    @Override
    public void eat(String name) {
        System.out.println("学生吃" + name);
    }

    @Override
    public void study() {

    }
}
