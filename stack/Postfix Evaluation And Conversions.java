import java.io.*;
import java.util.*;
public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Integer> value = new Stack<>();
    Stack<String> in = new Stack<>();
    Stack<String> pre = new Stack<>();

    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        
        if('0' <= ch && ch <= '9'){
            value.push(ch-'0');
            in.push(ch+"");
            pre.push(ch+"");
        }else{
            solve(value, in, pre, ch);
        }
    }

    System.out.println(value.pop());
    System.out.println(in.pop());
    System.out.println(pre.pop());
 }

 static void solve(Stack<Integer> value, Stack<String> in,Stack<String> pre, char op){
    
    String v2 = pre.pop();
    String v1 = pre.pop();

    pre.push(op+v1+v2);
    v2 = in.pop();
    v1 = in.pop();
    // op = operator.pop();// wront

    in.push("("+v1+op+v2+")");

    int b = value.pop();
    int a = value.pop();
    // char op = operator.pop();

    if(op == '+')value.push(a+b);
    else if(op == '-')value.push(a-b);
    else if(op == '*')value.push(a*b);
    else value.push(a/b);

 }

}