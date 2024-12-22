import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sb.nextToken());
        int K = Integer.parseInt(sb.nextToken());

        List<Integer> nums = new ArrayList();

        sb = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            if(sb.nextToken().equals("1")){
                nums.add(i);
            }
        }
        if(nums.size()<K){
            System.out.print(-1);
            return;
        }

        int start = 0;
        int min = Integer.MAX_VALUE;
        for(int i = K-1; i<nums.size(); i++){   
            min = Math.min(min, nums.get(i)-nums.get(start)+1);
            start++;
        }
        System.out.print(min);
    }
}