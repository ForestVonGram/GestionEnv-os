package punto1.persistencia;

import punto1.model.Envio;

import java.beans.XMLEncoder;
import java.io.*;

public class Serializacion {
    public static void guardarEnvioXML(Envio envio, String rutaArchivo, String rutaLog) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(rutaArchivo)))) {
            encoder.writeObject(envio);
            encoder.flush();
            ArchivoUtil.registrarLog(rutaLog, "Envio guardado en XML: " + envio.getCodigo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarEnvioBinario(Envio envio, String rutaArchivo, String rutaLog) {
        try (ObjectOutputStream objeto = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            objeto.writeObject(envio);
            ArchivoUtil.registrarLog(rutaLog, "Envio guardado en Binario: " + envio.getCodigo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
