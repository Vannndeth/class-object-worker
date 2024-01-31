import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Worker worker = new Worker();
        worker.inputWorker(input);
        worker.displayWorker();
    }
}
