/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: IntersectingLinkedList
 * @Author: 小天才
 * Date: 2021/6/4 14:39
 * project name: LeetCodeExercises
 * @Version: 0.0.1
 * @Description: leetcode 160. 相交链表
 */

 class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
         val = x;
          next = null;
     }
}
public class IntersectingLinkedList {

    public static void main(String[] args) {
        IntersectingLinkedList intersectingLinkedList = new IntersectingLinkedList();

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建辅助节点用于遍历链表
        ListNode trmpA = headA;
        ListNode trmpB = headB;
        if(headA == null || headB == null){
            return null;
        }
        while(trmpA != trmpB){
            trmpA = trmpA.next;
            trmpB = trmpB.next;
            if(trmpA == null && trmpB == null){
                return null;
            }
            if(trmpA == null){
                trmpA = trmpB;
            }
            if(trmpB == null){
                trmpB= trmpA;
            }
        }
        return trmpA;

    }
}