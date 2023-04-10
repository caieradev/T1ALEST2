import Services.MonkeyService;

public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 9; i++) {
            long start = System.currentTimeMillis();

            String fileName = "caso0" + i + ".txt";

            var service = new MonkeyService(fileName);

            long winner = service.perform();

            long finishtime = System.currentTimeMillis() - start;

            System.out.print(fileName);
            System.out.println(":\n\nO vencedor foi o macaco " + winner);

            System.out.println("\nDuração da execução: " + (double)(finishtime / 1000) + "s\n\n---------------\n");
        }
    }
}