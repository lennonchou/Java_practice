public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here.
    boolean[] canB = new boolean[input.length() + 1];
    canB[0] = true;
    Set<String> set = toSet(dict);
    for (int i = 1; i < canB.length; i++) {
      for (int j = 0; j < i; j++) {
        if (set.contains(input.substring(j, i)) && canB[j]) {
          canB[i] = true;
          break;
        }
      }
    }
    return canB[input.length()];
  }
  
  private Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>();
    for (String s : dict) {
      set.add(s);
    }
    return set;
  }
}
