import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        double h = sc.nextInt();
        double w = sc.nextInt();

        double bmi = w/((h/100)*(h/100));

        System.out.printf("%d\n", (int)bmi/1);
        if((int)bmi/1>=25)
        System.out.print("Obesity");
    }
}