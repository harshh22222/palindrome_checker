import java.util.*;
public class Palin{
    public static void main( String[] args){
                String str = "A man a plan a canal Panama";
                str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                long start = System.nanoTime();

                Stack<Character> stack = new Stack<>();
                Queue<Character> queue = new LinkedList<>();

                for (char c : str.toCharArray()) {
                    stack.push(c);
                    queue.add(c);
                }

                boolean isPalindrome = true;
                while (!stack.isEmpty()) {
                    if (!stack.pop().equals(queue.remove())) {
                        isPalindrome = false;
                        break;
                    }
                }

                long end = System.nanoTime();

                System.out.println("Queue + Stack Method: " + isPalindrome);
                System.out.println("Time: " + (end - start) + " ns");
            }
        }