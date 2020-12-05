import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Point;

// Had to use awt.Point in the code how to make the comparisions happen for the a class
// that you defined.

class Node {
	double x;
	double y;

	public Node(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(x : " + this.x + " y :" + this.y + ")";
	}

	public boolean equals(Node other) {
		if (other == null) return false;
		if (this.x  == other.x && this.y == other.y) return true;

		return false;
	}
}

class Solution {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		double t = in.nextInt();

		while (t > 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			int d = in.nextInt();

			Map<Point, Boolean> visited = new HashMap<>();
			boolean isSolvable = false;
			List<Point> path = new ArrayList<>();

			Queue<Point> queue = new LinkedList<>();

			queue.add(new Point(0,0));

			while (!queue.isEmpty()) {
				Point state = queue.remove();

				if (visited.containsKey(state)) continue;

				if (state.x > m || state.y > n ||
					state.x < 0 || state.y < 0
				) {
					continue;
				}

				path.add(state);
				visited.put(state, true);

				if (state.x == d || state.y == d) {
					isSolvable = true;
					if (state.x == d) {
						if (state.y != 0) path.add(new Point(d, 0));
					} else {
						if (state.x != 0) path.add(new Point(0, d));
					}

					break;
				}

				// Filling one Jug1 or filling jug 2
				queue.add(new Point(state.x, n));
				queue.add(new Point(m, state.y));

				for (int i=0 ; i <= Math.max(m,n) ; i++) {
					// pouring amount from jug1 to jug 2.
					int temp1 = state.x - i;
					int temp2 = state.y + i;

					if (temp2 == n || (temp2 >= 0) ) queue.add(new Point(temp1, temp2));

					temp1 = state.x + i;
					temp2 = state.y - i;
					
					if (temp1 == m || (temp2 >= 0)) queue.add(new Point(temp1, temp2));
				}

				queue.add(new Point(state.x, 0));
				queue.add(new Point(0, state.y));
			}

			if (!isSolvable) {
				System.out.println(-1);
			} else {
				System.out.println(path);
				System.out.println(path.size());
			}
			t--;
		}
	}
}