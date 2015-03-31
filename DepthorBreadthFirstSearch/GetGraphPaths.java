package DepthorBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphNode{
	int val;
	ArrayList<GraphNode> nexts;
	
}

public class GetGraphPaths {
	int getGraphPaths(GraphNode A, GraphNode B, int n){
		Queue<GraphNode> curLevl = new LinkedList<>();
		int step = 0, pathCount = 0;
		curLevl.add(A);
		while (curLevl.size() > 0 && step <= n) {
			Queue<GraphNode> nextLevl = new LinkedList<>();
			step++;
			while (curLevl.size() > 0) {
				GraphNode node = curLevl.poll();
				ArrayList<GraphNode> nodeList = node.nexts;
				for (GraphNode graphNode : nodeList) {
					if (graphNode == B && step == n) {
						pathCount++;
					}
					nextLevl.add(graphNode);
				}
			}
			curLevl = nextLevl;
		}
		return pathCount;
	}
}
