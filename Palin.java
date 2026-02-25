import java.util.*;
public class Palin{
    public static void main( String[] args){
                String str = "A man a plan a canal Panama";
                str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                char[] arr = str.toCharArray();

                long start = System.nanoTime();

                boolean isPalindrome = true;
                int left = 0, right = arr.length - 1;

                while (left < right) {
                    if (arr[left] != arr[right]) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }

                long end = System.nanoTime();

                System.out.println("Char Array Method: " + isPalindrome);
                System.out.println("Time: " + (end - start) + " ns");
}}