package stack;
import java.util.Stack;;
public class DecodeStringLC394 {

    public static String decodeString(String s) {
        String cString="";
        Stack<String> st=new Stack<>();
        Stack<Integer> countSt=new Stack<>();
        int cNumber=0;
        for(char ch:s.toCharArray()){
            if (Character.isDigit(ch)){
                cNumber=cNumber*10+(ch-'0');
            }else if(ch=='['){
                countSt.push(cNumber);
                st.push(cString);
                cNumber=0;
                cString="";
            }
            else if(ch==']'){
                int count=countSt.pop();
                String pString=st.pop();
                StringBuilder temp=new StringBuilder();
                for(int i=0;i<count;i++){
                    temp.append(cString);
                }
                cString=pString+temp.toString();
            }
            else{
                cString+=ch;
            }
        }
        return cString;
        
    }
    public static void main(String[] args) {
        String s= "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}