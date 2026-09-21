package stack;
import java.util.Stack;

public class EvaluateReversePolishNotationLC150 {
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b=st.pop();
                int a=st.pop();
                int result=0;
                if(token.equals("+"))result=a+b;
                else if(token.equals("-"))result=a-b;
                else if(token.equals("*"))result=a*b;
                else result=a/b;
                st.push(result);
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
        
    }
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}