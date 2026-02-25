import java.util.*;
public class Palindrome{
    public static void main( String[] args){
        String r="Abcdefghij";
        r=r.toLowerCase(r);
        String a= new StringBuilder(r).reverse().toString();
        if(a.equals(r)) {
            System.out.println("yes");
        }}
}