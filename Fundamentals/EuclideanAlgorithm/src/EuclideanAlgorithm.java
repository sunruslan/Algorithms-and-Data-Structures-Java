import java.util.Scanner;

public class EuclideanAlgorithm {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two number:\n");
        a = scanner.nextInt();  
        b = scanner.nextInt();
        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
    }
}
