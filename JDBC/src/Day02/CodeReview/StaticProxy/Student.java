package Day02.CodeReview.StaticProxy;

public class Student implements StudentInterface{
    @Override
    public void eat(String str) {
        System.out.println("吃" + str);
    }

    @Override
    public void study() {
        System.out.println("原来");
    }
}
