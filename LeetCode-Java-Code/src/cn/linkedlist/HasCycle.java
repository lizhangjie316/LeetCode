package cn.linkedlist;

import java.util.HashSet;

public class HasCycle {

    public static void main(String[] args) {



    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> hashSet = new HashSet<>();

        while (hashSet.add(head)){
            head = head.next;
            if (head == null){
                return false;
            }
        }

        return true;
    }
}