package Datastructure;

import java.util.Arrays;

import java.util.Scanner;

public class CoinChangeProblem {

	static long getWays(long n, long[] c) {

		int k = c.length;

		Arrays.sort(c);

		long[][] T = new long[(k + 1)][(int) (n + 1)];
		for (int i = 1; i < k + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (j == 0) {
					T[i][j] = 1;
				} else {
					if (c[i - 1] > j) {
						T[i][j] = T[i - 1][j];
					} else {
						T[i][j] = T[i][j - (int) c[i - 1]] + T[i - 1][j];
					}
				}
			}
		}
		return T[k][(int) (n)];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long[] c = new long[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextLong();
		}

		// Print the number of ways of making change for 'n'

		// units using coins having the values given by 'c'

		long ways = getWays(n, c);
		System.out.println(ways);
		in.close();
	}
}
