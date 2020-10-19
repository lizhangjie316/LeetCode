package cn.linkedlist;


public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = new Solution10().swapPairs(head);
        System.out.println("hahaha");
        
    }
}

class Solution10 {
    //交换相邻的两个
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        //确保有两个节点了
        ListNode cur = head;
        ListNode pre = cur.next;
        ListNode back = null;
        head = cur.next;
        //返回的头已经确定
        while (cur!=null || pre!=null){
            //交换

            cur.next = pre.next;
            pre.next = cur;
            if (cur.next == null || cur.next.next==null){
                break;
            }else {
                back = cur;
                cur = cur.next;
                pre = cur.next;
                back.next = pre;
            }
        }

        return head;
    }
}

class Solution11 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode Next = head.next;
        head.next = swapPairs(Next.next); //
        Next.next = head;
        return Next;
    }
}

class Solution12 {
    public ListNode swapPairs(ListNode head) { //实际上使用了四个指针
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {  //头插法
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}


class Solution13 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {  //使用上边的方法，这部分则可以省略
            return head;
        }

        ListNode Lhead = new ListNode(0);
        Lhead.next = head;
        ListNode tmp = Lhead;
        ListNode end = head.next; //不在外面移动，直接去循环里面判断，去移动
        while (tmp.next != null && tmp.next.next!=null) {
            //进行头插
            head.next = end.next;
            end.next = head;
            tmp.next = end;
            //头插完成，分别移动三个指针    但这块恶心的是可能会引发空指针，所以还是上边的头插比较好，进了循环之后直接进行
            tmp = head;
            head = head.next;
            end = head.next.next;
        }
        return Lhead.next;
    }
}