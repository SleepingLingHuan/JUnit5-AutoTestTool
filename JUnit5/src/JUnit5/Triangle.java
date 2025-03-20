package JUnit5;
public class Triangle {
    public static int getType(int a, int b,int c) {
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) return 3;//等边三角形
            else if (a != b && b != c && a != c) return 1;//普通三角形
            else return 2;//等腰三角形
        }
        else return 0;//非三角形
    }
    public static double getArea(int a, int b, int c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}