public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    if (matrix == null || matrix.length == 0) {
      return new ArrayList<Integer>();
    }
    int n = matrix.length;
    if (matrix[0].length == 0) {
      return new ArrayList<Integer>();
    }
    int m = matrix[0].length;
    int left = 0, right = m - 1, up = 0, down = n - 1;
    List<Integer> res = new ArrayList<>();
    while (left < right && up < down) {
      for (int i = left; i < right; i++) {
        res.add(matrix[up][i]);
      }
      for (int i = up; i < down; i++) {
        res.add(matrix[i][right]);
      }
      for (int i = right; i > left; i--) {
        res.add(matrix[down][i]);
      }
      for (int i = down; i > up; i--) {
        res.add(matrix[i][left]);
      }
      up++;
      down--;
      left++;
      right--;
    }
    if (up == down) {
      for (int i = left; i <= right; i++) {
        res.add(matrix[up][i]);
      }
    } else if (left == right) {
      for (int i = up; i <= down; i++) {
        res.add(matrix[i][left]);
      }
    }
    return res;
  }
}
