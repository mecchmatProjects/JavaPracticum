/*Дана квадратная матрица размером n x n, содержащая вещественные числа.
 * Определить сумму элементов каждого столбца матрицы и
 * упорядочить номера столбцов по убыванию значений найденных сумм.
 * Вывести упорядоченный список номеров столбцов и соответствующих им сумм.*/

import java.util.*;

public class RandMatrix {

    private static final int SIZE = new Scanner(System.in).nextInt();

    public static void main(String[] args) {

        float[][] array = get2DArray(SIZE);
        for (int i = 0; i < SIZE; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        Map<Integer, Float> map = new HashMap<>(array.length);
        for (int i = 0; i < SIZE; i++) {
            float sum = 0;
            for (int j = 0; j < SIZE; j++) {
                sum += array[i][j];
            }
            map.put(i + 1, sum);
        }
        for (Map.Entry<Integer, Float> entry : sortByValues(map).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return new LinkedHashMap<>(sortedByValues);
    }

    private static float[][] get2DArray(int size) {
        Random random = new Random();
        float[][] array = new float[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = random.nextFloat();
            }
        }
        return array;
    }
}