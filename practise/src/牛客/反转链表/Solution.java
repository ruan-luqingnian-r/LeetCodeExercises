package 牛客.反转链表;

/**
 * @Author: ruan
 * Date: 2021/9/20 16:34
 * @Description:
 */
public class Solution {

    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode temp = head;
        ListNode next = null;
        while(temp != null){
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;

    }
}
