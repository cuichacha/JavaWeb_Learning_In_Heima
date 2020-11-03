package Day02.Code.Proxy.StaticProxy;

public class Test {
    public static void main(String[] args) {
        StudentInterface student = new Student();

        StudentInterface studentProxy = new StudentStaticProxy(student);

        studentProxy.eat("啦啦");

        studentProxy.study();
    }
}
