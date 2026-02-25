import java.util.ArrayDeque;
import java.util.Deque;

public class Palin {
    public static void main(String[] args) {
        String str = "A man a plan a canal Panama";
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        long start = System.nanoTime();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray())
            deque.addLast(c);

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        long end = System.nanoTime();

        System.out.println("Deque Method: " + isPalindrome);
        System.out.println("Time: " + (end - start) + " ns");
    }
}