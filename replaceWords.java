public class Solution {
  public String replace(String input, String s, String t) {
    // Write your solution here.
    char[] array = input.toCharArray();
    if (s.length() - t.length() >= 0) {
      return replaceShort(array, s, t);
    } else {
      return replaceLong(array, s, t);
    }
  }
  
  private String replaceShort(char[] input, String s, String t) {
    int slow = 0;
    int fast = 0;
    while (fast < input.length) {
      if (fast <= input.length - s.length() && isSubstring(input, fast, s)) {
        copyString(input, slow, t);
        slow += t.length();
        fast += s.length();
      } else {
        input[slow++] = input[fast++];
      }
    }
    return new String(input, 0, slow);
  }
  
  private String replaceLong(char[] input, String s, String t) {
    List<Integer> matches = getMatches(input, s); //store the end index of each match
    char[] result = new char[input.length + 
    matches.size() * (t.length() - s.length())];//new prolonged array to hold result
    int matchIndex = matches.size() - 1;
    int fast = input.length - 1;
    int slow = result.length - 1; //fast traverse old stirng, slow traverse new one
    while (fast >= 0) {
      if (matchIndex >= 0 && fast == matches.get(matchIndex)) {
        copyString(result, slow - t.length() + 1, t);
        fast -= s.length();
        slow -= t.length();
        matchIndex--;
      } else {
        result[slow--] = input[fast--];
      }
    }
    return new String(result);
  }
  
  private boolean isSubstring(char[] input, int start, String s) {
    for (int i = 0; i < s.length(); i++) {
      if (input[start + i] != s.charAt(i)) {
        return false;
      }
    }
    return true;
  }
  
  private void copyString(char[] input, int index, String t) {
    for (int i = 0; i < t.length(); i++) {
      input[index + i] = t.charAt(i);
    }
  }
  
  private List<Integer> getMatches(char[] input, String s) {
    int i = 0;
    List<Integer> result = new ArrayList<Integer>();
    while (i <= input.length - s.length()) {
      if (isSubstring(input, i, s)) {
        result.add(i + s.length() - 1);
        i += s.length();
      } else {
        i++;
      }
    }
    return result;
  }
}
