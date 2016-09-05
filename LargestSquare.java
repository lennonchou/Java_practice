public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int[][] dp = new int[matrix.length][matrix.length];
    int res = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] == 1) {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          }
          res = Math.max(res, dp[i][j]);
        }
      }
    }
    return res;
  }
}
