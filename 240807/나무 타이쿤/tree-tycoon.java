import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 영양제 이동시킨다. (이동할 영양제: 1)
 * 영양제 준다 (사용한 영양제: 2)
 * 추가 성장 
 * 영양제 준 나무 제외 -2, 영양제 주기 (새로운 영양제: 1)
 * 기존 영양제 제거(2 제거)
 * 
 * 문제: 복붙, 수정할 떄 x y 좌표 수정 안해서 에러
 * 
 * 수정 이전: 영양제 좌표를 2차원 배열에 넣어서 순회하면서 찾음.
 * 엄청 비효율적이었잖아!
 */
public class Main {
	static int[] dx = {0, 1, 1, 0, -1, -1, -1, 0, 1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1}; 
	static Queue<Integer> toMove = new LinkedList<>();
	static int N;
	static boolean[][] moved;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		int T = Integer.parseInt(tk.nextToken());
		
		board = new int[N][N];
		moved = new boolean[N][N];
		
		toMove.add(N-1);
		toMove.add(0);
		toMove.add(N-2);
		toMove.add(0);
		toMove.add(N-1);
		toMove.add(1);
		toMove.add(N-2);
		toMove.add(1);
		
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
			
			moveDrug(d, n);
			growTree();
			makeDrug();
		}		
		int sum = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sum+=board[i][j];
			}
		}
		System.out.print(sum);
	}

	private static void moveDrug(int d, int n) {
		while(!(toMove.isEmpty())){
				int y = toMove.poll();
				int x = toMove.poll();
				int newY = (y+dy[d]*n)%N>=0? (y+dy[d]*n)%N: ((y+dy[d]*n)%N)+N;
				int newX = (x+dx[d]*n)%N>=0? (x+dx[d]*n)%N: ((x+dx[d]*n)%N)+N;
				moved[newY][newX]=true;
				board[newY][newX]++;			
		}		
	}


	private static void growTree() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(moved[i][j]==true) {
					for(int k = 2; k<=8; k+=2) {
						if(i+dy[k]>=0 && i+dy[k]<N && j+dx[k]>=0 && j+dx[k]<N) {
							if(board[i+dy[k]][j+dx[k]]>0) {
								board[i][j]++;
							}
						}
					}
				}
			}
		}
	}
	
	private static void makeDrug() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(moved[i][j]==false&&board[i][j]>=2) {
					board[i][j]-=2;
					toMove.add(i);
					toMove.add(j);
				}
				else if(moved[i][j]==true) {
					moved[i][j]=false;
				}
			}
		}
	}
}