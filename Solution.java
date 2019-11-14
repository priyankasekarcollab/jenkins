class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int carry = 0;
        ListNode node = new ListNode(-1);
        ListNode head = node;
        // Add l1 and l2
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            node.next = new ListNode(sum);
            node = node.next;
        }

        // Finish adding carry
        if (carry != 0) {
            node.next = new ListNode(carry);
        }

        return head.next;
    }
}

// Previous solution
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);
        ListNode dummy = rst;
        int carrier = 0;
        //while
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carrier += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carrier += l2.val;
                l2 = l2.next;
            }
            rst.next = new ListNode(carrier % 10);
            carrier = carrier / 10;
            rst = rst.next;
        }
        //check the carrier
        if (carrier == 1) {
            rst.next = new ListNode(1);
        }
        return dummy.next;
    }
}
