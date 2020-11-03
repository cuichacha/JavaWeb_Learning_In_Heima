package Day02.Code.Proxy.StaticProxy;

public class Student implements StudentInterface {
    @Override
    public void study() {
        System.out.println("原来");
    }

    @Override
    public void eat(String str) {
        System.out.println("吃" + str);
    }
}
