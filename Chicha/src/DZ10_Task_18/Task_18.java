/*
Чича Олександр

18. На прямій гоночній трасі курсує N автомобілів, для кожного з яких відомі початкове положення і швидкість.
 Визначити, скільки відбудеться обгонів.
 */

package DZ10_Task_18;

public class Task_18 {
    public static int CheckCount(int[] therePlacesNow, int[] thereSpeed){
        int count = 0;
        for (int i = 0;i<thereSpeed.length;i++){
            for (int j = 0;j<thereSpeed.length;j++){
                if ((therePlacesNow[i] > therePlacesNow[j])&&(thereSpeed[i] > thereSpeed[j])){
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] thereSpeed = {2, 3 , 4, 1};

        // На якому вони зараз місці
        int[] therePlacesNow = {4, 2, 3, 1};

        System.out.println(CheckCount(therePlacesNow, thereSpeed));
    }
}
