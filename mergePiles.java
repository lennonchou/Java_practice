public class Solution {
  public int minCost(int[] stones) {
    // Write your solution here.
    int len = stones.length;
    int[][] cost = new int[len][len];//cost[i][j] is the min cost to merge stones from index i to j including i and j.
    int[][] weight = new int[len][len];//weight[i][j] is the total weight of stones from index i to j including i and j.
    for (int i = 0; i < len; i++) {
      for (int j = i; j >= 0; j--) {
        if (i == j) {
          cost[j][i] = 0;
          weight[j][i] = stones[i];
        } else {
          weight[j][i] = weight[j][i - 1] + stones[i];
          cost[j][i] = Integer.MAX_VALUE;
          for (int k = j; k < i; k++) {
            cost[j][i] = Math.min(cost[j][i], cost[j][k] + cost[k + 1][i] + weight[j][i]);
          }
        }
      }
    }
    return cost[0][len - 1];
  }
}
