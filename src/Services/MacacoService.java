package Services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import Entities.MacacoEntity;

public class MacacoService {
    private LinkedList<MacacoEntity> macacos;
    private String fileName;

    public MacacoService(String fileName) {
        this.fileName = fileName;
        this.macacos = new LinkedList<MacacoEntity>();
    }

    public long persistMacacos() throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        long rodadas = -1;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.charAt(0) == 'F')
            {
                rodadas = Long.parseLong(line.split(" ")[1]);
                
                if (rodadas == 0)
                {
                    do
                    {
                        line = scanner.nextLine();
                    }
                    while (scanner.hasNextLine() && line.charAt(0) != 'F');
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

            Queue<Integer> cocos = new LinkedList<>();
            for (int i = 0; i < numCocos; i++) {
                cocos.offer(Integer.parseInt(tokenizer.nextToken()));
            }
            macaco.setCocos(cocos);

            macacos.add(macaco);
        }

        scanner.close();

        return rodadas;
    }
}
