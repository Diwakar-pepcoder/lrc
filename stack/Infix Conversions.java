import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Character> operator = new Stack<>();
    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    
    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);

        if( 'a' <= ch && ch <= 'z' ){
            pre.push(ch+"");
            post.push(ch+"");
        }else if(ch == '('){
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.peek() != '(')solve(pre, post, operator);
            operator.pop();
        }else if(ch != ' '){
            while(operator.size() > 0 && priority(operator.peek()) >= priority(ch) && operator.peek() != '('){
                solve(pre, post, operator);
            }
            operator.push(ch);
        }
    }

    while(operator.size() > 0){
        solve(pre, post, operator);
    }

    System.out.println(post.pop());
    System.out.println(pre.pop());
    
 }
 
 static void solve(Stack<String> pre, Stack<String> post,Stack<Character> operator){
    
    String v2 = pre.pop();
    String v1 = pre.pop();
    char op = operator.pop();

    pre.push(op+v1+v2);

    v2 = post.pop();
    v1 = post.pop();
    // op = operator.pop();// wront

    post.push(v1+v2+op);


 }
 
 static int priority(char ch){
        if(ch == '*' || ch == '/')return 1;
        return 0;
 }
 
}