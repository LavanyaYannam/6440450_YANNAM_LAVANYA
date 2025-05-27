import java.util.concurrent.*;
import java.util.*;

public class task41 {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
            () -> "Task 1 result",
            () -> "Task 2 result",
            () -> "Task 3 result"
        );

        List<Future<String>> results = service.invokeAll(tasks);

        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        service.shutdown();
    }
}
