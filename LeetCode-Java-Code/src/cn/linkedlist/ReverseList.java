package cn.linkedlist;

import java.util.List;

public class ReverseList {

    public static void main(String[] args) {

    }
}

class Solution00 {//画个图就出来了
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;// cur - pre - tmp
        ListNode pre = head;
        while (pre != null){
            ListNode tmp = pre.next; //探索者
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}




