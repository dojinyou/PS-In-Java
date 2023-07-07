package problemsolving.programmers.highscorekit.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution49189 {
  private static final int START_NODE = 1;
  private static final int MAX_COUNT_NODES = 20000;

  private final Map<Integer, List<Integer>> edgeMap = new HashMap<>(MAX_COUNT_NODES);

  public int solution(
      int n,
      int[][] edge
  ) {

    initEdgeMap(edge);

    int[] distanceFromStartNode = new int[n + 1];
    updateDistance(distanceFromStartNode);

    return getCountMaxDistanceNode(distanceFromStartNode);
  }

  private int getCountMaxDistanceNode(int[] distanceFromStartNode) {
    int maxDistance = 0;
    int count = 0;

    for (int i = START_NODE + 1; i < distanceFromStartNode.length; i++) {
      if (maxDistance == distanceFromStartNode[i]) {
        count++;
      }

      if (maxDistance < distanceFromStartNode[i]) {
        maxDistance = distanceFromStartNode[i];
        count = 1;
      }
    }

    return count;
  }

  private void updateDistance(int[] distanceArray) {
    Queue<int[]> queue = new ArrayDeque<>(distanceArray.length - 2);
    int distance = 0;
    queue.add(new int[]{START_NODE, distance});

    while (!queue.isEmpty()) {
      int[] info = queue.poll();
      int curNode = info[0];
      int curDistance = info[1];

      List<Integer> edge = edgeMap.get(curNode);
      for (Integer to : edge) {
        if (to != START_NODE && distanceArray[to] == 0) {
          queue.add(new int[]{to, curDistance + 1});
          distanceArray[to] = curDistance + 1;
        }
      }
    }
  }

  private void initEdgeMap(int[][] edge) {
    for (int[] info : edge) {
      int node1 = info[0];
      int node2 = info[1];
      setEdge(node1, node2);
      setEdge(node2, node1);
    }
  }

  private void setEdge(
      int from,
      int to
  ) {
    if (!edgeMap.containsKey(from)) {
      edgeMap.put(from, new LinkedList<>());
    }

    edgeMap
        .get(from)
        .add(to);
  }

  public static void main(String[] args) {
    new Solution49189().solution(6, new int[][]{{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}});
  }
}
