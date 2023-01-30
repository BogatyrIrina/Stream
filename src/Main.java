import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        System.out.println("Задание 1");

        Stream <Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)).stream();

        findMinMax(
                stream,
                (x, y) -> x.compareTo(y),
                (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
        );

        stream.close();

        //Задание 2
        System.out.println("Задание 2");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().filter(n -> n % 2 == 0).count());

    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }

}
