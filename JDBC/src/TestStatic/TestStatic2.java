package TestStatic;

public class TestStatic2 {
    private static int a = 5;

    static {
        a = 10;
    }

    public static void main(String[] args) {
        System.out.println(a);
    }
}
