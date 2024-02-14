import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {2,4,6,8,9,12};
        Integer[] newArray = filter(array, i -> (i%2==0));

        for (Integer integer : newArray) {
            System.out.println(integer);
        }
    }

    public static <T> T[] filter(T[] array, Function<? super T, Boolean> filter) {
        int notMissed = 0;

        for (int i = 0; i < array.length; i++) {
            if (!filter.apply(array[i])) {
                notMissed++;
            } else {
                array[i - notMissed] = array[i];
            }
        }

        return Arrays.copyOf(array, array.length - notMissed);
    }
}