import java.io.IOException;
import java.security.Timestamp;
import java.util.List;

import Entities.MacacoEntity;

public class App {
    public static void main(String[] args) throws IOException {
        String fileName = "caso08.txt"; // replace with your file name

        long start = System.currentTimeMillis();

        List<MacacoEntity> macacos = new MacacoParser().parseFile(fileName);

        long time = System.currentTimeMillis() - start;

        System.out.println(time);
    }
}
