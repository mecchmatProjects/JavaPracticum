package Classwork7;

public class Task1str {
    public static void main(String[] args) {
        String inp = "qph12-cb13  +ph23 -98cbk+1olph9i";


        String s1 = inp.replaceAll("\\d", "");
        s1 = s1.replaceAll("\\+", "++");
        s1 = s1.replaceAll("-", "--");
        System.out.println("Task 1: "+s1);

        String s2 = inp.replaceAll("(\\+)(\\d)", "$2");
        System.out.println("Task 2: "+s2);

        String s3 = inp.replaceAll("cb","c");
        System.out.println("Task 3: "+s3);

        String s4 = inp.replaceAll("ph","f");
        System.out.println("Task 4: "+s4);

        String s5 = inp.replaceAll("\\s+", " ");
        System.out.println("Task 5: "+s5);





    }
}
