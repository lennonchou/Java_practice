public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here.
    if (combo == null || combo.length == 0 || k <= 0) {
      return new String[0];
    }
    Map<String, Integer> map = getMap(combo);
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue().equals(e2.getValue())) {
          return 0;
        }
        return e1.getValue() < e2.getValue() ? -1 : 1;
      }
    });
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry);
      } else if (entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    String[] res = new String[minHeap.size()];
    for (int i = minHeap.size() - 1; i >= 0; i--) {
      res[i] = minHeap.poll().getKey();
    }
    return res;
  }
  private Map<String, Integer> getMap(String[] combo) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : combo) {
      if (map.get(s) == null) {
        map.put(s, 1);
      } else {
        map.put(s, map.get(s) + 1);
      }
    }
    return map;
  }
}
