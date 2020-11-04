package Day02.Code.Proxy.DynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        StudentInterface student = new Student();

        StudentInterface studentProxy = (StudentInterface) Proxy.newProxyInstance
                (student.getClass().getClassLoader(),
                        new Class[]{StudentInterface.class}, new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                if (method.getName().equals("study")) {
                                    System.out.println("增强");
                                    return null;
                                }
                                return method.invoke(student, args);
                            }
                        });

        studentProxy.study();
    }


}
