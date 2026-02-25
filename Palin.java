import java.util.*;

public class Palin {

    // Common preprocessing (case insensitive + ignore spaces/symbols)
    static String cleanString(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // UC3 - Reverse Method
    static boolean reverseMethod(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // UC4 - Character Array (Two Pointer)
    static boolean charArrayMethod(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    // UC5 - Stack Method
    static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray())
            stack.push(c);

        for (char c : str.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }

    // UC6 - Queue + Stack Method
    static boolean queueStackMethod(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove()))
                return false;
        }
        return true;
    }

    // C7 - Deque Method
    static boolean dequeMethod(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== PALINDROME CHECKER MENU =====");
        System.out.println("1. Reverse Method");
        System.out.println("2. Character Array Method");
        System.out.println("3. Stack Method");
        System.out.println("4. Queue + Stack Method");
        System.out.println("5. Deque Method");
        System.out.println("6. Run All Methods");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String cleaned = cleanString(input);

        boolean result = false;
        long start, end;

        switch (choice) {

            case 1:
                start = System.nanoTime();
                result = reverseMethod(cleaned);
                end = System.nanoTime();
                printResult("Reverse Method", result, start, end);
                break;

            case 2:
                start = System.nanoTime();
                result = charArrayMethod(cleaned);
                end = System.nanoTime();
                printResult("Character Array Method", result, start, end);
                break;

            case 3:
                start = System.nanoTime();
                result = stackMethod(cleaned);
                end = System.nanoTime();
                printResult("Stack Method", result, start, end);
                break;

            case 4:
                start = System.nanoTime();
                result = queueStackMethod(cleaned);
                end = System.nanoTime();
                printResult("Queue + Stack Method", result, start, end);
                break;

            case 5:
                start = System.nanoTime();
                result = dequeMethod(cleaned);
                end = System.nanoTime();
                printResult("Deque Method", result, start, end);
                break;

            case 6:
                runAll(cleaned);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }

    static void printResult(String method, boolean result, long start, long end) {
        System.out.println("\n--- " + method + " ---");
        System.out.println("Palindrome: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    static void runAll(String str) {
        long start, end;

        start = System.nanoTime();
        boolean r1 = reverseMethod(str);
        end = System.nanoTime();
        printResult("Reverse Method", r1, start, end);

        start = System.nanoTime();
        boolean r2 = charArrayMethod(str);
        end = System.nanoTime();
        printResult("Character Array Method", r2, start, end);

        start = System.nanoTime();
        boolean r3 = stackMethod(str);
        end = System.nanoTime();
        printResult("Stack Method", r3, start, end);

        start = System.nanoTime();
        boolean r4 = queueStackMethod(str);
        end = System.nanoTime();
        printResult("Queue + Stack Method", r4, start, end);

        start = System.nanoTime();
        boolean r5 = dequeMethod(str);
        end = System.nanoTime();
        printResult("Deque Method", r5, start, end);
    }
}