
import java.util.*;
import java.util.concurrent.*;
class MyCallable implements Callable<String> {


    public String call() {

        return "Callable";

    }

}

public class Test {

    public static void main(String[] args) throws Exception {

        FutureTask<String> task = new FutureTask<>(new MyCallable());

        new Thread(task).start();

        System.out.println(task.get());

    }

}