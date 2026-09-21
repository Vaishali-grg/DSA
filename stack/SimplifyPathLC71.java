package stack;
import java.util.Stack;

public class SimplifyPathLC71 {
    
    public static String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] pt=path.split("/");
        for(String p:pt){
            if(p.equals("")||p.equals(".")){
                continue;
            }
            else if(p.equals("..")){
                if(!st.isEmpty())st.pop();
            }
            else {
                st.push(p);
            }
        }
        StringBuilder res=new StringBuilder();
        for(String f:st){
            res.append("/");
            res.append(f);
        }
        if(res.length()==0)return "/";
        else return res.toString();


    }

    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));
    }
}