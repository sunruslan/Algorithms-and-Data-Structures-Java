import java.util.Scanner;

public class EuclideanAlgorithm {

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a, b;
        System.out.println("Enter two number:");
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println("GCD(" + a + ", " + b + ") = " + gcd(a,b));
    }
}
