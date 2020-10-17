import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String number = getNumber();
        int sumLeft = 0;
        int sumRight = 0;
        int l = number.length();
        for (int i = 0; i < l; i++) {
            char ch = number.charAt(i);
            if (i < 3) {
                sumLeft += Character.getNumericValue(ch);
            } else {
                sumRight += Character.getNumericValue(ch);
            }
        }
        System.out.println(sumLeft == sumRight ? "Lucky" : "Regular");
    }

    private static String getNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}