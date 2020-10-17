import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double x = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        double x2 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        System.out.println(x < x2 ? x + " " + x2 : x2 + " " + x);
    }
}