package Classwork7;

public class Task8str {
    public static void main(String[] args) {
        String task1 = "423540";
        System.out.println("Task 1 result: ");
        if (task1.matches("\\d+")){
            int value = Integer.parseInt(task1);
            if(value%9==0){
                System.out.println("Divides by nine");
            }
            else{
                System.out.println("Is not divides by nine");
            }
            if(value%6==0){
                System.out.println("Divides by six");
            }
            else{
                System.out.println("Is not divides by six");
            }
            if(value%4==0){
                System.out.println("Divides by four");
            }
            else{
                System.out.println("Is not divides by four");
            }
        }
        else{
            System.out.println("Incorrect string for task1");
        }


        String task2 = "5abcde";
        System.out.println("\nTask 2 result: ");
        if (task2.matches("[1-9][a-zA-Z]+")){
            if(Character.getNumericValue(task2.charAt(0)) == task2.length() - 1){
                System.out.println("Task 2 is perfomed");
            }
            else{
                System.out.println("Task 2 is not perfomed");
            }
        }
        else{
            System.out.println("Incorrect input for task 2");
        }


        String task3 = "a5bde";
        System.out.println("\nTask 3 result: ");
        if (task3.matches("[a-zA-Z]*[0-9][a-zA-Z]*")){
           if(Integer.parseInt(task3.replaceAll("[^0-9]", "")) == task3.length()){
               System.out.println("Task 3 is perfomed");
           }
           else{
               System.out.println("Task 3 is not perfomed");
           }
        }
        else{
            System.out.println("Incorrect input for task 3");
        }

    }
}
