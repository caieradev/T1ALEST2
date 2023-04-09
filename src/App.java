import java.io.IOException;
import java.util.List;

import Entities.MacacoEntity;
import Services.MacacoService;

public class App {
    public static void main(String[] args) throws IOException {
        String fileName = "caso08.txt";

        var service = new MacacoService(fileName);

        long rodadas = service.persistMacacos();

        if (rodadas == -1)
            System.err.println("Ocorreu um erro ao ler o arquivo");
        else
            System.out.println(rodadas);

    }
}
