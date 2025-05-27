import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task27 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Liam");
        names.add("Anna");
        names.add("Bob");

        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("Sorted list:");
        names.forEach(System.out::println);
    }
}
