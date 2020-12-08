package Classwork7;

public class Task6str {
    static int MakeInt(char[] arr, int counter, int i,boolean checker){

        int tmp_sum=0;
        while(true){
            tmp_sum+=Character.getNumericValue(arr[i-counter+1])*Math.pow(10,counter-1);
            if(counter==1){
                if (!checker) {
                    tmp_sum = -tmp_sum;
                }

                break;
            }
            counter--;
        }
        return tmp_sum;

    }

    public static void main(String[] args) {
        String inp="12+11-20-1+2-7+122";
        char[] arr = inp.toCharArray();
        int counter = 1;
        int sum= 0;
        boolean checker = true;
        for(int i=0;i<arr.length;i++){
            if(i+1 == arr.length){
                sum+=MakeInt(arr,counter,i,checker);
                break;
            }
            if(arr[i+1]!='+'&&arr[i+1]!='-'){
                counter++;
            }
            else if (arr[i+1]=='+') {
                sum+=MakeInt(arr,counter,i,checker);
                checker = true;
                counter =0;
            }
            else{
                sum+=MakeInt(arr,counter,i,checker);
                checker = false;
                counter =0;
            }

        }
        System.out.println("Result: " + sum);
    }
}
