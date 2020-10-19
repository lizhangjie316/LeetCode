package cn.Practice;


class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode t_mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


    public ListNode i_mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode pre = head;
        head.next = l1;
        pre = head;
        ListNode tmp = null;
        while (l2 != null && l1 != null) {
            if (l1.val >= l2.val) {//l2插进来
                tmp = l2.next;
                l2.next = l1;
                pre.next = l2;

                //状态转移
                pre = l2;
                l2 = tmp;

            }else{ //l1.val < l2.val  l1后移一位
                pre = l1;
                l1 = l1.next;
            }
        }
        if (l1==null) {
            pre.next = l2;
        }
        pre.next = l1==null? l2:l1;

        return head.next;
    }


}
