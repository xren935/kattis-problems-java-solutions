import java.io.*; 
import java.util.*;

public class getShorty {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
            int m = sc.nextInt();
			if (n == 0 && m == 0) {
				break;
			}

			ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				graph.add(new ArrayList<Pair>());
			}

			TreeSet<Pair> closest = new TreeSet<>();
			for (int i = 0; i < n; i++) {
				closest.add(new Pair(i, 0.));
			}

			for (int i = 0; i < m; i++) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				double shrinkFactor = sc.nextDouble();
				graph.get(first).add(new Pair(second, shrinkFactor));
				graph.get(second).add(new Pair(first, shrinkFactor));
			}

			double[] height = new double[n];
			boolean[] visited = new boolean[n];

			height[0] = 1;
			closest.remove(new Pair(0, 0));
			closest.add(new Pair(0, 1));

			for (int i = 0; i < n - 1; i++) {
				Pair first = closest.pollFirst();
				if (first == null) {
					break;
				}
				int node = first.endVertex;
				double shrinkFactor = first.shrinkFactor;
				visited[node] = true;

				for (int j = 0; j < graph.get(node).size(); j++) {
					Pair pii = graph.get(node).get(j);
					if (!visited[pii.endVertex]) {
						if (height[pii.endVertex] < shrinkFactor * pii.shrinkFactor) {
							closest.remove(new Pair(pii.endVertex, height[pii.endVertex]));
							height[pii.endVertex] = shrinkFactor * pii.shrinkFactor;
							closest.add(new Pair(pii.endVertex, pii.shrinkFactor * shrinkFactor));
						}
					}
				}

			}
			System.out.println(String.format("%.4f", height[height.length - 1]));
		}
		sc.close();
	}

	static class Pair implements Comparable<Pair> {
		int endVertex;
		double shrinkFactor;
		public Pair(int endVertex, double shrinkFactor) {
			this.endVertex = endVertex;
			this.shrinkFactor = shrinkFactor;
		}

		@Override
		public int compareTo(Pair o) {
			if (o.endVertex == this.endVertex) {
				return 0;
			}
			int compare = Double.compare(o.shrinkFactor, this.shrinkFactor);
			if (compare == 0) {
				return -1;
			}
			return compare;
		}
	}
}