public class Solution {
  public String reverseWords(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    int start = 0, end = 0;
    while (end < array.length) {
      while (end < array.length && array[end] != ' ') {
        end++;
      }
      reverse(array, start, end - 1);
      end++;
      start = end;
    }
    reverse(array, 0, array.length - 1);
    return new String(array);
  }
  private void reverse(char[] array, int i, int j) {
    while (i < j) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
      j--;
    }
  }
}
