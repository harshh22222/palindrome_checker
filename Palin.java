import java.util.*;
public class Palin{
    public static void main( String[] args){
                String str = "A man a plan a canal Panama";
                str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                long start = System.nanoTime();

                Stack<Character> stack = new Stack<>();
                for (char c : str.toCharArray())
                    stack.push(c);

                boolean isPalindrome = true;
                for (char c : str.toCharArray()) {
                    if (c != stack.pop()) {
                        isPalindrome = false;
                        break;
                    }
                }

                long end = System.nanoTime();

                System.out.println("Stack Method: " + isPalindrome);
                System.out.println("Time: " + (end - start) + " ns");

}}