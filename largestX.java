public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int n = matrix.length;
    if (n == 0) {
      return 0;
    }
    int m = matrix[0].length;
    if (m == 0) {
      return 0;
    }
    int[][] up = upperX(matrix, n, m);
    int[][] down = downX(matrix, n, m);
    return merge(up, down, n, m);
  }
  private int[][] upperX(int[][] matrix, int n, int m) {
    int[][] NW = new int[n][m];
    int[][] NE = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 1) {
          NW[i][j] = getValue(NW, i - 1, j - 1, n, m) + 1;
          NE[i][j] = getValue(NE, i - 1, j + 1, n, m) + 1;
        }
      }
    }
    merge(NW, NE, n, m);
    return NW;
  }
  private int[][] downX(int[][] matrix, int n, int m) {
    int[][] SW = new int[n][m];
    int[][] SE = new int[n][m];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          SW[i][j] = getValue(SW, i + 1, j - 1, n, m) + 1;
          SE[i][j] = getValue(SE, i + 1, j + 1, n, m) + 1;
        }
      }
    }
    merge(SW, SE, n, m);
    return SW;
  }
  private int getValue(int[][] matrix, int i, int j, int n, int m) {
    if (i < 0 || i >= n || j < 0 || j >= m) {
      return 0;
    }
    return matrix[i][j];
  }
  private int merge(int[][] left, int[][] right, int n, int m) {
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        left[i][j] = Math.min(left[i][j], right[i][j]);
        result = Math.max(result, left[i][j]);
      }
    }
    return result;
  }
}
