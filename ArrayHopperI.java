public class Solution {
  public boolean canJump(int[] array) {
    // Write your solution here.
    int n = array.length;
    boolean[] canJump = new boolean[n];
    canJump[n - 1] = true;
    for (int i = n - 2; i >= 0; i--) {
      if (i + array[i] >= n - 1) {
        canJump[i] = true;
      } else if (array[i] > 0) {
        for (int j = 1; j <= array[i]; j++) {
          if (canJump[i + j]) {
            canJump[i] = true;
            break;
          }
        }
      }
    }
    return canJump[0];
  }
}
