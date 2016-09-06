public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here.
    int n = matrix.length;
    int m = matrix[0].length;
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int[] array = new int[m];
      for (int j = i; j < n; j++) {
        add(array, matrix, j, m);
        result = Math.max(result, largest(array));
      }
    }
    return result;
  }
  
  private void add(int[] array, int[][] input, int line, int size) {
    for (int i = 0; i < size; i++) {
      array[i] += input[line][i];
    }
  }
  private int largest(int[] array) {
    int curr = array[0];
    int result = curr;
    for (int i = 1; i < array.length; i++) {
      curr = Math.max(curr + array[i], array[i]);
      result = Math.max(result, curr);
    }
    return result;
  }
}
