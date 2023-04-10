package Services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import Entities.MacacoEntity;

public class MacacoService {
    private HashMap<Integer, MacacoEntity> macacos;
    private String fileName;
    private long rodadas;

    public MacacoService(String fileName) {
        this.fileName = fileName;
        this.macacos = new HashMap<>();
    }

    public long perform() throws Exception {
        this.persistMacacos();
        MacacoEntity winner = null;

        for (int i = 0; i < rodadas; i++) {
            for (var macaco : macacos.values()) {
                macacos.get(macaco.getSendOdd()).addAllEvenCocos(macaco.getEvenCocos());
                macacos.get(macaco.getSendEven()).addAllOddCocos(macaco.getOddCocos());
                macaco.removeAllCocos();
            }
        }

        for (var macaco : macacos.values()) {
            if (winner == null || (macaco.size() > winner.size())) {
                winner = macaco;
            }
        }

        return winner.getId();
    }

    private void persistMacacos() throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.charAt(0) == 'F') {
                rodadas = Long.parseLong(line.split(" ")[1]);

                if (rodadas == 0) {
                    do {
                        line = scanner.nextLine();
                    } while (scanner.hasNextLine() && line.charAt(0) != 'F');
                }
                continue;
            }

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
            int numCocos = Integer.parseInt(tokenizer.nextToken());

            MacacoEntity macaco = new MacacoEntity();
            macaco.setId(id);
            macaco.setSendEven(fromEven);
            macaco.setSendOdd(fromOdd);

            tokenizer.nextToken();

            for (int i = 0; i < numCocos; i++) {
                if (i % 2 == 0) {
                    macaco.addEvenCocos(i);
                } else {
                    macaco.addOddCocos(i);
                }
            }

            macacos.put(id, macaco);
        }

        scanner.close();
    }
}