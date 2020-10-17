import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        String query = url.split("\\?")[1];
        String[] params = query.split("&");
        String pass = "";
        for (String p: params) {
            String[] pair = p.split("=");
            String key = pair[0];
            String value = pair.length == 2 ? pair[1] : "not found";
            if ("pass".equals(key) && !"not found".equals(value)) {
                pass = value;
            }
            System.out.printf("%s : %s\n", key, value);
        }
        if (!"".equals(pass)) {
            System.out.println("password : " + pass);
        }
    }
}