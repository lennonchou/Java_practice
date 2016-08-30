/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (head != null && head.next != null) {
      ListNode next = head.next;
      head.next = next.next;
      next.next = head;
      cur.next = next;
      head = head.next;
      cur = cur.next.next;
    }
    return dummy.next;
  }
}
