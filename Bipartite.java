/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // write your solution here
    if (graph == null) {
      return true;
    }
    Set<GraphNode> visited = new HashSet<>();
    Map<GraphNode, Integer> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (visited.add(node)) {
        map.put(node, 0);
        if (!DFS(node, visited, map)) {
          return false;
        }
      }
    }
    return true;
  }
  private boolean DFS(GraphNode seed, Set<GraphNode> visited, Map<GraphNode, Integer> map) {
    int grp = map.get(seed);
    int neiGrp = grp == 0 ? 1 : 0;
    for (GraphNode nei : seed.neighbors) {
      if (visited.add(nei)) {
        map.put(nei, neiGrp);
        if (!DFS(nei, visited, map)) {
          return false;
        }
      } else if (map.get(nei) != neiGrp) {
        return false;
      }
    }
    return true;
  }
}
