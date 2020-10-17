import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().toLowerCase().split("");
        int l = str.length;
        int count = 0;
        for (String s : str) {
            if ("c".equals(s) || "g".equals(s)) {
                count++;
            }
        }
        System.out.println((double) count / l * 100);
    }
}