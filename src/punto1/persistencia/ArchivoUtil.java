package punto1.persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ArchivoUtil {
    public static void registrarLog(String rutaLog, String mensaje) {
        try (FileWriter escrituraLog = new FileWriter(rutaLog, true)) {
            escrituraLog.write(LocalDateTime.now() + " - " + mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo log: " + e.getMessage());
        }
    }
}
