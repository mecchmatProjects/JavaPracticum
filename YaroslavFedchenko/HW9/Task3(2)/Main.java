package Task3;
import java.io.FileNotFoundException;
// task 3(serializ) Fedchenko Yaroslav Дано файл F,  компоненти  якого  є  цілими  числами. Побудувати
//файл G, який містив би всі компоненти файла F:
//а) що є парними числами;   б) що діляться на 3 і на 5;
//в) що є точними квадратами;        г) записані у зворотному порядку;
//ґ) за винятком повторних входжень одного й того самого числа.
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Task3.FileHandler handler = new Task3.FileHandler("res/Task3/F");
        handler.numbersWithoutRepetitions();
    }


}
