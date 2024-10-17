package punto1.persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private Properties propiedades;

    public Configuracion(String rutaArchivo) {
        propiedades = new Properties();

        try (FileInputStream input = new FileInputStream(rutaArchivo)) {
            propiedades.load(input);
        } catch (IOException e) {
            System.out.println("Error al cargar la configuracion: " + e.getMessage());
        }
    }

    public String getRutaXML() {
        return propiedades.getProperty("ruta.xml");
    }

    public String getRutaBinario() {
        return propiedades.getProperty("ruta.bin");
    }

    public String getRutaLog() {
        return propiedades.getProperty("ruta.log");
    }

    public String getTipoZonaPredeterminada() {
            return propiedades.getProperty("tipo.zona");
    }
}
