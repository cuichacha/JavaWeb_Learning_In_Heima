package Day02.CodeReview.DynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        StudentInterface studentInterface = new Student();

        StudentInterface proxyInstance = (StudentInterface) Proxy.newProxyInstance(studentInterface.getClass().getClassLoader(), new Class[]{StudentInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("study")) {
                    System.out.println("啦啦啦");
                    return null;
                }
                return method.invoke(studentInterface, args);
            }
        });

        proxyInstance.eat();
        proxyInstance.study();
    }
}
