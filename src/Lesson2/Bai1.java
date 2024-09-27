package Lesson2;
import java.util.Stack;

public class Bai1 {
        public static String reverseString(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                stack.push(c);
            }
            StringBuilder reversed = new StringBuilder();
            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }

            return reversed.toString();
        }
        public static void main(String[] args) {
            String input = "hello";
            String reversed = reverseString(input);
            System.out.println(input);
            System.out.println(reversed);
        }
}
