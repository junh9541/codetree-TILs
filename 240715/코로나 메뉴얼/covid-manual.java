import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int cnt = 0;

        for(int i=0; i<3; i++){
            String[] p =sc.nextLine().split(" ");
            if(p[0].equals("Y") && Integer.parseInt(p[1])>=37)
            cnt+=1;
        } 

        if (cnt>=2)
        System.out.print("E");
        else
        System.out.print("N");


    

    }
}