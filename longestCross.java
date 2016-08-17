public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    if (matrix.length == 0) {
      return 0;
    }
    if (matrix[0].length == 0) {
      return 0;
    }
    int[][] leftUp = leftUp(matrix, matrix.length, matrix[0].length);
    int[][] bottomRight = bottomRight(matrix, matrix.length, matrix[0].length);
    
    
    return merge(leftUp, bottomRight, matrix.length, matrix[0].length);
  }
  
  private int[][] leftUp(int[][] input, int n, int m) {
    int[][] left = new int[n][m];
    int[][] up = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (input[i][j] == 1) {
          if (i == 0 && j == 0) {
            up[i][j] = 1;
            left[i][j] = 1;
          } else if (i == 0) {
            up[i][j] = 1;
            left[i][j] = left[i][j - 1] + 1;
          } else if (j == 0) {
            up[i][j] = up[i - 1][j] + 1;
            left[i][j] = 1;
          } else {
            up[i][j] = up[i - 1][j] + 1;
            left[i][j] = left[i][j - 1] + 1;
          }
        }
      }
    }
    merge(left, up, n, m);
    return left;
  }
  
  private int[][] bottomRight(int[][] input, int n, int m) {
    int[][] bottom = new int[n][m];
    int[][] right = new int[n][m];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (input[i][j] == 1) {
          if (i == n - 1 && j ==  m - 1) {
            bottom[i][j] = 1;
            right[i][j] = 1;
          } else if (i == n - 1) {
            bottom[i][j] = 1;
            right[i][j] = right[i][j + 1] + 1;
          } else if (j == m - 1) {
            bottom[i][j] = bottom[i + 1][j] + 1;
            right[i][j] = 1;
          } else {
            bottom[i][j] = bottom[i + 1][j] + 1;
            right[i][j] = right[i][j + 1] + 1;
          }
        }
      }
    }
    merge(bottom, right, n, m);
    return bottom;
  }
  
  private int merge(int[][] one, int[][] two, int n, int m) {
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        one[i][j] = Math.min(one[i][j], two[i][j]);
        result = Math.max(result, one[i][j]);
      }
    }
    return result;
  }
}
