package stack;

public class StackImplementationUsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack{
        Node top;
        Stack(){
            this.top = null;
        }
        void push(int value){
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }
        int pop(){
            if(top==null){
                System.out.println("Stack Underflow");
                return -1;
            }
            int value = top.data;
            top = top.next;
            return value;
        }
        int peek(){
            if(top==null){
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }
        void display(){
            if(top==null){
                System.out.println("Stack is empty");
                return;
            }
            Node temp = top;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    public static void main(String args[]){
        Stack st=new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(10);
        st.push(20);
        st.push(30);
        st.display();
        System.out.println("Popped "+ st.pop());
        System.out.println("Top element is "+st.peek());
        st.display();
    }
    
}
