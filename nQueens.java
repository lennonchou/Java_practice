public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here.
    if (n <= 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    boolean[] lines = new boolean[n];
    boolean[] diag = new boolean[2 * n - 1];
    boolean[] antidiag = new boolean[2 * n - 1];
    nqueens(n, cur, lines, diag, antidiag, res);
    return res;
  }
  private void nqueens(int n, List<Integer> cur, boolean[] lines, boolean[] diag, boolean[] antidiag, List<List<Integer>> res) {
    if (cur.size() == n) {
      res.add(new ArrayList<Integer>(cur));
      return;
    }
    int row = cur.size();
    for (int i = 0; i < n; i++) {
      if (isValid(row, i, n, lines, diag, antidiag)) {
        lines[i] = true;
        diag[row + i] = true;
        antidiag[row - i + n - 1] = true;
        cur.add(i);
        nqueens(n, cur, lines, diag, antidiag, res);
        cur.remove(cur.size() - 1);
        lines[i] = false;
        diag[row + i] = false;
        antidiag[row - i + n - 1] = false;
      }
    }
  }
  private boolean isValid(int row, int i, int n, boolean[] lines, boolean[] diag, boolean[] antidiag) {
    if (lines[i] || diag[row + i] || antidiag[row - i + n - 1]) {
      return false;
    }
    return true;
  }
}
