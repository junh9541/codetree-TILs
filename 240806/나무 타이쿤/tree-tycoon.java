import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 영양제 이동시킨다. (이동할 영양제: 1)
 * 영양제 준다 (사용한 영양제: 2)
 * 추가 성장 
 * 영양제 준 나무 제외 -2, 영양제 주기 (새로운 영양제: 1)
 * 기존 영양제 제거(2 제거)
 * 
 * 문제: 복붙, 수정할 떄 x y 좌표 수정 안해서 에러
 */
public class Main {
	static int[] dx = {0, 1, 1, 0, -1, -1, -1, 0, 1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int T = Integer.parseInt(tk.nextToken());
		
		int[][] board = new int[N][N];
		int[][] drug = new int[N][N]; 
		
		drug[N-1][0]=1;
		drug[N-1][1]=1;
		drug[N-2][0]=1;
		drug[N-2][1]=1;
		
		for(int i = 0; i<N; i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j]=Integer.parseInt(tk.nextToken());
			}
		}
		for(int i = 0; i<T; i++) {
			tk = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(tk.nextToken());
			int n = Integer.parseInt(tk.nextToken());
			moveDrug(d, n, drug, board);
			// for(int j = 0; j<N; j++) {
			// 	for(int k = 0; k<N; k++) {
			// 		System.out.print(board[j][k]);
			// 	}
			// 	System.out.println();
			// }
			// System.out.println();
			// for(int j = 0; j<N; j++) {
			// 	for(int k = 0; k<N; k++) {
			// 		System.out.print(drug[j][k]);
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("------------");
			// System.out.println(i+"!!!!!!");
		}
		// System.out.println("?????");
		
		int sum = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sum+=board[i][j];
			}
		}
		System.out.print(sum);
	}

	private static void moveDrug(int d, int n, int[][] drug, int[][] board) {
		int l = drug.length;
		for(int i = 0; i<l; i++) {
			for(int j = 0; j<l; j++) {
				if(drug[i][j]==1){
					drug[i][j]--;
					// System.out.println("방향, 거리 "+d + " "+n);
					// System.out.println("예전 y x "+i+" "+j);
					// System.out.println();
					// System.out.println("이동한 y x "+ (i+dy[d]*n) +" "+(j+(dx[d]*n)));
					int newY = (i+dy[d]*n)%l>=0? (i+dy[d]*n)%l: ((i+dy[d]*n)%l)+l;
					int newX = (j+dx[d]*n)%l>=0? (j+dx[d]*n)%l: ((j+dx[d]*n)%l)+l;
					// System.out.println("새로운 y x "+newY +" "+newX);
					drug[newY][newX]=2;
					growTree(newY, newX, drug, board);
				}
			}
		}
		giveNewDrug(drug, board);
		
	}

	private static void giveNewDrug(int[][] drug, int[][] board) {
		int l = drug.length;
		for(int i = 0; i<l; i++) {
			for(int j = 0; j<l; j++) {
				if(drug[i][j]==2) {
					drug[i][j]=0;
				}
				else if(board[i][j]>=2) {
					board[i][j]-=2;
					drug[i][j]=1;
				}
			}
		}
		
	}

	private static void growTree(int y, int x, int[][] drug, int[][] board) {
		board[y][x]++;
		for(int i = 2; i<=8; i+=2) {
			if(y+dy[i]>=0 && y+dy[i]<drug.length && x+dx[i]>=0 && x+dx[i]<drug.length) {
				if(drug[y+dy[i]][x+dx[i]]==2) {
					board[y][x]++;
				}
				else if(board[y+dy[i]][x+dx[i]]>0) {
					board[y][x]++;
				}
			}
		}
		
	}
}