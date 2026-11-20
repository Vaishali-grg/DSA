package queue;

import java.util.*;

public class LC23_MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.val,b.val)
        );
        for(ListNode node:lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(!pq.isEmpty()){
            ListNode s=pq.poll();
            tail.next=s;
            tail=tail.next;
            if(s.next!=null){
                pq.offer(s.next);
            }
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // List 1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // List 2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // List 3: 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode mergedHead = mergeKLists(lists);

        System.out.print("Merged k Sorted Lists: ");
        printList(mergedHead);
    }
}