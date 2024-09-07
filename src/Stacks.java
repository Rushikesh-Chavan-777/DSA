import java.util.*;

public class Stacks {
    public static void pushatbottom(int data, Stack<Integer> s) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushatbottom(data, s);
        s.push(top);
    }
    public static void reversestack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reversestack(s);
        pushatbottom(top, s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        pushatbottom(0, s);
        System.out.println(s);
        reversestack(s);
        System.out.println(s);

    }
}
