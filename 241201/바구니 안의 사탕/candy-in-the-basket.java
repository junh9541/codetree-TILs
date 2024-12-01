import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] baskets =new int[N][2];
        
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	int loc = Integer.parseInt(st.nextToken());
        	baskets[i]=new int[] {loc, num};
        }
        
        Arrays.sort(baskets, (int[] li1, int[] li2)->{
        	return li1[0]-li2[0];        
        	});
        
        int start = baskets[0][0];
        int maxCandy=0;
        int candySum = 0;
        
        for(int i = 0; i<N; i++) {
        	if(baskets[i][0]>start+K*2) {
        		if(maxCandy<candySum) {
        			maxCandy=candySum;
        		}
        		start = baskets[i][0];
        		candySum = 0;
        	}
    		candySum+=baskets[i][1];
		}
        if(maxCandy<candySum) {
			maxCandy=candySum;
		}
        
        System.out.println(maxCandy);
        
        
    }
}