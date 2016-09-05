public class Solution {
  public int minJump(int[] array) {
    // Write your solution here.
    int n = array.length;
    int[] minJump = new int[n];
    minJump[0] = 0;
    for (int i = 1; i < n; i++) {
      minJump[i] = -1;
      for(int j = 0; j < i; j++) {
        if (minJump[j] != -1 && array[j] + j >= i) {
          if (minJump[i] == -1 || minJump[j] + 1 < minJump[i]) {
            minJump[i] = minJump[j] + 1;
          }
        }
      }
    }
    return minJump[n - 1];
  }
}
