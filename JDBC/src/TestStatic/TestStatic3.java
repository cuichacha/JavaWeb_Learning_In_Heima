package TestStatic;

public class TestStatic3 {

    static {
        a = 10;
    }

    static int a = 5;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
