import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivo {


    public void guardarJson(Moneda moneda)  {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = null;
        try {
            escritura = new FileWriter("consultas.json");
            escritura.write(gson.toJson(moneda));
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}
