import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn  = new Scanner(System.in);
        
        String s = scn.nextLine();

        Stack<Character> st = new Stack<>();
        boolean result = true;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(ch == ')'){
                if(st.size() == 0 || st.peek() != '(')result = false;
                else{
                    st.pop();
                }
            }else if(ch == ']'){
                if(st.size() == 0 || st.peek() != '[')result = false;
                else{
                    st.pop();
                }
            }else if(ch == '}'){
                if(st.size() == 0 || st.peek() != '{')result = false;
                else{
                    st.pop();
                }
            }
        }
        if(result==false){
            System.out.println(false);
        }else{
        System.out.println(st.size() == 0);
        }
    }

}
