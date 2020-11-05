package Day02.CodeReview.DynamicProxy2;

public class Student implements StudentInterface{
    @Override
    public void eat() {
        System.out.println("吃");
    }

    @Override
    public void study() {
        System.out.println("原来");
    }
}
