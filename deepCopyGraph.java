/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode g : graph) {
      if (!map.containsKey(g)) {
        DFS(g, map);
      }
    }
    return new ArrayList<GraphNode>(map.values());
  }
  private void DFS(GraphNode seed, Map<GraphNode, GraphNode> map) {
    map.put(seed, new GraphNode(seed.key));
    GraphNode copy = map.get(seed);
    for (GraphNode nei : seed.neighbors) {
      if (!map.containsKey(nei)) {
        DFS(nei, map);
      }
      copy.neighbors.add(map.get(nei));
    }
  }
}
