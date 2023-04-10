package Services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import Entities.MonkeyEntity;

public class MonkeyService {
    private HashMap<Integer, MonkeyEntity> monkeys;
    private Map<Integer, Integer> evenReceivers;
    private Map<Integer, Integer> oddReceivers;
    private String fileName;
    private long rounds;

    public MonkeyService(String fileName) {
        this.fileName = fileName;
        this.monkeys = new HashMap<>();
        this.evenReceivers = new HashMap<>();
        this.oddReceivers = new HashMap<>();
    }

    public long perform() throws Exception {
        this.persistMonkeys();
        MonkeyEntity winner = null;
    
        for (int i = 0; i < rounds; i++) {
            for (var monkey : monkeys.values()) {
                if (monkey.getSendEven() != 0) {
                    MonkeyEntity receiver = monkeys.get(evenReceivers.get(monkey.getId()));
                    receiver.sumEvenCocos(monkey.getEvenCocos());
                }
                if (monkey.getSendOdd() != 0) {
                    MonkeyEntity receiver = monkeys.get(oddReceivers.get(monkey.getId()));
                    receiver.sumOddCocos(monkey.getOddCocos());
                }
                monkey.removeAllCocos();
            }
        }
    
        for (var monkey : monkeys.values()) {
            if (winner == null || (monkey.size() > winner.size())) {
                winner = monkey;
            }
        }
    
        return winner.getId();
    }

    private void persistMonkeys() throws IOException {
        Path path = Paths.get("assets" + System.getProperty("file.separator") + fileName);
        Scanner scanner = new Scanner(path);

        rounds = Long.parseLong(scanner.nextLine().split(" ")[1]);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            tokenizer.nextToken();
            int id = Integer.parseInt(tokenizer.nextToken());
            tokenizer.nextToken();
            tokenizer.nextToken();
            int fromEven = Integer.parseInt(tokenizer.nextToken());
            tokenizer.nextToken();
            tokenizer.nextToken();
            int fromOdd = Integer.parseInt(tokenizer.nextToken());
            tokenizer.nextToken();
            int numberOfCoconuts = Integer.parseInt(tokenizer.nextToken());

            MonkeyEntity monkey = new MonkeyEntity();
            monkey.setId(id);
            monkey.setSendEven(fromEven);
            monkey.setSendOdd(fromOdd);

            tokenizer.nextToken();

            for (int i = 0; i < numberOfCoconuts; i++) {
                if (i % 2 == 0) {
                    monkey.addEvenCocos();
                } else {
                    monkey.addOddCocos();
                }
            }

            monkeys.put(id, monkey);
        }

        scanner.close();
    
        for (var monkey : monkeys.values()) {
            evenReceivers.put(monkey.getId(), monkey.getSendEven());
            oddReceivers.put(monkey.getId(), monkey.getSendOdd());
        }
    }
}