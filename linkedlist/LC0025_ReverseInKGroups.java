package linkedlist;

public class LC0025_ReverseInKGroups {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node reverseKGroup(Node head, int k) {
        if(k==1 || head==null || head.next==null )return head;

        Node temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        


        Node dummy=new Node(-1);
        dummy.next=head;
        Node prevGrp=dummy;
        Node curr=head;
        while(length>=k){
            Node grpHead=curr;
            Node prev=null;
            for(int i=0;i<k;i++){
                Node fwd=curr.next;
                curr.next=prev;
                prev=curr;
                curr=fwd;
            }

            prevGrp.next=prev;
            grpHead.next=curr;

            prevGrp=grpHead;
            length-=k;
        }
        return dummy.next;
        
        
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 2;
        head = reverseKGroup(head, k);
        print(head); // Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
    }
}

