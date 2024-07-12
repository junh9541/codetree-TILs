import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double avg = 0;
        double[] arr = new double[n];
        double sum = 0;
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextDouble();
            sum+=arr[i];
        }

        System.out.printf("%.1f\n", sum/n);
        // System.out.print();

        if(sum/n>=4){
            System.out.println("Perfect");
        }else if(sum/n>=3){
            System.out.println("Good");
            
        }else{
            System.out.println("Poor");

        }


    }
}