import java.util.Stack;
import java.util.*;
public class RemoveInvalidParen {

    public static void ans(String str,int min,HashSet<String> ans){
        if(min==0){
            int nowmin=invalidParenthesis(str);
            if(nowmin==0){
                if(!ans.contains(str)){
                System.out.println(str);
                ans.add(str);
                }
            }
            return;
        }
        for(int i=0;i<str.length();i++){
            String left=str.substring(0,i);
            String right=str.substring(i+1);
            ans(left+right,min-1,ans);
        }
    }
    public static int invalidParenthesis(String str){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt((i));
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                if(st.size()==0){
                    st.push(ch);
                }
                else if(st.peek()==')'){
                    st.push(ch);
                }
                else if(st.peek()=='(')
                {
                    st.pop();
                }

            }
        }
        return st.size();
    }
    public static void main(String args[]){
        String str="((";
        int minRemoval=invalidParenthesis(str);
        ans(str, minRemoval,new HashSet<>());
    }
}

