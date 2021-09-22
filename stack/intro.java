import java.util.*;

public class intro {
    public static void main(String[] args) {
        
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st+" "+st.size());

        st.push(4);
        System.out.println(st+" "+st.size());

        int val = st.pop();
        System.out.println(val +" "+st);

        val = st.peek();
        System.out.println(val +" "+st);

    }
}
