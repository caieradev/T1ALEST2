import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.nio.file.Path;
import java.nio.file.Paths;

import Entities.MacacoEntity;

import java.util.LinkedList;

public class MacacoParser {

    public List<MacacoEntity> parseFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        scanner.nextLine();

        List<MacacoEntity> macacos = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // parse the line
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            tokenizer.nextToken();
            int id = Integer.parseInt(tokenizer.nextToken()); // get the id from the "Macaco X" string
            tokenizer.nextToken();
            tokenizer.nextToken();
            int fromEven = Integer.parseInt(tokenizer.nextToken()); // get the fromEven value
            tokenizer.nextToken();
            tokenizer.nextToken(); // discard the "->" string
            int fromOdd = Integer.parseInt(tokenizer.nextToken()); // get the fromOdd value
            tokenizer.nextToken(); // discard the ":" string
            int numCocos = Integer.parseInt(tokenizer.nextToken()); // get the number of coconuts

            // create a new MacacoEntity object
            MacacoEntity macaco = new MacacoEntity();
            macaco.setId(id);
            macaco.setSendEven(fromEven);
            macaco.setSendOdd(fromOdd);

            tokenizer.nextToken();

            // create the queue of coconuts
            Queue<Integer> cocos = new LinkedList<>();
            for (int i = 0; i < numCocos; i++) {
                cocos.offer(Integer.parseInt(tokenizer.nextToken()));
            }
            macaco.setCocos(cocos);

            // add the new MacacoEntity to the list
            macacos.add(macaco);
        }

        scanner.close();
        return macacos;
    }
}
