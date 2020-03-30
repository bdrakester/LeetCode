/**
 * 2. Add Two Numbers
 * Medium
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode result = new ListNode(0);
        ListNode c = result;
        int sum = 0;

        while (a != null || b != null) {
            c.next = new ListNode(0);
            c = c.next;

            if (a != null) {
                sum = sum + a.val;
                a = a.next;
            }

            if (b != null) {
                sum = sum + b.val;
                b = b.next;
            }

            // Sum greater than 10, carry the one
            if (sum > 9) {
                c.val = sum - 10;
                sum = 1;
            }
            // Else no carry
            else {
                c.val = sum;
                sum = 0;
            }

        }

        // Carry the final 1 if necessary
        if (sum == 1) {
            c.next = new ListNode(1);
        }

        return result.next;
    }
}

