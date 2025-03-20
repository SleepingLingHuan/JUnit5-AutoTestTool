package JUnit5;
public class Calculator {
    public static int add(int a, int b) {return a + b + b;}//刻意编写错误的类内方法用于测试
    public static int sub(int a, int b) {return a - b;}
    public static int mul(int a, int b) {return a * b;}
    public static int div(int a, int b) {return a / b;}
}
