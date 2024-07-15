import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = scanner.nextInt();

        if(b>a && b<c)
        System.out.println(1);
        else
        System.out.println(0);


    }
}