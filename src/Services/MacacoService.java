package Services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Entities.CocoEntity;
import Entities.MacacoEntity;

public class MacacoService {
    private HashMap<Integer, MacacoEntity> macacos;
    private String fileName;

    public MacacoService(String fileName) {
        this.fileName = fileName;
        this.macacos = new HashMap<Integer, MacacoEntity>();
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

            LinkedList<CocoEntity> cocos = new LinkedList<>();
            for (int i = 0; i < numCocos; i++) {
                cocos.add(new CocoEntity(Integer.parseInt(tokenizer.nextToken())));
            }
            macaco.setCocos(cocos);

            macacos.put(id, macaco);
        }

        scanner.close();

        return rodadas;
    }

    public long perform(long rodadas) throws Exception {
        MacacoEntity winner = new MacacoEntity();

        for (int i = 0; i < rodadas; i++)
        {
            for (var macaco : macacos.values())
            {
                var oddCocos = new LinkedList<CocoEntity>();
                var evenCocos = new LinkedList<CocoEntity>();
                
                macaco.getCocos()
                    .stream()
                    .forEach(x -> {
                        if (x.isEven())
                            oddCocos.add(x);
                        else
                            evenCocos.add(x);
                    });
                
                macaco.setCocos(new LinkedList<CocoEntity>());
                
                macacos.get(macaco.getSendOdd()).getCocos().addAll(oddCocos);
                macacos.get(macaco.getSendEven()).getCocos().addAll(evenCocos);
            }
        }

        for (var macaco : macacos.values())
        {
            if (macaco == null || (macaco.getCocos().size() > winner.getCocos().size()))
                winner = macaco;
        }

        return winner.getId();
    }
}
