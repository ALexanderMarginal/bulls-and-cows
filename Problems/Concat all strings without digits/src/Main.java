import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word :
                strings) {
            int l = word.length();
            for (int i = 0; i < l; i++) {
                char ch = word.charAt(i);
                if (!Character.isDigit(ch)) {
                    stringBuilder.append(Character.valueOf(ch));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}