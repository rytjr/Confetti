package Confetti;

import java.util.Scanner;


public class Confetti {
	
	public static int white = 0;
	public static int blue = 0;
	public static int[][] board;
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = in.nextInt();
			}
		}
		
		Praction(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	public static void Praction(int left, int right, int N) {
		
		if(ColorCheck(left, right, N)) {
			if(board[left][right] == 0) {
				white++;
			}
			else blue++;
			return;
		}
		
		int size = N / 2;
		Praction(left, right, size);
		Praction(left + size, right, size);
		Praction(left, right + size, size);
		Praction(left + size, right + size, size);
	}
	
	public static boolean ColorCheck(int left, int right, int N) {
		
		int srart = board[left][right];
		
		for(int i = left; i < left + N; i++) {
			for(int j = right; j < right + N; j++) {
				if(srart != board[i][j]) return false;
			}
		}
		return true;
	}
}