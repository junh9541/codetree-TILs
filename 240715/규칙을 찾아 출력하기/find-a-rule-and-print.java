import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        String star = "* ";
        String blank = "  ";

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if( i==0 || i==n-1 || j<i || j==n-1)
                System.out.printf(star);
                else
                System.out.printf(blank);
            }
            System.out.println();
        }
    }
}