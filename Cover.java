/**Important! start and end of a seg. can't take the same value*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cover {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			int[] b = new int[n];

			
			int[][] mat = new int[n][n];
			for (int i = 0; i < n; i++) {
				mat[i][i] = -1;
			}

			
			int maxConsidered = 0;
			int m = n;
			
			for (int i = 0; i < n; i++) {
				String[] s = (br.readLine()).split("\\s+");
				a[i] = Math.min(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				b[i] = Math.max(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				for (int j = 0; j < i; j++) {
					if (a[i] == a[j] && b[i] == b[j] && i != j) {
						a[i] = -99999;
						b[i] = -99999;
						m--;
					}
				}

				if (maxConsidered < b[i])
					maxConsidered = b[i];
			}

			/**
			 * First part Algorithm mat is simetric matrix wrt main diagonal:
			 * property not used here
			 * */
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					if (i != j && a[i] != -99999 && b[i] != -99999) {
						if (a[i] > b[j]) {
							mat[i][j] = 0;
							mat[j][i] = 0;
						} // no overlap
						if (a[i] == b[j]) {
							mat[i][j] = 1;
							mat[j][i] = 1;
						}
						if (a[i] < b[j] && a[i] > a[j] && b[j] <= b[i]) {
							mat[i][j] = Math.abs(b[j] - a[i] + 1);
							mat[j][i] = Math.abs(b[j] - a[i] + 1);
						}
						if (a[i] > a[j] && b[i] < b[j]) {
							mat[i][j] = Math.abs(b[i] - a[i] + 1);
							mat[j][i] = Math.abs(b[i] - a[i] + 1);
						} // all seg 1 is included in 2
						if (a[i] <= a[j] && b[i] >= b[j]) {
							mat[i][j] = Math.abs(b[j] - a[j] + 1);
							mat[j][i] = Math.abs(b[j] - a[j] + 1);
						} // all seg 2 is included in 1
						if (a[i] <= a[j] && b[j] > b[i] && b[i] > a[j]) {
							mat[i][j] = Math.abs(b[i] - a[j] + 1);
							mat[j][i] = Math.abs(b[i] - a[j] + 1);
						}
						if (b[i] == a[j]) {
							mat[i][j] = 1;
							mat[j][i] = 1;
						}
						if (b[i] < a[j]) {
							mat[i][j] = 0;
							mat[j][i] = 0;
						} // no overlap
					}
				}
			}

			if (m > 1) {
				int[] eliminate = new int[n];
				int[] select = new int[n];
				int[] visited = new int[n];

				ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
				int max = 0;

				for (int i = 0; i < n; i++) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					for (int j = 0; j < n; j++) {
						if (mat[i][j] == 1 || mat[i][j] == 0) {
							list.add(j);
						}
					}
					arrList.add(list);
				}

				/** second part algorithm: Greedy idea */
				while (!visitedFunc(visited)) {
					max = -1; // reset max
					int index = -1;
					for (int i = 0; i < n; i++) {
						if (arrList.get(i).size() == 0 && eliminate[i] == 0) {
							eliminate[i] = 1;
							visited[i] = 1;
						}
					}
					for (int i = 0; i < n; i++) {
						if (visited[i] == 0) {
							if (arrList.get(i).size() > max
									&& arrList.get(i).size() > 0
									&& eliminate[i] == 0) {
								max = arrList.get(i).size();
								index = i;
							}
						}
					}
					if (index != -1 && eliminate[index] == 0) {
						select[index] = 1; 											
						visited[index] = 1; 											
						for (int j = 0; j < n; j++) {														
							if (mat[index][j] >= 2) {
								eliminate[j] = 1;
								visited[j] = 1;
							}
						}
					}
					if (visitedFunc(visited)) // exit condition
						break;
				}

				ArrayList<Pair> pl = new ArrayList<Pair>();
				int count = 0;
				for (int i = 0; i < n; i++) {
					if (select[i] == 1) {
						Pair p = new Pair();
						p.a = a[i];
						p.b = b[i];
						pl.add(p);
						count++;
					}
				}

				Collections.sort(pl, new Comparator<Pair>() {
					public int compare(Pair s1, Pair s2) {
						return s1.a - s2.a;
					}
				});

				for (int i = 0; i < pl.size(); i++)
					if (pl.get(i).a == -99999) {
						count--;
					}
				System.out.println(count);
				for (int i = 0; i < pl.size(); i++)
					if (pl.get(i).a != -99999) {
						System.out.println(pl.get(i).a + " " + pl.get(i).b);
					}
			} else {
				int count = 1;
				System.out.println(count);
				for (int i = 0; i < 1; i++)
					System.out.println(a[0] + " " + b[0]);
			}
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

	public static boolean visitedFunc(int[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				return false;
			}
		}
		return true;
	}
}

class Pair {
	int a;
	int b;
}