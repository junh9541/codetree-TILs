import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int age1 = sc.nextInt();
        char gen1 = sc.next().charAt(0);

        int age2 = sc.nextInt();
        char gen2 = sc.next().charAt(0);

        System.out.print(gen1=='M');


        if((age1>19 && gen1=='M') ||(age2>19 && gen2=='M')){
            System.out.print(1);     
        }
        else
        System.out.print(0);
    }
}