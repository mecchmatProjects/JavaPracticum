public class nonzero_sequence {
    public static void main(String[] args) {
        int n = - 5;
        int result = 0;
        for (int i = 0; i < Math.abs(n); i++){
            result++;
        }
        System.out.println(result);
    }
}
