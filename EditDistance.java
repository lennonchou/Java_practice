public class Solution {
  public int editDistance(String one, String two) {
    // Write your solution here.
    int n = one.length();
    int m = two.length();
    if (n == 0 || m == 0) {
      return n == 0 ? m : n;
    }
    int[][] dist = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0) {
          dist[i][j] = j;
        } else if (j == 0) {
          dist[i][j] = i;
        } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
          dist[i][j] = dist[i - 1][j - 1];
        } else {
          dist[i][j] = Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1);
          dist[i][j] = Math.min(dist[i][j], dist[i - 1][j - 1] + 1);
        }
      }
    }
    return dist[n][m];
  }
}
