import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\.");
        String y = sc.next();
        String m = sc.next();
        String d = sc.next();

        System.out.printf("%s-%s-%s", m, d, y );
    }
}